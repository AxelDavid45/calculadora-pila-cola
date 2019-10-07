package tests;
import expresiondetection.Expression;


public class testExpresion {
    public static void main(String[] args) {
        Expression expresion = new Expression("(6-6)/(6*2)");
        System.out.println(expresion.eval());
        
    }
    
}
