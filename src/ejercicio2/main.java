package ejercicio2;

import java.io.IOException;

    /**
     * Entrada para ejecución del ejercicio 2
     * @author Guillermo Casas
     * @author g.casas.r94@gmail.com
     * @version 1.120520
     */

public class main {       
    // MAIN
    public static void main(String[] args) throws IOException{
        System.out.println("Ejercicio de personas");
        
        // Variables de sesion
        String nombre, dni, sexo;
        int edad;
        float peso,altura;
        
        // Libreria que albergará nuestros objetos
        Persona[] per = new Persona[3];
        
        // Constantes Mensajes
        final String[] IMCmensajeS = {"tiene un IMC por debajo de lo norma","esta en su peso ideal","tiene un IMC por encima de lo normal"};
        final String[] MayorMensaje = {"Es menor de edad","Es mayor de edad"};
        
        // Instancia de la clase de lectura por teclado
        Entrada leer = new Entrada();
        
        // Entradas por teclado
        System.out.print("Nombre: ");
        nombre = leer.lecturaString();
        System.out.print("Edad: ");
        edad = leer.lecturaInt();
        System.out.print("Sexo: ");
        sexo = leer.lecturaString();
        System.out.print("DNI: ");
        dni = leer.lecturaString();
        System.out.print("Peso (kg): ");
        peso = leer.lecturaFloat();
        System.out.print("Altura (cm): ");
        altura = leer.lecturaFloat();

        // Generamos nuestros objectos
        per[0] = new Persona(nombre, edad, sexo, dni, peso, altura);
        per[1] = new Persona(nombre, edad, sexo);
        per[2] = new Persona();
        
        // Analisis de los objetos
        System.out.println("\nAnalisis de objetos");
        for(int i=0;i<per.length;i++){
            System.out.println("\nObjeto "+(i+1));
            // IMC
            System.out.println(per[i].getNombre()+" "+IMCmensajeS[per[i].calcularIMC()+1]);
            // Mayor edad
            int mayor = 0;
            if(per[i].esMayorDeEdad()){
                mayor = 1;
            }
            System.out.println(MayorMensaje[mayor]);
            // toString()
            System.out.println(per[i].toString());
        }
    }
}