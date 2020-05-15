package ejercicio3;

/**
 * Clase Password
 * @author Guillermo Casas Reche
 * @author g.casas.r94@gmail.com
 * @version 1.0_150520
 */
public class Password {  
    // =============================================
    // ================ ATRIBUTOS ==================
    // =============================================
    private int longPw; // Longitud de la contraseña
    private String pw;  // Variable que contrendrá la contraseña
    
    // Las variables COUNT iran almacenando el número de tipos de caracteres que se van generando en la contraseña
    private int countABC=0;         // Contador de número de LETRAS añadidas en la contraseña
    private int countABCupper=0;    // Contador de número de letras MAYÚSCULAS añadidas a la contraseña
    private int countNum=0;         // Contador de número de NUMEROS añadidas a la contraseña
    
    private boolean bHARD;
    
    
    
    // =============================================
    // =============== CONSTANTES ==================
    // ============================================= 
    // Las constantes LONG definen la naturaleza de la longitud de la contraseña
    final private int longPwDef=8;  // Longitud de la contraseña por defecto
    final private int longPwMax=13; // Longitud maxima que aceptará nuestra clase
    final private int longPwMin=5;  // Longitud minima que aceptará nuestra clase
    
    // Nuestra libreria de letras que añadirá nuestra clase
    final private String[] abcS={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","y","z"};
    
    // Las constantes HARD determinarán las condiciones para determinar si es o no fuerte y la naturaleza de generación de contraseña que tendra nuestra clase
    final private int hardUPPER=5;  // Numero minimo de mayusculas
    final private int hardLOWER=2;  // Numero minimo de minusculas
    final private int hardNUM=6;    // Numero minimo de numeros
    final private boolean hardDefault=true;
    
    
    
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

    public int getHardUPPER() {
        return hardUPPER;
    }

    public int getHardLOWER() {
        return hardLOWER;
    }

    public int getHardNUM() {
        return hardNUM;
    }

    public boolean getbHARD() {
        return bHARD;
    }

    public void setbHARD(boolean bHARD) {
        this.bHARD = bHARD;
    }

    public boolean getHardDefault() {
        return hardDefault;
    }
    
    

    // =============================================
    // ============== CONSTRUCTORES ================
    // =============================================
    public Password() {
        this.longPw = this.longPwDef;
        this.bHARD = this.hardDefault;
        this.pw = generarPassword();
    }
    
    public Password(int longPw) {
        this.longPw = longPw;
        this.bHARD = this.hardDefault;
        this.pw = generarPassword();
    }
    
    public Password(int longPw, boolean HARD) {
        this.longPw = longPw;
        this.bHARD = HARD;
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
     * Método que analiza la seguridad de la contraseña
     * Para que se determine como segura debe de cumplir con las
     * constantes HARD. Los parametros a analizar serán las variables COUNT
     * generadas en la generación de la contraseña.
     * @return 
     */
    public boolean esFuerte(){
        boolean bFuerte=true;
        if (getCountABCupper()<getHardUPPER()){
            bFuerte=false;
            
        }
        if (getCountABC()-getCountABCupper()<getHardLOWER()){
            bFuerte=false;
        }
        if (getCountNum()<getHardNUM()){
            bFuerte=false;
        }
        return bFuerte;
    }
      
    /**
     * Método para generar números aleatorios
     * @param min Valor minimo
     * @param max Valor maximo (nunca se alcanzará)
     * @return Número obtenido
     */
    private int numRand(int min, int max){
        float nF = (float)(Math.random()*(max-min))+min;
        return (int)nF;
    }
    
    /**
     * Función general para generar contraseñas. Este se generará en función de 
     * los parámetros HARD de la clase.
     * - Verificación de la longitud de la contraseña indicada
     * - Generación de la contraseña, siguiendo las directrices de las constantes HARD
     * - Seguimiento de la generación con las variables COUNT
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
        this.countABCupper=0;   // Reseteo de contadores (Contador de mayúsculas)
        this.countABC=0;        // Reseteo de contadores (Contador de letras)
        this.countNum=0;        // Reseteo de contadores (Contador de números)
        
        
        // Bucle en función de la longitud. A cada vuelta generará un nuevo caracter
        for(int i=0;i<getLongPw();i++){
            // numABC: Esta variable decidirá si generamos un número o una letra. 
            // Por defecto será impar => número
            int numABC=1; 
            
            // Probabilidad del 50% de cambiar numABC a par => letra
            if(numRand(0,100) < 50){
                numABC++;
            }
            
            // Si se alcanza el número de caracteres máximo (HARD) para el tipo elegido (num o letra)
            // se cambiará (par + 1 = impar  //  impar + 1 = par)
            if(
                getbHARD() 
                &&
                (
                    ( (numABC == 2) && (getCountABC() >= (getHardLOWER()+getHardUPPER())) )
                    ||
                    ( (numABC == 1) && (getCountNum() >= getHardNUM()) )
                )
            ){
                numABC++;
            }
            
            // Switch del modulo de numABC de 2
            switch(numABC%2){
                // Si es par, el carácter será una letra
                case 0:
                    setCountABC(getCountABC()+1);
                    newPW += abcRand();
                    break;
                // Si no es par, será un número
                default:
                    setCountNum(getCountNum()+1);
                    newPW += String.valueOf(numRand(0,10));
                    break;
            }
        }
        return newPW;
    }
    
    /**
     * Método para generar una letra aleatoria. 
     * Habrá un 60% de posibilidad de ser mayúscula.
     * Si se ha llegado al máximo de de mayúsculas o minúsculas se cambiará por su contrario
     * @return Letra aleatoria
     */
    private String abcRand(){
        // Obtenemos una letra aleatoria en minuscula
        String letra = getAbcS(numRand(0,getAbcS().length));
        int uppLOW=0; // uppLOW: Variable de control ( 0 => minúscula // 1=> Mayúscula ). Uso en la necesidad de realización de cambio
        
        // Elección aleatoria para transformación a mayúscula de la letra (60%)
        if(numRand(0,100)>40){
            letra = letra.toUpperCase();
            setCountABCupper(getCountABCupper()+1); // Aumentamos el contador de mayúsculas
            uppLOW++; // Indicamos que el carácter es mayúscula
        }
        
        // Si alcanzamos el límite marcado por HARD, invertimos el tipo de letra (mayúsculas / minúsculas)
        // También corregimos el contador countABCupper
        // numeroMinusculas = numeroTotal - numeroMayusculas
        if( 
            getbHARD() 
            &&  
            (getCountABCupper() > getHardUPPER() || (getCountABC() - getCountABCupper()) > getHardLOWER()) 
        ){
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