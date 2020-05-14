package ejercicio3;

/**
 * Clase Password
 * @author Guillermo Casas Reche
 * @author g.casas.r94@gmail.com
 * @version 0.140520
 */
public class Password {  
    // =============================================
    // ================ ATRIBUTOS ==================
    // =============================================
    private int longPw;
    private String pw;
    private int countABC=0;
    private int countABCupper=0;
    private int countNum=0;
    
    
    // =============================================
    // =============== CONSTANTES ==================
    // ============================================= 
    final private int longPwDef=8;
    final private int longPwMax=13;
    final private int longPwMin=5;
    final private String[] abcS={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","y","z"};
    final private float factAB12 = 3F; // MAX: 5 :: Factor de probabilidad de letras y números en la PW (3 => 3/5 = 60% letras) 
    final private int forceUPPER=5;
    final private int forceLOWER=2;
    final private int forceNUM=6;
    
    
    // =============================================    
    // ============== GETTER SETTER ================
    // =============================================
    public int getLongPw() {
        return longPw;
    }

    public void setLongPw(int longPw) {
        this.longPw = longPw;
    }

    public String getPw() {
        return pw;
    }

    public int getLongPwDef() {
        return longPwDef;
    }

    public int getLongPwMax() {
        return longPwMax;
    }

    public int getLongPwMin() {
        return longPwMin;
    }

    public String[] getAbcS() {
        return abcS;
    }

    public String getAbcS(int index){
        return abcS[index];
    }
    public float getFactAB12() {
        return factAB12;
    }

    public int getCountABC() {
        return countABC;
    }

    public void setCountABC(int contABC) {
        this.countABC = contABC;
    }

    public int getCountABCupper() {
        return countABCupper;
    }

    public void setCountABCupper(int countABCupper) {
        this.countABCupper = countABCupper;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int contNum) {
        this.countNum = contNum;
    }

    public int getForceUPPER() {
        return forceUPPER;
    }

    public int getForceLOWER() {
        return forceLOWER;
    }

    public int getForceNUM() {
        return forceNUM;
    }
    

    // =============================================
    // ============== CONSTRUCTORES ================
    // =============================================
    public Password() {
        this.longPw = this.longPwDef;
        this.pw = generarPassword();
    }
    
    public Password(int longPw) {
        this.longPw = longPw;
        this.pw = generarPassword();
    }

    // =============================================
    // ================ toString ===================
    // =============================================
    public String toString() {
        return "Password{" + "longPw=" + longPw + ", pw=" + pw + ", countABC=" + countABC + ", countABCupper=" + countABCupper + ", countNum=" + countNum + '}';
    }
    
    // =============================================
    // ========= MÉTODOS PROPIOS ===================
    // =============================================
    
    /**
     * Metodo que analiza la seguridad de la contraseña
     * Para que se determine como segura debe de cumplir con las
     * constantes FORCE
     * @return 
     */
    public boolean esFuerte(){
        boolean bFuerte=true;
        if (getCountABCupper()<getForceUPPER()){
            bFuerte=false;
            //System.out.print(" Fallo en las mayusculas ");
        }
        if (getCountABC()-getCountABCupper()<getForceLOWER()){
            bFuerte=false;
            //System.out.print(" Fallo en las minusculas ");
        }
        if (getCountNum()<getForceNUM()){
            bFuerte=false;
            //System.out.print(" Fallo en los numeros ");
        }
        //System.out.println("");
        return bFuerte;
    }
      
    /**
     * Metodo para generar numeros aleatorios
     * @param min Valor minimo
     * @param max Valor maximo (nunca se alcanzará)
     * @return Numero obtenido
     */
    private int numRand(int min, int max){
        float nF = (float)(Math.random()*(max-min))+min;
        return (int)nF;
    }
    /**
     * Funcion general para generar contraseñas. Este se generará en funcion de 
     * los parametros FORCE de la clase. Pasos:
     * - Verificará si la longitud es valida, de no serla dara la longitud por defecto
     * - De manera aleatoria de decidirá si se escribe letra o numero. Si el elegido
     * a llegado al tope se cambiara por el otro.
     * 
     * @return Contraseña generada
     */
    private String generarPassword(){
        // Testeo de la longitud
        if(getLongPw()<getLongPwMin() || getLongPw()>getLongPwMax()){
            setLongPw(getLongPwDef());
        }
        // Variables locales
        String newPW=""; // String donde iremos generando la contraseña
        this.countABCupper=0;   // Reseteo de contadores (Contador de mayusculas)
        this.countABC=0;        // Reseteo de contadores (Contador de letras)
        this.countNum=0;        // Reseteo de contadores (Contador de numeros)
        
        // Bucle como parametro de vueltas el tamaño de la contraseña. A cada vuelta
        // generará un nuevo caracter
        for(int i=0;i<getLongPw();i++){
            // Esta variable decidira si generamos un numero o una letra. Por 
            // defecto sera impar => numero
            int numABC=1; 
            
            // Si el numero aleatorio es menor de 50, cambiamos el numABC a par
            if(numRand(0,100)<50){
                numABC++;
            }
            
            // Si se alcanza el numero de caracteres para el tipo elegido (num o letra)
            // se cambiara (par + 1 = impar  //  impar + 1 = par)
            if(
                ((numABC == 2) && (getCountABC()>=(getForceLOWER()+getForceUPPER())))
                ||
                ((numABC == 1) && (getCountNum()>=getForceNUM()))
            ){
                numABC++;
            }
            switch(numABC%2){
                case 0:
                    setCountABC(getCountABC()+1);
                    newPW += RanABC();
                    break;
                default:
                    setCountNum(getCountNum()+1);
                    newPW += String.valueOf(numRand(0,10));
                    break;
            }
        }

        return newPW;
    }
    
    /**
     * Metodo para generar una letra aleatoria. 
     * Habra un 60% de posibilidad de ser mayúscula.
     * Si se ha llegado al maximo de de mayusculas o minusculas se cambiara por su contrario
     * @return Letra aleatoria
     */
    private String RanABC(){
        String letra = getAbcS(numRand(0,getAbcS().length));
        int uppLOW=0;
        
        if(numRand(0,100)>40){
            letra = letra.toUpperCase();
            setCountABCupper(getCountABCupper()+1);
            uppLOW++;
        }
        if(getCountABCupper()>getForceUPPER() || (getCountABC()-getCountABCupper())>getForceLOWER()){
            switch (uppLOW){
                case 0:
                    letra = letra.toUpperCase();
                    setCountABCupper(getCountABCupper()+1);
                    break;
                case 1:
                    letra = letra.toLowerCase();
                    setCountABCupper(getCountABCupper()-1);
                    break;
            }
        }
        return letra;
    }
}
