package expresiondetection;

import types.*; //Agregamos el paquete de tipos de datos a usar
import listaenlazada.*; //Agregamos la pilaL y ColaL

public class Expression {

    String infija;
    ColaL posfija;

    public Expression() {
        infija = null;
        posfija = null;
    }

    public Expression(String in) {
        infija = in;
        this.posfija = new ColaL();
    }

    /*
        Metodo que obtiene prioridad de un operador dentro de la pila (necesario para el algoritmo)
    */
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
    
    /*
        Metodo que obtiene prioridad de un operador fuera de la pila (necesario para el algoritmo)
    */
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
    
    /*
        Metodo que convierte la expresion infija a postfija
    */
    public ColaL aposfija() {
        int apuntador = 0;
        PilaL operadores = new PilaL();

        while (apuntador < this.infija.length()) {
            //Obtenemos caracter por caracter de la expresión
            char caracter = infija.charAt(apuntador);
            
            if (esOperando(caracter)) {
                //Pasarlo a la expresión postfija.
                this.posfija.push(new Nodo((Character) caracter));
            } 
            else if (esOperador(caracter)) {
                if (operadores.isEmpty()) {
                    //Metemos el primer elemento de la expresion en la pila
                    operadores.push(new Nodo((Character) caracter));
                }
                else {
                    if (prioridadOut(caracter) > prioridadIn(((Character) operadores.getAt(operadores.getLenght()).getDato()))) {
                        operadores.push(new Nodo((Character) caracter));
                    } else {
                        //Pasamos el elemento a la cola para la expresion posfija
                        this.posfija.push(new Nodo(((Character) operadores.pop().getDato())));
                        operadores.push(new Nodo((Character) caracter));
                    }
                }

            }
            else if (esParentesisDerecho(caracter)) {
                do {
                    //Sacamos el operador de la cima y hacemos push a la expresión postfija
                    this.posfija.push(new Nodo(((Character) operadores.pop().getDato())));
                    
                } while (prioridadIn(((Character) operadores.getAt(operadores.getLenght()).getDato())) != 0);
                //Si el nuevo operador de la cima es un parentesis izquierdo suprimimos el elemento de la cima
                operadores.pop();
                
            }
            
            apuntador++;
        }

        while (operadores.getLenght() != 0) {
            //Pasamos los elementos restantes de la pila a la expresion
            Character aux;
            aux = (Character) operadores.pop().getDato();
            this.posfija.push(new Nodo(aux));
        }

        return this.posfija;
    }

    /*
        Metodo que evalua la expresion postfija de acuerdo a algoritmo libro joyanes
    */
    public int evaluarExpresion() {
        this.aposfija(); //Llamamos el metodo para que posfija se llene
        PilaL operandos = new PilaL();
        char caracter;
        
        while (this.posfija.getLenght() != 0) {
            //Obtenemos caracter por caracter
            caracter = ((Character) this.posfija.pop().getDato());

            if (esOperando(caracter)) {
                operandos.push(new Nodo(new Int(Integer.parseInt("" + caracter))));
            }
            else {
                char amperzan = caracter;
                //Sacamos dos elementos para evaluarlos
                int b = ((Int) operandos.pop().getDato()).getValue();
                int a = ((Int) operandos.pop().getDato()).getValue();
                //Llamamos el metodo operacion que nos devuelve el resultado
                int z = operacion(amperzan, b, a);
                //El resultado de la operacion lo metemos en la pila
                operandos.push(new Nodo(new Int(z)));

            }
        }
        //Sacamos el elemento porque el ultimo es el resultado
        return ((Int) operandos.pop().getDato()).getValue();
    }

    /*
        Metodo que evalua dos numeros dependiendo el operador
    */
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
    
    /*
        Metodo que comprueba si es un numero del 0-9
    */
    private boolean esOperando(char caracter) {
        return caracter == '0' || caracter == '1' || caracter == '2' || caracter == '3'
                || caracter == '4' || caracter == '5' || caracter == '6' || caracter == '7'
                || caracter == '8' || caracter == '9';
    }

    /*
        Metodo que comprueba que el caracter sea un operador valido
    */
    private boolean esOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*'
                || caracter == '/' || caracter == '^' || caracter == '(';
    }

    /*
        Metodo que comprueba si es un parentesis derecho(necesario para el algoritmo)
    */
    private boolean esParentesisDerecho(char caracter) {
        return caracter == ')';
    }

    public String getInfija() {
        return infija;
    }

    public ColaL getPosfija() {
        return posfija;
    }
}
