package extra;

import java.io.Console;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CofeeMachine {
    public static class OutOfStockException extends RuntimeException {
        OutOfStockException(Drink drink) {
            super(drink.toString());
        }
    }
    private Map<Ingredient, Integer> stock = new HashMap<Ingredient, Integer>();
    public int getStock(Ingredient ingredient) {
        return this.stock.containsKey(ingredient) ?
                this.stock.get(ingredient) : 0;
    }
    public void restock() {
        for (Ingredient ingredient : Ingredient.values()) {
            if (this.getStock(ingredient) < 10) {
                this.stock.put(ingredient, 10);
            }
        }
    }
    public Drink[] menu() {
        return Drink.values();
    }
    public boolean canMake(Drink drink) {
        for (Map.Entry<Ingredient, Integer> quantStuff : drink.getRecipe().entrySet()) {
            if (this.getStock(quantStuff.getKey()) < quantStuff.getValue()) {
                return false;
            }
        }
        return true;
    }
    public void make(Drink drink) throws OutOfStockException {
        if (!this.canMake(drink)) {
            throw new OutOfStockException(drink);
        }
        for (Map.Entry<Ingredient, Integer> quantStuff : drink.getRecipe().entrySet()) {
            int quant = quantStuff.getValue();
            Ingredient stuff = quantStuff.getKey();
            this.stock.put(stuff, this.getStock(stuff) - quant);
        }
    }
    public String toString() {
        StringBuilder out = new StringBuilder("Inventory:\n");
        for (Ingredient ingredient : Ingredient.values()) {
            out.append(ingredient).append(": ")
                    .append(this.getStock(ingredient)).append('\n');
        }
        out.append("\nMenu:\n");
        int i = 0;
        for (Drink drink : Drink.values()) {
            out.append(++i).append(": ").append(drink);
            if (this.canMake(drink)) {
                out.append(", $").append(drink.getPrice());
            } else {
                out.append(" (out of stock)");
            }
            out.append('\n');
        }
        return out.toString();
    }
    private static String prompt(Console con, String prompt) {
        con.printf("%s", prompt);
        return con.readLine();
    }
    public static void main(String[] args) {
        CofeeMachine machine = new CofeeMachine();
        machine.restock();
        Console con = System.console();
        System.out.println(machine);
        Scanner command = new Scanner(System.in);
        boolean running = true;
        while (running) {
            String cmd = command.nextLine();
            if (cmd.isEmpty()) {
                continue;
            } else if ("q".equals(cmd)) {
                break;
            } else if ("r".equals(cmd)) {
                machine.restock();
            } else try {
                int selection = Integer.parseInt(cmd);
                Drink order = machine.menu()[selection - 1];
                machine.make(order);
                System.out.println( order);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException invalid) {
                System.out.println(command);
                continue;
            } catch (OutOfStockException outOfStock) {
                System.out.println( outOfStock.getMessage());
                continue;
            }
            System.out.println(machine);
        }
    }
}


enum Ingredient {
    // An extensible design wouldn't use an enum, but the problem specificationallows such hard-coding.
    // These entries must be in alphabetical order.
    COCOA("0.90"),
    COFFEE("0.75"),
    CREAM("0.25"),
    DECAF_COFFEE("0.75"),
    ESPRESSO("1.10"),
    FOAMED_MILK("0.35"),
    STEAMED_MILK("0.35"),
    SUGAR("0.25"),
    WHIPPED_CREAM("1.00");

    private final String name;
    private final BigDecimal cost;

    Ingredient(String cost) {
        this.name = this.name().replace("_", " ").toLowerCase();
        this.cost = new BigDecimal(cost);
    }
    // Using fixed-point representation to prevent rounding problems
    public BigDecimal getCost() {
        return this.cost;
    }
    public String toString() {
        return this.name;
    }
}
enum Drink {
    // An extensible design wouldn't use an enum, but the problem specification
    // allows such hard-coding.  These entries must be in alphabetical order.
    CAFFE_AMERICANO("Caffe Americano", "3 ESPRESSO"),
    CAFFE_LATTE("Caffe Latte", "2 ESPRESSO", "STEAMED_MILK"),
    CAFFE_MOCHA("Caffe Mocha", "ESPRESSO", "COCOA", "STEAMED_MILK", "WHIPPED_CREAM"),
    CAPPUCCINO("Cappuccino", "2 ESPRESSO", "STEAMED_MILK", "FOAMED_MILK"),
    COFFEE("Coffee", "3 COFFEE", "SUGAR", "CREAM"),
    DECAF_COFFEE("Decaf Coffee", "3 DECAF_COFFEE", "SUGAR", "CREAM");

    private final String name;
    private final Map<Ingredient, Integer> ingredients;
    private final BigDecimal cost;

    Drink(String name, String... recipe) {
        Map<Ingredient, Integer> map = new HashMap<Ingredient, Integer>();
        BigDecimal cost = BigDecimal.ZERO;
        for (String spec : recipe) {
            String[] amountOfStuff = spec.split(" ", 2);
            int quantity = (amountOfStuff.length > 1) ? Integer.parseInt(amountOfStuff[0]) : 1;
            String stuff = amountOfStuff[amountOfStuff.length - 1];
            Ingredient ingredient = Enum.valueOf(Ingredient.class, stuff);
            map.put(ingredient, quantity);
            cost = cost.add(ingredient.getCost().multiply(new BigDecimal(quantity)));
        }
        this.name = name;
        this.ingredients = Collections.unmodifiableMap(map);
        this.cost = cost;
    }
    public Map<Ingredient, Integer> getRecipe() {
        return this.ingredients;
    }
    public BigDecimal getPrice() {
        return this.cost;
    }
    public String toString() {
        return this.name;
    }
}