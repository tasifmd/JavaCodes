package com.bridgelabz.ds;

import java.io.Serializable;

/**
 * Class to make custom linked list
 * @author Tasif Mohammed
 * @version 1.0
 * @param <T>
 */
public class LinkedList<T> {
	Node<T> head;
    Node<T> tail;
    
	public boolean isEmpty(){
		return head==null;
	}
    
    /**
     * Add element
     * @param element
     */
    public void add(T element){
         
        Node<T> nd = new Node<T>();
        nd.setValue(element);
        if(head == null){
            head = nd;
            tail = nd;
        } else {
            tail.setNextRef(nd);
            tail = nd;
        }
      
    }
    /**
     * Add element at last position
     * @param data
     */
    public void insertAtLast(T data)
	{
		Node<T> node = new Node<T>();
		node.value = data;
		if(head == null)
		{
			head = node;
			node.value = null;
		}
		else
		{
			Node<T> n = head;
			while(n.nextRef!=null)
			{
				n = n.nextRef;
			}
			node.nextRef = null;
			n.nextRef = node;
		}
	}
    /**
     * Delete element at last position
     * @return
     */
    public T deleteAtLast()
	{
		if(head == null)
			return null;
		else
		{
			Node<T> n = head;
			Node<T> prev = head;
			while(n.nextRef!=null)
			{
				prev = n;
				n = n.nextRef;
			}	
			T data = n.value;
			prev.nextRef = null;
			return(data);
		}
	}
    /**
     * Remove element at specific index
     * @param index
     */
    public void remove(int index){
		if(isEmpty())
			return;
		Node<T> temp=head;
		if(index==0){
			head=temp.getNextRef();
			return;
		}
		for(int i=0;temp!=null && i<index-1;i++){
			temp=temp.getNextRef();
		}
		if (temp == null || temp.getNextRef() == null) 
			return; 
		@SuppressWarnings("unused")
		Node<T> next = temp.getNextRef().getNextRef(); 

		next=temp.getNextRef();
	}
    public void delete(String companyName)
	{
		Node<T> n = head;
		Node<T> prev = head;
		if(n.value.equals(companyName)) {
			head = n.nextRef;
			return;
		}
		while(n.nextRef!=null)
		{			
			if(companyName.equals(n.value))
			{
				prev.nextRef = n.nextRef;
				return;
			}
			prev = n;
			n=n.nextRef;
		}
		prev.nextRef = null;
	}
    public boolean search(Serializable companyName){
		Node<T> temp=head;
		while(temp.getNextRef()!=null){
			if( String.valueOf(companyName).compareToIgnoreCase(String.valueOf(temp.getValue())) == 0){
				return true;
			}
			temp=temp.getNextRef();
		}
		return false;
	}
     
    public void addAfter(T element, T after){
         
        Node<T> tmp = head;
        Node<T> refNode = null;
        System.out.println("Traversing to all nodes..");
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            //add element after the target node
            Node<T> nd = new Node<T>();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if(tmp == tail){
                tail = nd;
            }
            tmp.setNextRef(nd);
             
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void deleteFront(){
         
        if(head == null){
            System.out.println("Underflow...");
        }
        Node<T> tmp = head;
        head = tmp.getNextRef();
        if(head == null){
            tail = null;
        }
    }
     
    public void deleteAfter(T after){
         
        Node<T> tmp = head;
        Node<T> refNode = null;
        System.out.println("Traversing to all nodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            tmp = refNode.getNextRef();
            refNode.setNextRef(tmp.getNextRef());
            if(refNode.getNextRef() == null){
                tail = refNode;
            }
            System.out.println("Deleted: "+tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void traverse(){
         
        Node<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNextRef();
        }
    }
    
    public void print() {

		Node<T> tmp = head;
		while (true) {
			if (tmp == null) {
				break;
			}
			if(tmp.getValue()!=null)
			{
				System.out.println(tmp.getValue());
			}
			tmp = tmp.getNextRef();
		}
	}
    
    public T getElement(int index) {
		Node<T> n = head;
		int count = 0;
		while(n!=null)
		{
			if(count == index)
				return n.value;
			count ++;
			n = n.nextRef;
		}
		return null;
	}
    
    public int size() {

		Node<T> tmp = head;
		int i = 0;
		while (true) {
			if (tmp == null) {
				break;
			}
			if(tmp.getValue()!=null)
			{
				i++;
			}
			tmp = tmp.getNextRef();
		}
		return i;
	}
    
    public int index(String companyName){
		Node<T> curr=head;
		int count=0;
		while(curr!=null){
			if((String.valueOf(curr.getValue())).compareToIgnoreCase(String.valueOf(companyName))==0){
				curr.getNextRef();
				return count;
			}
			count++;
			curr=curr.getNextRef();
		}
		assert(false);
		return 0;
	}
    
    public Object[] convArray(LinkedList<T> li,int len)
	{
		Node<T> nd2 = li.head;
		Object [] str=new Object[len];
		int i=0;
		while (true) {
			if (nd2 == null) {
				break;
			}
			if(nd2.getValue()!=null)
			{
				str[i++]=(Object) nd2.getValue();
				//					i++;
			}
			nd2 = nd2.getNextRef();
		}
		return str;
	}
    
    
    
}