package tests;
import expresiondetection.Expression;


public class testExpresion {
    public static void main(String[] args) {
        Expression expresion = new Expression("8+8");
        System.out.println(expresion.eval());
        
    }
    
}
