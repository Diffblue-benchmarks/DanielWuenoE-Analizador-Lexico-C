package analizador.lexico.c;

public class Clasifica {
    
    private String caso;
    Tipos tipo = new Tipos();
    ConversionCaracter conv = new ConversionCaracter();
//
    public void q0(String archivo) {
        for (int i = 0; i < archivo.length(); i++) {
            conv.convertirCaracter(archivo.charAt(i));

            if (tipo.esCero(conv.getAscii()) == true) {
                caso = "q1";
            } else if (tipo.esNumero(conv.getAscii()) == true) {
                caso = "q3";
            } else if (tipo.esMinuscula(conv.getAscii()) == true || tipo.esMayuscula(conv.getAscii()) == true) {
                caso = "q4";
            } else if (tipo.esCaracter(conv.getAscii()) == true) {
                caso = "q7";
            } else {
                caso = "q2";
            }
        }
    }
    
    public void q1Cero(){
        
    }
    public void q2ErrorLexico(){
        
    }
    public void q3Numero(){
        
    }
    public void q4Identificador(){
        
    }
    public void q5Float(){
        
    }
    public void q6Float(){
        
    }
    public void q7Caracter(){
        
    }
    
}