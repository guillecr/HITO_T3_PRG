package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase para lectura por teclado
 * @author Guillermo Casas
 * @author g.casas.r94@gmail.com
 * @version 1.150520
 */
public class Entrada {
    // Atributos
    private String Sentrada;
    private int IntSalida;
    private float FloatSalida;
    
    // Objeto de lectura
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // ============= Getter y setter ===========================================
    public String getSentrada() {
        return Sentrada;
    }

    public void setSentrada(String Sentrada) {
        this.Sentrada = Sentrada;
    }

    public int getIntSalida() {
        return IntSalida;
    }

    public void setIntSalida(int IntSalida) {
        this.IntSalida = IntSalida;
    }

    public float getFloatSalida() {
        return FloatSalida;
    }

    public void setFloatSalida(float FloatSalida) {
        this.FloatSalida = FloatSalida;
    }

    // =================== CONTRUCTOR ==========================================
    public Entrada() {
    }
    
    // =================== MÉTODOS PROPIOS =====================================
    
    /**
     * Método para lectura de una cadena de caracteres.
     * @return Devuelve el String introducido por teclado
     * @throws IOException 
     */
    public  String lecturaString() throws IOException{
        String lec = br.readLine();
        if(lec.length()<1){
            System.out.print("[ERROR]: Dato no valido, introduce dato valido (String): ");
            lec = lecturaString();
        }
        return lec;
    }
    
    /**
     * Método para lectura de un número entero introducido por teclado
     * Si se introduce un valor no válido, devolverá un error y pedirá de nuevo
     * que se introduzca un valor válido
     * @return Valor entero introducido por teclado
     */
    public  int lecturaInt() throws IOException{
        setSentrada(br.readLine());
        try{
            setIntSalida(Integer.parseInt(Sentrada));
        }
        catch(Exception e){
            System.out.print("[ERROR] Dato no valido, introduce dato valido (Entero): ");
            setIntSalida(lecturaInt());
        }
        return IntSalida;
    }
   /**
     * Método para lectura de un número real (float) introducido por teclado
     * Si se introduce un valor no válido, devolverá un error y pedirá de nuevo
     * que se introduzca un valor válido
     * @return Valor float (numero real) introducido por teclado
     */
    public float lecturaFloat() throws IOException {
        setSentrada(br.readLine());
        try{
            setFloatSalida(Float.parseFloat(Sentrada));
        }
        catch(Exception e){
            System.out.print("[ERROR] Dato no valido, introduce dato valido (Numero real): ");
            setFloatSalida(lecturaFloat());
        }
        return FloatSalida;
    }
}
