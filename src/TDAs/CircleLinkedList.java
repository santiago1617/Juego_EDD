/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author tagoa
 */
public class CircleLinkedList<E> implements List<E> {

    private Node<E> last;
    private int size;

    public CircleLinkedList() {
        this.last = null;
        this.size = 0;
    }

    @Override
    public boolean addFirst(E e) {
        Node node = new Node(e);
        if (e == null) {
            return false;
        } else {
            if (this.isEmpty()) {
                last = node;
                size++;
                return true;
            } else if (!this.isEmpty()) {
                if (last.getNext() != null) {//Si el Next de last no es null agregamos normalmente
                    node.setNext(last.getNext());
                    node.setPrevious(last);
                    last.getNext().setPrevious(node);

                } else if (last.getNext() == null) {//Si el Next de last es null node apuntara a last y viceversa
                    node.setNext(last);
                    node.setPrevious(last);
                    last.setPrevious(node);

                }
                last.setNext(node);
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addLast(E e) {
        Node node = new Node(e);
        if (e == null) {
            return false;
        } else {
            if (this.isEmpty()) {
                last = node;
                size++;
                return true;
            } else if (!this.isEmpty()) {
                //Si el Next de last no es null el Next de last sera nodo y en previous de none sera last 
                //aplicando tambien que el antiguo Next de last su previous sea none ahora 
                if (last.getNext() != null) {

                    node.setNext(last.getNext());
                    node.setPrevious(last);
                    last.getNext().setPrevious(node);
                    last.setNext(node);

                } else if (last.getNext() == null) {//Si el Next de last es null node apuntara a last y viceversa
                    node.setNext(last);
                    node.setPrevious(last);
                    last.setPrevious(node);
                    last.setNext(node);

                }
                //Definimos a node como el ultimo
                last = node;
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public E removeFirst() {
        Node node=last.getNext();
        if(!this.isEmpty()){
            //Si esque el unico valor es last ya que al hacer addFirst le damos valor a last
            if(last.getNext()==null){
                last=null;
                size--;
            }
            //Si esque hay 2 o mas elementos en la lista
            else if(last.getNext()!=null){
                last.getNext().getNext().setPrevious(last);
                last.setNext(last.getNext().getNext());
                //Si esque last se apunta a si mismo
                if(last.getNext()==last){
                    last.setNext(null);
                    last.setPrevious(null);
                }
                size--;
                
            }
        }
        return (E)node.getContenido();
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
         last=null;
         size=0;
    }

}
