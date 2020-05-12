package ejercicio1;

    /**
     * Entrada para ejecucion del ejercicio 1 (No pedido)
     * @author Guillermo Casas
     * @author g.casas.r94@gmail.com
     */

public class main {

    public static void main(String[] args) {
        Cuenta santander = new Cuenta("Guille",200.54);
        System.out.println(santander.toString());
        santander.ingresoDinero(20);
        System.out.println(santander.toString());
        santander.retirarDinero(100);
        System.out.println(santander.toString());
    } 
}
