package listaenlazada;

public class LinkedList {
    Nodo start, end; //Nodo iniciales fundamentales
    int elements; //Elementos de la lista
    
   
    public LinkedList() {
        this.start = this.end = null;
        this.elements = 0;
    }
    
    public LinkedList(Nodo e) {
        this.start = this.end = e;
        this.elements = 1;
    }
    
    public boolean isEmpty() {
        return this.elements == 0;
    }
    
    public void push(Nodo e) {
        if (this.isEmpty()) {
            this.start = this.end = e;
            this.elements = 1;
        } else {
            this.end.setNext(e);
            e.setPrevious(this.end);
            this.end = this.end.getNext();
            this.elements++;
        }
    }
    
    /*
        Metodo que devuelve el nodo sin eliminarlo
    */
    public Nodo getAt(int x) {
        if (this.isEmpty() || x > this.elements)
            return null;
        else {
            Nodo aux = this.start;
            int t = 1;
            while (t < x) {
                aux = aux.getNext();
                t++;
            }
             return aux;
        }  
    }
    
    /*
        Metodo que retorna un elemento pero lo elimina de la lista
    */
    public Nodo pop(int x) {
        if (this.isEmpty() || x > this.elements)
            return null;
        else {
            Nodo aux = this.start;
            int t = 1;
            while (t < x) {
                aux = aux.getNext();
                t++;
            }            
            //Caso 1 elemento inicial
            if (aux == this.start) {
                this.start = this.start.getNext(); //El inicio ahora pasa a ser el siguiente
                if (this.start == null)
                    this.end = null; //El end tambien porque no hay nada en la lista
                else
                    this.start.setPrevious(null); //Si el inicio no es nulo ahora el anterior es nulo
            } else if (aux == this.end) { //Cuando el elemento es el ultimo
                this.end = this.end.getPrevious();
               this.end.setNext(null);
            } else { //Cuando esta en el medio
                Nodo aux2;
                aux2 = aux.getNext();
                aux2.setPrevious(aux.getPrevious());
                
                aux2 = aux.getPrevious();
                aux2.setNext(aux.getNext());
            }
            this.elements--;
            return aux;
        }
    }
    
    public int getLenght() {
        return this.elements;
    }
   
}
