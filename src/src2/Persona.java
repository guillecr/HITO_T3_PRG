package src2;

public class Persona {
    // Constantes
    final int minIMC = 20;
    final int maxIMC = 25;
    final int mayor = 18;
    final String[] letrasDNI = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
    final char sexoDefecto = 'H';
    final int numsDNI = 8;
    
    // Atributos
    private String nombre;
    private int edad;
    private float peso,altura;
    private char sexo = sexoDefecto;
    private String dni = generarDNI();
    
    // =============== Setter Getter ===========================================
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }
    public String getDni(){
        return dni;
    }

    public char getSexo(){
        return sexo;
    }
    public void setSexo(char sexo){
           this.sexo = sexo;
    }

    public float getPeso(){
        return peso;
    }
    public void setPeso(float peso){
        this.peso = peso;
    }

    public float getAltura(){
        return altura;
    }
    public void setAltura(float altura){
        this.altura = altura;
    }

    // ================== CONTRUCTORES =========================================
    //Contructor vacio
    public Persona(){
    }
    /**
     * Contructor de una nueva persona con 3 parametros
     * @param nombre Nombre de la persona (String)
     * @param edad Edad de la persona (entero)
     * @param sexo Sexo de la persona (String)
     */
    public Persona(String nombre, int edad, String sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.dni = generarDNI();
    }
    /**
     * Contructor con todos los parametros asignables
     * @param nombre Nombre de la persona (String)
     * @param edad Edad de la persona (Entero)
     * @param sexo Sexo de la persona (String)
     * @param dni DNI de la persona (Numero y letra)
     * @param peso Peso de la persona en Kg (Numero real)
     * @param altura Altura de la persona en cm (Numero real)
     */
    public Persona(String nombre, int edad, String sexo, String dni, float peso, float altura){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.dni = comprobarDNI(dni);
        this.peso = peso;
        this.altura = altura;
    }

    // ============= METODOS PROPIOS ===========================================
    /**
     * Calculo numerico de la IMC.
     * Calculará la IMC con los atributos del objeto y devolverá su resultado
     * @return Valor double con el resultado del calculo
     */
    private double mathIMC(){
        double IMC = getPeso()/Math.pow(getAltura(),2);
        return IMC;
    }
    /**
     * Comprobación de si el IMC (resultante de la funcion mathIMC()) esta o no en los margenes idoneos marcado 
     * en las constantes minIMC y maxIMC
     * @return Valor entero con el resultado del analisis (-1 = por debajo // 0 = IMC correcto // 1 = Por encima)
     */
    public int calcularIMC(){
        int result = -1;
        double IMC = mathIMC();
        if(IMC >= minIMC){result++;}
        if(IMC > maxIMC){result++;}
        return result;
    }

    /**
     * Comprobador si el mayor de edad
     * Comparará la edad asignada al objeto a su constante que marca la edad minima para ser considerado mayor de edad
     * @return Booleano con el resultado de la comprobación (True = Mayor de edad // False = Menor de edad)
     */
    public boolean esMayorDeEdad(){
        boolean test = true;
        if(getEdad()<mayor){
            test = false;
        }
        return test;
    }

    /**
     * Comprobador del sexo introducido. Si este no es valido, se añadirá el por defecto.
     * En si, la función analizara solo el primer caracter independiente de si es minuscula o mayusculas.
     * Por ello permite introducir H, h u Hombre.
     * 
     * @param sexo String para analizar 
     * @return char con el caracter identificador ('H'=Hombre // 'M'=Mujer)
     */
    private char comprobarSexo(String sexo){
        sexo = sexo.toUpperCase();
        char sexoCh = sexo.charAt(0);
        if(sexoCh != 'M' && sexoCh != 'H'){
            sexoCh = sexoDefecto;
        }
        return sexoCh;
    }

    /**
     * Metodo toString para obtener un String con todos los parametros del objecto
     * @return String con todos los parametros del objecto
     */
    public String toString(){
        String text = ""+
            "Nombre: "+nombre+
            " Edad: "+edad+
            " Sexo: "+sexo+
            " DNI: "+dni+
            " Peso: "+peso+
            " Altura: "+altura            
        ;
        return text;
    }

    // Funciones DNI
    /**
     * Generador un DNI (numero + letra) aleatorio valido
     * @return String con el numero y letra generado
     */
    private String generarDNI(){
        int num = (int)(Math.random()*(Math.pow(10, numsDNI)-Math.pow(10,numsDNI-1))+Math.pow(10,numsDNI-1));
        return String.valueOf(num)+generarLetraDNI(num);
    }
    /**
     * Calcula la letra que le corresponde a un numero de DNI
     * @param dni Valor entero del numero DNI al que generar su letra
     * @return String con la letra correspondiente al numero entregado
     */
    private String generarLetraDNI(int dni){
        
        String letra = letrasDNI[dni%23];
        return letra;
    }
    /**
     * Comprobador de validez del numero DNI por comparación de la letra entregada y su letra calculada
     * Si el DNI no es correcto, generará uno nuevo
     * @param dni String con el valor del DNI (numero + letra)
     * @return Devuelve siempre un DNI valido, el entregado o uno aleatorio si el entregado no era valido
     */
    private String comprobarDNI(String dni){
        int num=0;
        String letra="";
        dni = dni.toUpperCase();
        boolean error = false;
        try{
            num = Integer.parseInt(dni.substring(0,8));
            letra = dni.substring(8,9);
        }
        catch(Exception e){
            error = true;
        }
        if (!letra.equals(generarLetraDNI(num)) || error){
            System.out.println("[ERROR]: DNI incorrecto, se generará uno aleatorio");
            dni = generarDNI();
        }
        return dni;
    }
}
