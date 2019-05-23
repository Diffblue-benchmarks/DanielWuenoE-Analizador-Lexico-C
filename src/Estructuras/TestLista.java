package Estructuras;

public class TestLista {
    
    public void test() {
        Listas al = new Listas();
        al.agregarElementoLErrores("un error");
        al.agregarElementoLErrores("dos error");
        al.agregarElementoLErrores("tres error");
        al.agregarElementoLErrores("cuatro error");
        
//        al.mostrarLista();
    }
    
    public static void main(String[] args) {
        TestLista t = new TestLista();
        t.test();
    }
}