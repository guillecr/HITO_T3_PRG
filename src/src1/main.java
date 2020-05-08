package src1;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta santander = new Cuenta("Guille",200.54);
        System.out.println(santander.toString());
        santander.ingresoDinero(20);
        System.out.println(santander.toString());
        santander.retirarDinero(100);
        System.out.println(santander.toString());
    }
    
}
