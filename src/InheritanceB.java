public class InheritanceB extends InheritanceA { //Inheritance
    public void B() {
        System.out.println("Bye!");
    }
    public static void main(String[] args) {
        InheritanceB b = new InheritanceB();
        b.A();
        b.B();
    }
}
