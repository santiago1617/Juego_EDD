/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import javafx.geometry.Point2D;

/**
 *
 * @author tagoa
 */
public class Node<E> {
    private  E contenido;
    private   Node<E> next;
    private Node<E> previous;
    
    
    
    public Node(E contenido){
    this.contenido=contenido;
    this.next=null;
    this.previous=null;
    
    }
    
    public Node(){
        this.contenido=null;
        this.next=null;
        this.previous=null;
        
    }
    
    
    public E getContenido() {
        return (E)contenido;
    }

    public void setContenido(E contenido) {
        this.contenido = contenido;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }


    
    
}
