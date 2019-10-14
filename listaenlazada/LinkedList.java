package listaenlazada;

public class LinkedList {
    Nodo start, end;
    int elements;
    
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
            e.setPrevious(e);
            this.end = this.end.getNext();
            this.elements++;
        }
    }
    
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
                this.start = this.start.getNext();
                if (this.start == null)
                    this.end = null;
                else
                    this.start.setPrevious(null);
            } else if (aux == this.end) {
                this.end = this.end.getPrevious();
               this.end.setNext(null);
            } else {
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
