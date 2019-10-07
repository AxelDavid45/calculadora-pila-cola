package expresiondetection;

import pila.Pila;
import types.*;
import cola.Cola;
import java.lang.Character;
public class Expression {
    String infija;
    Cola posfija;

    public Expression() {
        infija = null;
        posfija = null;
    }

    public Expression(String in) {
        infija = in;
        this.posfija = new Cola(in.length());
    }

    public int prioridadIn(char character) {
        switch (character) {
            case '(':
                return 0;
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 4;
        }
    }

    public int prioridadOut(char character) {
        switch (character) {
            case '(':
                return 5;
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 4;
            default:
                return 6;
        }
    }


    public Cola aposfija() {
        int apuntador = 0;
        Pila operadores = new Pila(this.infija.length());

        while (apuntador < this.infija.length()) {
            //1. Obtener caracteres de la expresión y repetir los pasos 2 al 4 para cada carácter.
            char caracter = infija.charAt(apuntador);
            //2. Si es un operando, pasarlo a la expresión postfija.
            if (esOperando(caracter))
                this.posfija.push(new Char(caracter));
                //3. Si es operador:
            else if (esOperador(caracter)) {
                //3.1. Si la pila está vacía, meterlo en la pila. Repetir a partir de 1.
                if (operadores.isEmpty())
                    operadores.push(new Char(caracter));
                    //3.2. Si la pila no está vacía:
                else {
                    //3.2.1 Si la prioridad del operador leído es mayor que la prioridad del operador cima de la
                    //pila, meterlo en la pila y repetir a partir de 1.
                    if (prioridadOut(caracter) > prioridadIn(((Char) operadores.getLast()).getValue())) {
                        operadores.push(new Char(caracter));
                        // 3.2.2 Si la prioridad del operador es menor o igual que la prioridad del operador de la cima de
                        //la pila, sacar el operador cima de la pila y pasarlo a la expresión postfija, volver a 3.
                    } else {
                        this.posfija.push(((Char) operadores.pop()).getValue());
                        operadores.push(new Char(caracter));
                    }
                }

            }

            //4. Si es paréntesis derecho:
            else if (esParentesisDerecho(caracter)) {
                //4.1. Sacar el operador cima y pasarlo a la expresión postfija.
                do {
                    this.posfija.push(((Char) operadores.pop()).getValue());
                } while (prioridadIn(((Char) operadores.getLast()).getValue()) != 0);
                //4.2. Si el nuevo operador cima es paréntesis izquierdo, suprimir el elemento cima.
                operadores.pop();
                //4.3. Si la cima no es paréntesis izquierdo, volver a 4.1.
            }
            //4.4. Volver a partir de 1.
            apuntador++;
        }
        //5. Si quedan elementos en la pila, pasarlos a la expresión postfija.
        Char aux;
        while ((aux = (Char) operadores.pop()) != null)
            this.posfija.push(aux.getValue());

        return this.posfija;
    }

    public int eval() {
        this.aposfija();
        Pila operandos = new Pila(this.infija.length());
        int apuntador = 0;
        char caracter;
        Character aux;

        //1. Examinar expresion elemento a elemento: repetir los pasos 2 y 3 para cada elemento.
        while (apuntador <= this.posfija.getSize()) {
            apuntador++;
            System.out.println("");
            caracter = ((Char)this.posfija.pop()).getValue();
            
            //2. Si el elemento es un operando, meterlo en la pila.
            if (esOperando(caracter))
                operandos.push(new Int(Integer.parseInt("" + caracter)));
                //3. Si el elemento es un operador, se simboliza con &, entonces:
            else {
                char amperzan = caracter;
                //3.1 Sacar los dos elementos superiores de la pila, que se denominarán b y a respectivamente.
                int b = ((Int) operandos.pop()).getValue();
                int a = ((Int) operandos.pop()).getValue();
                //3.2 Evaluar a & b, el resultado es z = a & b.
                int z = operacion(amperzan, b, a);
                //3.3 El resultado z, meterlo en la pila. Repetir a partir del paso 1.
                operandos.push(new Int(z));

            }
            

        }
//4. El resultado de la evaluación de la expresión está en el elemento cima de la pila.
        return ((Int) operandos.pop()).getValue();
//5. Fin del algoritmo.
    }

    private int operacion(char amperzan, int b, int a) {
        switch (amperzan) {
            case '^':
                return (int) Math.pow(a, b);
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:
                return 0;
        }
    }

    private boolean esOperando(char caracter) {
        if (caracter == '0' || caracter == '1' || caracter == '2' || caracter == '3' ||
                caracter == '4' || caracter == '5' || caracter == '6' || caracter == '7' ||
                caracter == '8' || caracter == '9')
            return true;
        else
            return false;
    }

    private boolean esOperador(char caracter) {
        if (caracter == '+' || caracter == '-' || caracter == '*' ||
                caracter == '/' || caracter == '^' || caracter == '(')
            return true;
        else
            return false;
    }

    private boolean esParentesisDerecho(char caracter) {
        if (caracter == ')')
            return true;
        else
            return false;
    }

    public String getInfija() {
        return infija;
    }

    public Cola getPosfija() {
        return posfija;
    }
}
