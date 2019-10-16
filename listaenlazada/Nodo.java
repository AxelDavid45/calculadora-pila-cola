package listaenlazada;

public class Nodo<E> {
    protected Object dato; //objeto para guardar el tipo de cualquier dato
    protected Nodo next, previous; //Enlaces a nodos
    
    public Nodo() {
        this.dato = null;
        this.next = this.previous = null;
    }
    
    public Nodo(E dato) {
        this.dato = dato;
        this.previous = this.next = null;
    }
    
    public Nodo(E dato, Nodo next, Nodo previous) {
        this.dato = dato;
        this.next = next;
        this.previous = previous;
    }
    
    public void setDato(E dato) {
        this.dato = dato;
    }
    public E getDato() {
        return (E)this.dato;
    }
    
    public void setPrevious(Nodo x) {
        this.previous = x;
    }
    
    public void setNext(Nodo x) {
        this.next = x;
    }
    
    public Nodo getPrevious() {
        return this.previous;
    }
    
    public Nodo getNext() {
        return this.next;
    }
}