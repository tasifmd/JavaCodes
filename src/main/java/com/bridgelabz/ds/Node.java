package com.bridgelabz.ds;

/**
 * Node class to create own data structure 
 * @author admin1
 * @version 1.0
 * @param <T>
 */
public class Node<T> implements Comparable<T> {
    
   T value;
   Node<T> nextRef;
    
   public T getValue() {
       return value;
   }
   public void setValue(T value) {
       this.value = value;
   }
   public Node<T> getNextRef() {
       return nextRef;
   }
   public void setNextRef(Node<T> ref) {
       this.nextRef = ref;
   }
   public int compareTo(T arg) {
       if(arg == this.value){
           return 0;
       } else {
           return 1;
       }
   }
}
