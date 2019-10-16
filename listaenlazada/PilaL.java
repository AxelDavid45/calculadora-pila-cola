package listaenlazada;

public class PilaL extends LinkedList {    
    /*
        Metodo que retira un elemento de la Pila eliminandolo(NUll)
    */
    public Nodo pop() {
        if (this.isEmpty())
            return null;
        /* Comprobamos que no sea nulo el valor siguiente o el anterior eso indica que podemos ejecutar el bloque que enlaza el siguiente y el anterior*/
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
