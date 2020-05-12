package ejercicio3;

/**
 * Clase Password
 * @author Guillermo Casas Reche
 * @author g.casas.r94@gmail.com
 * @version 0.120520
 */
public class Password {
    /*

Los métodos que implementa serán:
 esFuerte(): devuelve un booleano si es fuerte o no, para que sea fuerte debe tener más de 4,
mayúsculas, más de 1 minúscula y mas de 5 números.

    */
    
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
    final private int forceUPPER=4;
    final private int forceLOWER=1;
    final private int forceNUM=5;
    
    
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
        this.pw = generarPasswor();
    }
    
    public Password(int longPw) {
        this.longPw = longPw;
        this.pw = this.generarPasswor();
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
        boolean bFuerte=false;
        if (getCountABCupper()<=getForceUPPER()){
            bFuerte=false;
            System.out.print(" Fallo en las mayusculas ");
        }
        if (getCountABC()-getCountABCupper()<=getForceLOWER()){
            bFuerte=false;
            System.out.print(" Fallo en las minusculas ");
        }
        if (getCountNum()<=getForceNUM()){
            bFuerte=false;
            System.out.print(" Fallo en los numeros ");
        }
        System.out.println("");
        return bFuerte;
    }
    
    /**
     *  Metodo principal para generar una nueva contraseña aleatoria
     * Tomará la longitud del atributo del objeto. Si ese no cumple
     * con las condiciones de longitud, se usara la lingitud por defecto
     * @return {String} Nueva contraseña
     */
    private String generarPasswor(){
        String newPw="";
        
        // Testeo de la contraseña
        if(getLongPw()<getLongPwMin() && getLongPw()>getLongPwMax()){
            setLongPw(getLongPwDef());
        }
        
        // Variables locales empleadas
        int n1;
        String letra;
        
        for(int i=0;i<getLongPw();i++){
            // Nivel 1: Elección de número o letra
            n1 = numRand(0,100);
            int factor = (int)((double)(getFactAB12()/5.0)*100);
            //System.out.println("Factor: "+factor);
            if (n1<factor){
                // El caracter será una letra
                letra = RanABC();
                countABC++;
            }else{
                // El caracter sera un numero
                letra = String.valueOf(numRand(0,10));
                countNum++;
            }
            newPw += letra;
        }

        return newPw;
    }
    
    /**
     *  Metodo para generar una letra aleatoria
     * Habra un 50% de posibilidad de ser o no mayúscula
     * @return Letra aleatoria
     */
    private String RanABC(){
        String letra = getAbcS(numRand(0,getAbcS().length));
        if(numRand(0,100)<50){
            letra = letra.toUpperCase();
            countABCupper++;
        }
        return letra;
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
    
    
    
    
}
