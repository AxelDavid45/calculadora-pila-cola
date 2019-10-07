package pila;

public class Pila<E> {
    protected Object[] arreglo;
    protected int tope, tamano;

    public Pila() {
        this.arreglo = null;
        this.tope = 0;
    }

    public Pila(int t) {
        this.arreglo = new Object[t];
        this.tope = 0;
    }

    public boolean isEmpty() {
        if (this.tope == 0)
            return true;
        return false;
    }

    public boolean isFull() {
        if (this.tope == this.arreglo.length)
            return true;
        return false;
    }

    public int getSize() {
        return this.arreglo.length;

    }

    public int count() {
        return this.tope;
    }

    public void clear() {
        this.tope = 0;
        this.arreglo = new Object[this.arreglo.length];
    }

    public void push(E e) {
        if (this.isFull())
            System.out.println("Pila llena");
        else
            this.arreglo[this.tope++] = e;
    }

    public E pop() {
        E aux;
        if (isEmpty())
            return null;
        else {
            aux = (E) this.arreglo[--this.tope];
            this.arreglo[this.tope] = null;
            return aux;
        }
    }

    public E getLast() {
        int aux = this.tope;
        if (aux != 0)
            return (E) this.arreglo[--aux];
        else
            return null;
    }
}
