package com.bridgelabz.ds;

public class LinkedList<T> {
	private Node<T> head;
    private Node<T> tail;
    
    public boolean isEmpty(){
		return head==null;
	}
    
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
    
    public boolean search(T key){
		Node<T> temp=head;
		while(temp.getNextRef()!=null){
			if( String.valueOf(key).compareToIgnoreCase(String.valueOf(temp.getValue())) == 0){
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
    
    public int print() {

		Node<T> tmp = head;
		int i = 0;
		while (true) {
			if (tmp == null) {
				break;
			}
			if(tmp.getValue()!=null)
			{
				System.out.println(tmp.getValue());
				i++;
			}
			tmp = tmp.getNextRef();
		}
		return i;
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
    
    public int index(T data){
		Node<T> curr=head;
		int count=0;
		while(curr!=null){
			if((String.valueOf(curr.getValue())).compareToIgnoreCase(String.valueOf(data))==0){
				curr.getNextRef();
				return count;
			}
			count++;
			curr=curr.getNextRef();
		}
		assert(false);
		return 0;
	}

}
