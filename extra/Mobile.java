package extra;

 class A{
     void p(){

     }

}
public class Mobile {
    void sms() {
        System.out.println(" Mobile class");
    }
}
    //Extending the Mobile class
     class OnePlus extends  Mobile {

        void sms() {
            System.out.println(" OnePlus");
        }

        public static void main(String[] args) {


            OnePlus smsObj1 = new OnePlus();
            smsObj1.sms();
        }
    }
