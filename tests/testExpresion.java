package tests;
import expresiondetection.Expression;

/**
 *
 * @author axele
 */
public class testExpresion {
    public static void main(String[] args) {
        Expression expresion = new Expression("5+6/11");
        System.out.println(expresion.eval());
    }
    
}
