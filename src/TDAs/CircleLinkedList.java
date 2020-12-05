/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.Iterator;

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

        if (e != null) {
            if (this.isEmpty()) {//Si esta vacio lo relaciono con el mismo
                last = node;
                size++;
                last.setNext(last);
                last.setPrevious(last);
                return true;
            } else {
                if (last.getNext() == last) {//Si esta relacionado con el mismo quito esa relacion y lo relaciono con el nuevo nodo
                    node.setPrevious(last);
                    node.setNext(last);
                    last.setPrevious(node);
                } else {
                    Node temp = last.getNext();
                    temp.setPrevious(node);
                    node.setNext(temp);
                    node.setPrevious(last);

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
        if (e != null) {
            if (this.isEmpty()) {
                last = node;
                last.setNext(last);
                last.setPrevious(last);
                size++;
                return true;
            } else {
                if (last.getNext() == last) {
                    node.setNext(last);
                    node.setPrevious(last);
                    last.setNext(node);
                    last.setPrevious(node);

                } else {
                    Node temp = last.getNext();
                    temp.setPrevious(node);
                    node.setNext(temp);
                    node.setPrevious(last);
                    last.setNext(node);

                }
                last = node;
                size++;
                return true;

            }
        }
        return false;
    }

    @Override
    public E removeFirst() {
        Node node = last.getNext();
        if (!this.isEmpty()) {
            //Si esque el unico valor es last ya que al hacer addFirst le damos valor a last
            if (last.getNext() == last) {
                last = null;

            } //Si esque hay 2 o mas elementos en la lista
            else {
                last.getNext().getNext().setPrevious(last);
                last.setNext(last.getNext().getNext());

            }
            size--;
            return (E) node.getContenido();
        }
        return null;
    }

    @Override
    public E removeLast() {
        Node node = last;
        if (!this.isEmpty()) {
            if (last.getNext() == last) {
                last = null;

            } else {
                Node next = last.getNext();
                Node previous = last.getPrevious();
                next.setPrevious(previous);
                previous.setNext(next);
                last = previous;
            }
            size--;
            return (E) node.getContenido();
        }
        return null;
    }

    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private Node<E> p = last;
            private int cont = 0;

            @Override
            public boolean hasNext() {
                return p != null && p != last && cont != 0;
            }

            @Override
            public E next() {
                E tmp = p.getContenido();
                p = p.getNext();
                cont++;
                return tmp;
            }
        };

        return it;
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
        last = null;
        size = 0;
    }

    public Node<E> getLast() {
        return last;
    }

    public Node<E> getFirst() {
        if (last != null) {
            return last.getNext();
        }
        return null;
    }

    public Node<E> SearchNode(E element) {
        if (!this.isEmpty()) {
            if (element.equals(last.getContenido())) {
                return last;
            } else {
                Node<E> p = last.getNext();
                while (p != last) {
                    if (element.equals(p.getContenido())) {
                        return p;
                    }
                    p = p.getNext();
                }
            }
        }
        return null;
    }

    public void remove(E element) {
        if (!this.isEmpty()) {
            
                Node<E> p = last.getNext();
                while (p != last) {
                    if (element.equals(p.getContenido())) {
                        Node<E> next=p.getNext();
                        Node<E> previous=p.getPrevious();
                        next.setPrevious(previous);
                        previous.setNext(next);
                    }
                    p = p.getNext();
                }
            
        }
    }

        @Override
        public String toString
        
            () {
        if (last.getNext() != null) {
                Node p = last.getNext();
                boolean verdad = true;
                while (p != last) {
                    System.out.println(p.getContenido());
                    p = p.getNext();
                }
                System.out.println(last.getContenido());
            } else {
                System.out.println(last.getContenido());
            }
            return null;
        }

    }
