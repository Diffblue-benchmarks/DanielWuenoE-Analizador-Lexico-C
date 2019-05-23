package analizador.lexico.c;

public class Clasifica {

    private String caso;
    private int actual;
    Tipos tipo = new Tipos();
    ConversionCaracter conv = new ConversionCaracter();
//

    public void q0(String archivo, int actual) {
        //for (int i = actual; i < archivo.length(); i++) {
        conv.convertirCaracter(archivo.charAt(actual));
        if (tipo.esCero(conv.getAscii()) == true) {
            actual++;
            q1Cero(archivo);
        } else if (tipo.esNumero(conv.getAscii()) == true) {
            actual++;
            q3Numero(archivo);
        } else if (tipo.esMinuscula(conv.getAscii()) == true || tipo.esMayuscula(conv.getAscii()) == true) {
            actual++;
            q4Identificador(archivo);
        } else if (tipo.esCaracter(conv.getAscii()) == true) {
            actual++;
            q7Caracter(archivo);
        } else {
            actual++;
            q2ErrorLexico(archivo, actual);
        }
        //}
    }

    //NOTA: Escribir metodo para insertar en lista
//    public void q1Cero(String archivo) {
//        int movs = 1;
//
//        for (int i = actual; i < archivo.length(); i++) {
//            conv.convertirCaracter(archivo.charAt(i));
//            if (tipo.esEspacio(conv.getAscii()) == true) {
//                //insertar en lista de tokens desde archivo.charAt(actual-movs) hasta archivo.charAt(actual)
//                System.out.println(crearCadena(actual, actual+movs, archivo)+"\tCero");
//                actual = actual + movs;
//                q0(archivo, actual);
//                break;
//                
//            } else {
//                movs++;
//                //error léxico (inicia en 0)
//                q2ErrorLexico(archivo, movs);
//                break;
//
//            }
//
//        }
//    }
    public void q1Cero(String archivo) {
        int movs = 1;

        for (int i = actual; i < archivo.length(); i++) {
            conv.convertirCaracter(archivo.charAt(i));
            if (tipo.esCero(conv.getAscii()) == true) {
                movs++;
            } else if (tipo.esEspacio(conv.getAscii()) == true) {
                if (movs == 2) {
                    //insertar en lista de tokens desde archivo.charAt(actual-movs) hasta archivo.charAt(actual)
                    System.out.println(crearCadena(actual, actual + movs, archivo) + "\tCero");
                    actual = actual + movs;
                    q0(archivo, actual);
                    break;

                } else if (movs > 2) {
                    //error léxico (inicia en 0)
                    q2ErrorLexico(archivo, movs);
                    break;

                }
            } else {
                q2ErrorLexico(archivo, movs);
                break;
            }

        }
    }

    public void q2ErrorLexico(String archivo, int movs) {
        //deberia recibir el movs???
        for (int i = actual + movs - 1; i < archivo.length(); i++) {
            conv.convertirCaracter(archivo.charAt(i));
            if (tipo.esEspacio(conv.getAscii()) == true) {
                //insertar en lista error
                System.out.println(crearCadena(actual, actual + movs, archivo) + "\tError Lexico");
                actual = actual + movs;
                q0(archivo, actual);
                break;
            } else {
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
                System.out.println(crearCadena(actual, actual + movs, archivo) + "\tNumero");
                actual = actual + movs; //+1 por el espacio
                q0(archivo, actual);
                break;

            } else if (tipo.esPunto(conv.getAscii()) == true) {
                movs++;
                q5Float(archivo, movs);
                break;

            } else {
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
                System.out.println(crearCadena(actual, actual + movs, archivo) + "\tIdentificador");
                actual = actual + movs; //+1 por el espacio
                q0(archivo, actual);
                break;

            } else if (tipo.esNumero(conv.getAscii()) == true) {
                movs++;

            } else if (tipo.esMayuscula(conv.getAscii()) == true) {
                movs++;

            } else if (tipo.esMinuscula(conv.getAscii()) == true) {
                movs++;

            } else {
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
                System.out.println(crearCadena(actual, actual + movs, archivo) + "\tFloat");
                actual = actual + movs + 1; //+1 por el espacio
                q0(archivo, actual);
                break;

            } else {
                q2ErrorLexico(archivo, movs);
                break;
            }
        }
    }

//    public void q7Caracter(String archivo) {
//        int movs = 1;
//
//        for (int i = actual; i < archivo.length(); i++) {
//            conv.convertirCaracter(archivo.charAt(i));
//            if (tipo.esEspacio(conv.getAscii()) == true) {
//                //insertar en lista de tokens desde archivo.charAt(actual-movs) hasta archivo.charAt(actual)
//
//                System.out.println(crearCadena(actual, actual + movs, archivo) + "\tCaracter");
//                actual = actual + movs;
//                q0(archivo, actual);
//                break;
//
//            } else if (tipo.esCaracter(conv.getAscii()) == true) {
//                movs++;
//            } else {
//                movs++;
//                //error léxico (00)
//                q2ErrorLexico(archivo, movs);
//                break;
//
//            }
//        }
//    }
    public void q7Caracter(String archivo) {
        int movs = 1;

        for (int i = actual; i < archivo.length(); i++) {
//            System.out.println(i + " : actual");
//            System.out.println(movs + " : movs");
//            System.out.println(archivo.length());
            conv.convertirCaracter(archivo.charAt(i));
            if (tipo.esCaracter(conv.getAscii()) == true) {
                movs++;
//                if (i  == archivo.length()-1) {
//                    System.out.println(crearCadena(actual, actual + movs-1, archivo) + "\tCaracter");
//                    break;
//                }
            } else if (tipo.esEspacio(conv.getAscii()) == true) {
                if (movs == 2) {
                    //insertar en lista de tokens desde archivo.charAt(actual-movs) hasta archivo.charAt(actual)
                    System.out.println(crearCadena(actual, actual + movs, archivo) + "\tCaracter");
                    actual = actual + movs;
                    q0(archivo, actual);
                    break;

                } else if (movs > 2) {
                    System.out.println("espacio en caracter");
                    q2ErrorLexico(archivo, movs);
                    break;

                }

            } else {
                q2ErrorLexico(archivo, movs);
                break;
            }

        }
    }

    public String crearCadena(int i, int f, String archivo) {
        String cad = "";

        for (int j = i; j < f; j++) {
            cad = cad + archivo.charAt(j);
        }

        return cad;
    }

    public void im(String cad) {
        for (int i = 0; i < cad.length(); i++) {
            conv.convertirCaracter(cad.charAt(i));
//            System.out.println(cad.charAt(i)+" : "+conv.getAscii());
            System.out.println(cad.charAt(i) + " : " + i);
        }
    }

    public static void main(String[] args) {
        Clasifica obj = new Clasifica();
        String archivo = "Este .9 Este 0 00 .9 es 002 00t un Ar rA rA3 rA3.s 4.3e4 archivo archivo2 archi. 0. de prueba 12 12.12 0 0 00 edwsd 12 12.1 . . .. edsd # # ##";
        String archivo2 = "e 0 palabra e";
        obj.q0(archivo, 0);
//        obj.im(archivo);

    }

}
