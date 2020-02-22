package extra;

import java.math.BigDecimal;

public class EnumExample {
     Company company;

    public enum Company {
        EBAY_TEST(), PAYPAL(20), GOOGLE(30), YAHOO(40), ATT(50);
        private int value;
        String name;
        Company(int value){
            this.value = value;
            this.name = this.name().replace("_","").toLowerCase();
        }
        Company(){
            this.name = this.name().replace("_","").toLowerCase();
        }
    }
    EnumExample(Company company){
        this.company = company;

    }

      void printCompany(){

        switch(company){
            case EBAY_TEST:
                System.out.println(Company.EBAY_TEST.value);
                break;
            case PAYPAL:
                System.out.println(Company.PAYPAL);
                break;
            case ATT:
                System.out.println(Company.ATT);
                break;
            case YAHOO:
                System.out.println(Company.YAHOO);
                break;
            case GOOGLE:
                System.out.println(Company.GOOGLE);
                break;
            default:
                System.out.println("Default");

        }
    }

    public static void main(String[] args) {

        EnumExample ex = new EnumExample(Company.EBAY_TEST);
        ex.printCompany();
        System.out.println(ex.company.name);


    }
}
