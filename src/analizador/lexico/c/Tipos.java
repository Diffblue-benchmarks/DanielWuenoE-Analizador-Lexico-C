package Lexico;

public class Tipos {
    
    public boolean esMayuscula(int ascii){              //verifica si el caracter es mayuscula
        if(ascii >= 65 && ascii <= 90)
            return true;
        else
            return false;
    }
    
    public boolean esMinuscula(int ascii){              //verifica si el caracter es minuscula
        if(ascii >= 97 && ascii <= 122)
            return true;
        else
            return false;
    }
    
    public boolean esNumero(int ascii){                 //verifica si el caracter es numero
        if(ascii >= 48 && ascii <= 57)
            return true;
        else
            return false;
    }
    
    public boolean esCaracter(int ascii){               //verifica si el caracter es caracater especial
        if((ascii >= 33 && ascii <= 47) || (ascii >= 58 && ascii <= 64))
            return true;
        else
            return false;
    }
}
