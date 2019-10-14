package listaenlazada;

public class ColaL extends LinkedList {
    public Nodo pop() {
        Nodo aux = this.start;
        if (this.isEmpty())
            return null;
        else {
            if (aux == this.start) {
                this.start = this.start.getNext();
                if (this.start == null)
                    this.end = null;
                else
                    this.start.setPrevious(null);
            }
            this.elements--;
            return aux;
        }
    }
}
