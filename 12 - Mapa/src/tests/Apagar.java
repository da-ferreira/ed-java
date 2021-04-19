package tests;

public class Apagar {
    public static void main(String[] args) {
        /*
        String teste = "casa";
        String teste2 = "casa";
        
        System.out.println(teste.hashCode());
        System.out.println(teste2.hashCode());
        
        System.out.println(teste.hashCode() == teste2.hashCode());
        
        
        float valor =  350.152F;
        System.out.println(Float.floatToIntBits(valor));
        System.out.println((int) valor);
        
        
        long longo = 9223372036854775807L;
        long longo2 = 9223372036854775807L;
        
        System.out.println(hashCode(longo));
        System.out.println((int) longo2);
        
        String str = "casa";
        System.out.println((int) str.charAt(0));  // Pega o código no caracter na tabela ASCII
        System.out.println(13 | 60);
        
        System.out.println(hashCode("casa"));
        System.out.println(hashCode("a"));
        */
    	
        int teste = 922337000;
        
        System.out.println((teste << 5) | (teste >>> 27));
        System.out.println(teste << 5);
        System.out.println(teste >>> 27);
    }
    
    public static int hashCode(long i) {
        return (int)((i >> 32) + (int) i);
    }
    
    /** Outra forma de calcuar o código hash polinomial, substituindo a multiplicação por "a"
      * pelo deslocamento ciclico. */
    public static int hashCode(String str) {
        int hash = 0;
                
        for (int i=0; i < str.length(); i++) {
            hash = (hash << 5) | (hash >>> 27);  // cyclic shift (deslocamento cíclico)
            hash += (int) str.charAt(i);         // Pega o código no caracter na tabela ASCII
        } 
        
        return hash;
    }
}
