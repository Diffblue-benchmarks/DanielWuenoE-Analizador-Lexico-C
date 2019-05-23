package analizador.lexico.c;

public class Clasifica {

    private String caso;
    private int actual = 0;
    Tipos tipo = new Tipos();
    ConversionCaracter conv = new ConversionCaracter();
//

    public void q0(String archivo) {
        for (int i = actual; i < archivo.length(); i++) {
            conv.convertirCaracter(archivo.charAt(i));
            if (tipo.esCero(conv.getAscii()) == true) {
                q1Cero(archivo);
            } else if (tipo.esNumero(conv.getAscii()) == true) {
                q3Numero(archivo);
            } else if (tipo.esMinuscula(conv.getAscii()) == true || tipo.esMayuscula(conv.getAscii()) == true) {
                q4Identificador(archivo);
            } else if (tipo.esCaracter(conv.getAscii()) == true) {
                q7Caracter(archivo);
            } else {
                q2ErrorLexico(archivo, i + 1);
            }
        }
    }

    //NOTA: Escribir metodo para insertar en lista
    public void q1Cero(String archivo) {
        int movs = 1;

        for (int i = actual; i < archivo.length(); i++) {
            conv.convertirCaracter(archivo.charAt(i));
            if (tipo.esEspacio(conv.getAscii()) == true) {
                //insertar en lista de tokens desde archivo.charAt(actual-movs) hasta archivo.charAt(actual) 
                actual = actual + movs + 1;
                break;
                
            } else {
                movs++;
                //error léxico (inicia en 0)
                q2ErrorLexico(archivo, movs);
                break;

            }

        }
    }

    public void q2ErrorLexico(String archivo, int movs) {
        //deberia recibir el movs???
        for (int i = actual + movs; i < archivo.length(); i++) {
            conv.convertirCaracter(archivo.charAt(i));
            if (tipo.esEspacio(conv.getAscii()) == true) {
                //insertar en lista error
                actual = actual + movs + 1;
                break;
            } else{
                movs++;
            }
        }
    }

    public void q3Numero(String archivo) {
        int movs = 1;

        for (int i = actual; i < archivo.length(); i++) {
            conv.convertirCaracter(archivo.charAt(i));
            if (tipo.esNumero(conv.getAscii()) == true || tipo.esCero(conv.getAscii()) == true) {
                movs++;

            } else if (tipo.esEspacio(conv.getAscii()) == true) {
                //insertar en lista de tokens desde archivo.charAt(actual-movs) hasta archivo.charAt(actual) 
                actual = actual + movs + 1; //+1 por el espacio
                break;

            } else if (tipo.esPunto(conv.getAscii()) == true) {
                movs++;
                q5Float(archivo, movs);
                break;

            } else {
                movs++;
                q2ErrorLexico(archivo, movs);
                break;
            }
        }
    }

    public void q4Identificador(String archivo) {
        int movs = 1;

        for (int i = actual; i < archivo.length(); i++) {
            conv.convertirCaracter(archivo.charAt(i));
            if (tipo.esEspacio(conv.getAscii()) == true) {
                //insertar en lista de tokens desde archivo.charAt(actual-movs) hasta archivo.charAt(actual) 
                actual = actual + movs + 1; //+1 por el espacio
                break;
                
            } else if (tipo.esNumero(conv.getAscii()) == true) {
                movs++;

            } else if (tipo.esMayuscula(conv.getAscii()) == true) {
                movs++;

            } else if (tipo.esMinuscula(conv.getAscii()) == true) {
                movs++;

            } else {
                movs++;
                q2ErrorLexico(archivo, movs);
                break;
            }
        }
    }

    public void q5Float(String archivo, int movs) {

        for (int i = actual + movs; i < archivo.length(); i++) {
            conv.convertirCaracter(archivo.charAt(i));
            if (tipo.esNumero(conv.getAscii()) == true || tipo.esCero(conv.getAscii()) == true) {
                movs++;

            } else if (tipo.esEspacio(conv.getAscii()) == true) {
                //insertar en lista de tokens desde archivo.charAt(actual-movs) hasta archivo.charAt(actual) 
                actual = actual + movs + 1; //+1 por el espacio
                break;

            } else {
                movs++;
                q2ErrorLexico(archivo, movs);
                break;
            }
        }
    }

    public void q7Caracter(String archivo) {
        int movs = 1;

        for (int i = actual; i < archivo.length(); i++) {
            conv.convertirCaracter(archivo.charAt(i));
            if (tipo.esEspacio(conv.getAscii()) == true) {
                //insertar en lista de tokens desde archivo.charAt(actual-movs) hasta archivo.charAt(actual) 
                actual = actual + movs + 1;
                break;
                
            } else {
                movs++;
                //error léxico (00)
                q2ErrorLexico(archivo, movs);
                break;

            }
        }
    }

}
