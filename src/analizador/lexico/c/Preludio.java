package analizador.lexico.c;

import Lectura.LeerArchivo;

public class Preludio {
    LeerArchivo archivo = new LeerArchivo();
    
    void pre() {
        archivo.leerArchivo();
        
        String datos = archivo.datos();
        String apuntadorActual = " ";
        int i = 0, posicionIni = 0, posicionFin = 0, lineas = 0;
        
        for (int j = 0; j < datos.length(); j++) {
            if (datos.charAt(j) == apuntadorActual.charAt(0)) {
                lineas++;
            }
        }
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
            System.out.println("Ini:: " + posicionIni + " Fin: " + posicionFin);
            System.out.println(":" + datos.substring(posicionIni, posicionFin) + ":");

            posicionIni += posicionFin + 1;
//            System.out.println("Ini: " + posicionIni + " Fin: " + posicionFin);
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