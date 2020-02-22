package extra;

import java.util.Arrays;
import java.util.Random;

public class LicensePlateGenerator {


    static String[] INVALID_PLATE_LETTERS = {"FOR", "AXE", "JAM", "JAB", "ZIP", "ARE", "YOU", "JUG", "JAW", "JOY"};

    static String generateLetters(int amount) {
        String letters = "";
        int n = 'Z' - 'A' + 1;
        for (int i = 0; i < amount; i++) {
            char c = (char) ('A' + Math.random() * n);
            letters += c;
        }
        return letters;
    }

    static String generateDigits(int amount) {
        String digits = "";
        int n = '9' - '0' + 1;
        for (int i = 0; i < amount; i++) {
            char c = (char) ('0' + Math.random() * n);
            digits += c;
        }
        return digits;
    }

    static String generateLicensePlate() {
        String licensePlate;
        String letters;
        do {
            letters = generateLetters(3);
        } while (illegalWord(letters));

        String digits = generateDigits(3);

        licensePlate = letters + "-" + digits;
        return licensePlate;
    }

    private static boolean illegalWord(String letters) {
        for (int i = 0; i < INVALID_PLATE_LETTERS.length; i++) {
            if (letters.equals(INVALID_PLATE_LETTERS[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {

      // System.out.print(generateLicensePlate() + " ");
        Random generator = new Random();
        System.out.println(generator.nextBoolean());
        System.out.println(Math.abs(generator.nextInt()));
       // System.out.println(generator.nextInt());

    }
}

