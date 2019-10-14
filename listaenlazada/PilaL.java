package listaenlazada;

public class PilaL extends LinkedList {    
    public Nodo pop() {
        if (this.isEmpty())
            return null;
        else if(this.start.getNext() != null && this.end.getPrevious() != null) {
            Nodo aux = this.end;
            this.end = this.end.getPrevious();
            this.end.setNext(null);
            this.elements--;
            return aux;
        } else {
            this.elements--;
            return this.end;
        }
    }
}
