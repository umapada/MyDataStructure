package TEST;

interface IKMObserver{}
interface Environment {}
interface IKMEnvironment extends Environment {}
interface IKMProgramEnvironment extends IKMEnvironment {}
class JavaSEEnvironment implements Environment {}
class TestEnvironment implements IKMEnvironment {}
class JavaSETestEnvironment extends TestEnvironment {}
class JavaSE7TestEnvironment implements IKMObserver  {}
class JavaEETestEnvironment implements IKMObserver, IKMProgramEnvironment  {}

 class CustomClass {

    public void initialize(IKMEnvironment environment) {
        if (environment instanceof JavaSE7TestEnvironment) { System.out.println("JavaSE7TestEnvironment"); }
        else if (environment instanceof JavaSEEnvironment) { System.out.println("JavaSEEnvironment"); }
        else if (environment instanceof TestEnvironment) { System.out.println("TestEnvironment"); }
        else if (environment instanceof JavaEETestEnvironment) { System.out.println("JavaEETestEnvironment"); }
        else if (environment instanceof JavaSETestEnvironment) { System.out.println("JavaSETestEnvironment"); }
    }

     public static void main(String[] args) {

         JavaEETestEnvironment p = new JavaEETestEnvironment();
         new CustomClass().initialize(p);
     }
}