/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author guille_linux
 */
public class Entrada {
    // Atributos
    private String Sentrada;
    private int IntSalida;
    private float FloatSalida;
    
    // Objeto de lectura
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Getter y setter
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

    // Contructor
    public Entrada() {
    }
    
    // Metodos propios
    public  String lecturaString() throws IOException{
        return br.readLine();
    }
    
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
