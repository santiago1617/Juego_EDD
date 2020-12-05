/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author tagoa
 */
public class ArrayList<E> implements List<E> {
    
    private E[] elements;
    private int capacity = 10;
    private int effectiveSize;
    
    public ArrayList(){ //Todas las TDA van a inicializar vacias
        //No se puede hacer new de E directamente, por ello tienes que hacer el casting 
        elements = (E[]) new Object[capacity];    
        effectiveSize = 0;
    }
    
    @Override
    public boolean addFirst(E element) {
        if(element == null){
            return false;
        }else if(isEmpty()){
            elements[effectiveSize ++] = element;
            return true;
        }else if (capacity == effectiveSize){
            addCapacity();
        }
        
        for(int i = effectiveSize -1 ; i >= 0; i-- ){
            elements[i+1] = elements[i];
        }
        
        
        elements [0] = element;
        effectiveSize++;
        return true;   
    }
    
    public boolean insert (int  index, E element){
        if(element == null || index >= effectiveSize)
            return false;
        else if (effectiveSize == capacity)
            addCapacity();
        
        for(int i = effectiveSize; i > index; i--){
            elements[i] = elements[i-1];
        }
        
        elements[index] = element;
        effectiveSize++;
        return true;
    }
    
    @Override
    public boolean addLast(E element) {
        if(element == null){
            return false;
        }else if(effectiveSize == capacity){
            addCapacity();
        }
        
        elements[effectiveSize++] = element;
        return true;
    }
    
    private void addCapacity(){
        E[] tmp = (E[]) new Object [capacity*2];
        for(int i = 0; i < capacity; i++){
            tmp[i] = elements[i];
        }
        elements = tmp;
        capacity = capacity*2;
    }

    
    public E getFirst() {
        return elements[0];
    }

    
    public E getLast() {
        return elements[effectiveSize -1];
    }

    
    @Override
    public E removeFirst() {
        if(isEmpty())
            return null;
        effectiveSize--;
        E elemento=elements[0];
        for(int i = 0; i < effectiveSize; i++){
            elements[i] = elements[i+1];
        }
        
        elements[effectiveSize] = null;
        return elemento;
    }

    public E removeLast() {
        if(isEmpty()){
            return null;
        }
        E element=elements[effectiveSize];
        elements[--effectiveSize] = null;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    public boolean contains(E element) {
        if(element == null || isEmpty()){
            return false;
        }
        
        for(int i = 0; i < effectiveSize ; i++){
            if(elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");
        
        for(int i = 0; i < effectiveSize; i++){
            if(i != effectiveSize-1){
                s.append(elements[i] + ", ");
            }else
               s.append(elements[i]);
        }
        
        s.append("]");
        return s.toString();
    }
    
    public List<E> slicing(int start, int end){
        List<E> lista = new ArrayList<>();
        if(start >= end || end > effectiveSize) {
            return lista;
        }
        
        for(int i = start; i < end; i++ ){
            lista.addLast(elements[i]);
        }
        
        return lista;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null || ! (o instanceof ArrayList))
            return false;
        
        ArrayList<E> other = (ArrayList<E>) o;
        
        if(this.effectiveSize != other.effectiveSize)
            return false;
        
        for(int i =0; i< effectiveSize ;i++){
            if(!this.elements[i].equals(other.elements[i]))
                return false;
        }
        
        return true;
    }

    public E get(int index) {
        if(effectiveSize == 0 || index < 0 || index >= effectiveSize){
            return null;
        }
        return elements[index];
    }

    public int indexOf(E element) {
        if (element == null){
            return -1;
        }
        
        for(int i = 0; i < effectiveSize; i++){
            if(elements[i].equals(element)){
                return i;
            }
        }
        
        return -1;
    }

    public E remove(int index) {
        if(effectiveSize == 0 || index < 0 || index >= effectiveSize){
            return null;
        }
        E element = elements[index];
        for(int i = index; i < effectiveSize-1; i++){
            elements[index] = elements[index +1];
        }
        elements[effectiveSize-1] = null;
        effectiveSize --;
        return element;
    }

    public boolean remove(E element) {
        if(element == null) {
            return false;
        }
        
        for(int i = 0; i < effectiveSize; i++){
            if(elements[i].equals(element)){
                remove(i);
                return true;
            }
        }
        
        return false;
    }

    public E set(int index, E element) {
        if (element == null || index < 0 || index >= effectiveSize){
            return null;
        }
        
        E i = elements[index];
        elements[index] = element;
        return i;
    }

    @Override
    public int size() {
        return effectiveSize;
    }
    
    public ListIterator<E> listIterator(int index){
        ListIterator<E> it = new ListIterator<E>(){
            
            private int i = index;
            
            @Override
            public boolean hasNext() {
                return i < effectiveSize && i >= 0;
            }

            @Override
            public E next() {
                E tmp = get(i);
                i++;
                return tmp;
            }

            @Override
            public boolean hasPrevious() {
                return i > 0 && i < effectiveSize;
            }

            @Override
            public E previous() {
                E tmp = get(i);
                i--;
                return tmp;
            }

            @Override
            public int nextIndex() {
                return i + 1;
            }

            @Override
            public int previousIndex() {
                return i - 1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        return it;
    } 
    
    
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>(){ 
            
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < effectiveSize;
            }

            @Override
            public E next() {
                E tmp = get(index);
                index++;
                return tmp;
            }
            
        };
        
        return it;
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[10];  
    }
}


