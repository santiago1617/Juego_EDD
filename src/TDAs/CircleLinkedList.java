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
    
    public CircleLinkedList(){
        this.last=null;
        this.size=0;
    }

    @Override
    public boolean addFirst(E e) {
        Node node= new Node(e);
        if(e==null) return false;
        else{
            if(this.isEmpty()){
                last=node;
                size++;
                return true;
            }
            else if(!this.isEmpty()){
                if(last.getNext()!=null){
                    node.setNext(last.getNext());
                    node.setPrevious(last);
                    last.getNext().setPrevious(node);
                    
                }
                else if(last.getNext()==null){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
