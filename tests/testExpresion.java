package tests;
import expresiondetection.Expression;
import cola.Cola;


public class testExpresion {
    public static void main(String[] args) {
        //Expression expresion = new Expression("5+6/11");
        //System.out.println(expresion.eval());
        Cola cola = new Cola(10);
        cola.push(9);
        cola.push(8);
        cola.push(1);
        
        System.out.println(cola.pop());
    }
    
}
