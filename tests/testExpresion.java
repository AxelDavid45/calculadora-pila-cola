package tests;
import expresiondetection.Expression;
import listaenlazada.*;


public class testExpresion {
    public static void main(String[] args) {
        Nodo n1 = new Nodo(1);
        Nodo n2 = new Nodo(2);
        Nodo n3 = new Nodo(3);
        Nodo n4 = new Nodo(4);
        
//        LinkedList l = new LinkedList();
//        l.push(n1);
//        l.push(n2);
//        l.push(n3);
//        System.out.println("Longitud: "+ l.getLenght());

        ColaL cola = new ColaL();
        cola.push(n1);
        cola.push(n2);
        cola.push(n3);
        cola.push(n4);
        
        System.out.println("first " + cola.pop().getDato());
        System.out.println("first " + cola.pop().getDato());
        System.out.println("first " + cola.pop().getDato());
        System.out.println("first " + cola.pop().getDato());

//          PilaL pi = new PilaL();
////          pi.push(n1);
//          pi.push(n2);
//          pi.push(n3);
//          pi.push(n4);
//          System.out.println("last: " + pi.pop().getDato());
//          System.out.println("last: " + pi.pop().getDato());
//          System.out.println("last: " + pi.pop().getDato());
////          System.out.println("last: " + pi.pop().getDato());
    }
    
}
