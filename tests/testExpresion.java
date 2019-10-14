package tests;
import expresiondetection.Expression;
import listaenlazada.*;


public class testExpresion {
    public static void main(String[] args) {
        //Expression expresion = new Expression("8+8");
        //System.out.println(expresion.eval());
        Nodo n1 = new Nodo(1);
        Nodo n2 = new Nodo(2);
        Nodo n3 = new Nodo(3);
        
        LinkedList l = new LinkedList();
        l.push(n1);
        l.push(n2);
        l.push(n3);
        System.out.println("Longitud: "+ l.getLenght());
        
    }
    
}
