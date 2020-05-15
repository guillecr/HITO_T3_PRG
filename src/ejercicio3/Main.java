package ejercicio3;

import java.io.IOException;

/**
 * Entrada a la ejecucion del ejercicio 3
 * @author Guillermo Casas Reche
 * @author g.casas.r94@gmail.com
 * @version 1.0_150520
 */
public class Main {
    public static void main(String[] args) throws IOException{
        // ==============================================================
        // =============== VARIABLES DE SESIÓN ==========================
        // ==============================================================
        // Variables de generación de la contraseña
        int num;        // Número de PW que generaremos
        int longpw;     // Longitud de las PW que generaremos
        boolean hard=true;      // Bandera que indicará si las contraseñas seran o no fuertes
        
        // Variables de gestión de errores
        String errorLong= "";   // Variable donde almacenaremos los posibles errores relacionados con la longitud
        boolean bLongpw=false;  // Semaforo para escritura de errores
        
        // Variable de control de bucle de pregunta
        boolean pregunta=false; // Semaforo para salir del bucle de pregunta
        
        // Objeto de lectura por teclado
        Entrada leer = new Entrada();
        
        // ==============================================================
        // =============== MENSAJE INICIAL ==============================
        // ==============================================================
        // GENPW
        System.out.println(""
                + " ____                   "+" ____\n"
                + "|  __|  ____   _ ___    "+"|  _ \\  __        __    \n"
                + "| /__  /  _ \\ | '__ \\ "+"  | |_) | \\ \\  __  / /\n"
                + "| |_ | |  __/ | |  \\ | "+" |  __/   \\ \\/  \\/ /\n"
                + "|___/  \\___|  |_|  |_| "+" |_|       \\__/\\__/"
        );
        System.out.println("Versión:  1.0\n");
        System.out.println("Este programa generará contraseñas de manera aleatoria.\nAl final mostrarán las contraseñas generadas y se indicará\ncuáles de ellas cumplen estos parámetros se seguridad: ");
        System.out.println("- Debe tener un mínimo de 2 minúsculas \n- Debe tener un mínimo de 5 MAYÚSCULAS\n- Debe tener un mínimo de 6 números");
        System.out.println("Se puede indicar al programa que genere las contraseñas siguiendo\nestos parámetros o generarlas de manera totalmente aleatorias.\n");
        
        
        // ==============================================================
        // ========= EJECUCIÓN DEL PROGRAMA =============================
        // ==============================================================
        
        // Realización de las 3 preguntas (Nº de preguntas, longitud, generacion por parametros) 
        System.out.print("Indique el número de contraseñas que quiere crear: ");
        num = leer.lecturaInt();
        Password[] psw = new Password[num];
        boolean[] esFuerte = new boolean[num];
        
        System.out.print("Indique la longitud de las contraseñas [5-13]: ");
        longpw = leer.lecturaInt();
        
        
        if(longpw>13 || longpw<5){
            errorLong+="[WARNING]: Longitud invalida, se usará la longitud por defecto (8).\n";
            bLongpw=true;
        }
        if(longpw<13 || bLongpw){
            errorLong+="[WARNING]: A esa longitud es imposible generar contraseñas fuertes. Se pueden generar\n           siguiendo los parámetros de seguridad, pero no todas se podrán cumplir.";
            System.out.println("\n" + errorLong + "\n");
        }
        
        
        do{
            System.out.print("¿Desea que la contraseña se genere siguiendo los parámetros de seguridad? [S/n]: ");
            String lectura = leer.lecturaString().toUpperCase();
            switch(lectura){
                case "S":
                    hard=true;
                    pregunta=true;
                    break;
                case "N":
                    hard=false;
                    pregunta=true;
                    break;
                default:
                    System.out.println("Comando desconocido");
            }
            
        }while(pregunta==false);
        
        // Creación de los objetos Password
        for(int i=0;i<psw.length;i++){
            psw[i] = new Password(longpw,hard);
            esFuerte[i] = psw[i].esFuerte();
        }
        System.out.println("");
        
        // Impresión por consola del resultado de la creación de las contraseñas
        for(int i=0;i<psw.length;i++){
            System.out.println(psw[i].getPw() + "  " + esFuerte[i]);
        }
    }
}