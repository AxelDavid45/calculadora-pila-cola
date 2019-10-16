package listaenlazada;

public class ColaL extends LinkedList {
    public Nodo pop() { //Metodo pop saca el primero de la cola
        Nodo aux = this.start;
        if (this.isEmpty())
            return null;
        else {
            if (aux == this.start) { //Algoritmo para dejar a null la posicion que sacamos
                this.start = this.start.getNext();
                if (this.start == null)
                    this.end = null;
                else
                    this.start.setPrevious(null);
            }
            this.elements--; //Reduccion de la propiedad elementos de la cola
            return aux; //Retornamos el nodo
        }
    }
}
