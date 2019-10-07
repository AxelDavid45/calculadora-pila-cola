package cola;
import pila.Pila;

public class Cola<E> extends Pila {
    public Cola(){
        super();
    }

    public Cola(int t) {
        super(t);
    }

    @Override
    public E pop() {
        if (this.isEmpty())
            return null;
        else  {
            E aux;
            aux = (E) this.arreglo[0];
            this.tope--;
            for (int i = 0; i < tope; i++)
                    this.arreglo[i] = this.arreglo[i + 1];
            this.arreglo[this.tope] = null;
            return aux;
        }
    }
}
