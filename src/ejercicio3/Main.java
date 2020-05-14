package ejercicio3;

/**
 * Entrada a la ejecucion del ejercicio 3
 * @author Guillermo Casas Reche
 * @author g.casas.r94@gmail.com
 * @version 0.140520.2
 */
public class Main {
    public static void main(String[] args){

        
        //System.out.println(psw.newGenerarPw(true));
         
        Password[] psw = new Password[2];
        
        psw[0] = new Password();
        psw[1] = new Password(13);
        for(int i=0;i<psw.length;i++){
            System.out.println(psw[i].toString());
            if(psw[i].esFuerte()){
                System.out.println("La contraseña es fuerte");
            }else{
                System.out.println("La contraseña no es fuerte");
            }
        }
    }
}
