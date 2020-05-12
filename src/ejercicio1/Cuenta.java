package ejercicio1;

    /**
     * Clase Cuenta
     * @author Guillermo Casas
     * @author g.casas.r94@gmail.com
     */
public class Cuenta {
    // Atributos
    String titular;
    double cantidad;

    // Setter Getter
    public void setTitular(String titular){
        this.titular = titular;
    }
    public String getTitular(){
        return titular;
    }
    public void setCantidad(double cantidad){
        this.cantidad = cantidad;
    }
    public double getCantidad(){
        return cantidad;
    }
	
    // Contructores
    public Cuenta (String titular){
        this.titular = titular;
    }
    public Cuenta (String titular, double cantidad){
        this.titular = titular;
        this.cantidad = cantidad;
    }

    // toString
    public String toString(){
        return "Titular: "+getTitular()+" // Saldo: "+getCantidad();
    }

    // METODOS PROPIOS
    /**
     * Funcion para añadir dinero a la cuenta
     * Si el ingreso es negativo, la función no añadira nada
     * @param ingreso Valor double con el dinero a ingresar
     */
    public void ingresoDinero(double ingreso){
        if(ingreso>0){
            setCantidad(getCantidad()+ingreso);
        }
    }
	
    /**
     * Funcion para restar dinero de una cuenta
     * Si el retiro supera la cantidad de dinero en la cuenta, 
     * la función pondra la cuenta a 0 (nunca quedará negatoiva la cuenta)
     * @param retirar Valor double con el dinero a restar
     */
    public void retirarDinero(double retirar){
        setCantidad(getCantidad()-retirar);
        if(getCantidad()<0){
            cantidad = 0;
        }
    }
}
