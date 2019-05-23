package analizador.lexico.c;

import Lectura.LeerArchivo;

public class Preludio {
    LeerArchivo archivo = new LeerArchivo();
    
    void pre() {
        archivo.leerArchivo();
        
        String datos = archivo.datos();
        int i = 0, posicionIni = 0, posicionFin = 0, lineas = 0;
        
        System.out.println(lineas);
        while (i < lineas) {
            for (int j = posicionIni; j < datos.length(); j++) {
                if (datos.charAt(j) == ' ') {
                    posicionFin = j;
                    break;
                } else if (datos.charAt(j) == '\n') {
                    posicionFin += j;
                    break;
                }
                
            }
            i++;
            
        }
    }
}

class test {
    public static void main(String[] args) {
        Preludio p = new Preludio();
        
        p.pre();
    }
}