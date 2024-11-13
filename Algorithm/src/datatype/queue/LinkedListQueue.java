package datatype.queue;

import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E> {

    private Node<E> head; //큐에서 가장 앞에있는 노드 객체를 가리키는 변수
	private Node<E> tail; //큐에서 가장 뒤에있는 노드 객체를 가리키는 변수
	private int size; //큐에 담긴 요소의 개수
	
	public LinkedListQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<E>(value);
            
        // 비어있을 경우 
        if(size == 0) {
            head = newNode;
        }
        // 그 외의 경우 마지막 노드(tail)의 다음 노드(next)가 새 노드를 가리키도록 한다.
        else {
            tail.next = newNode;
        }
        /**
         * tail이 가리키는 노드를 새 노드로 바꿔준다.
         */
        tail = newNode;
        size++;
        
        return true;
    }

    @Override
    public E poll() {
            
        // 삭제할 요소가 없을 경우 null 반환
        if(size == 0) {
            return null;
        }
            
        // 삭제될 요소의 데이터를 반환하기 위한 임시 변수 
        E element = head.data;
            
        // head 노드의 다음노드
        Node<E> nextNode = head.next;
            
        // head의 모든 데이터들을 삭제 
        head.data = null;
        head.next = null;
            
        // head 가 가리키는 노드를 삭제된 head노드의 다음노드를 가리키도록 변경 
        head = nextNode;
        size--;
            
        return element;
    }

    public E remove() {
		
        E element = poll();
            
        if(element == null) {
            throw new NoSuchElementException();
        }
            
        return element;
    }

    @Override
    public E peek() {	
            
        // 요소가 없을 경우 null 반환
        if(size == 0) {
            return null;
        }
        return head.data;
    }

    public E element() {
		
        E element = peek();
            
        if(element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;	
    }

    public boolean contains(Object value) {
		
        /**
         * head 데이터부터 x가 null이 될 때까지 value랑 x의 데이터(x.data)랑
         * 같은지를 비교하고 같을 경우 true를 반환한다.
         */
        for(Node<E> x = head; x != null; x = x.next) {
            if(value.equals(x.data)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
		
        for(Node<E> x = head; x != null; ) {
                
            Node<E> next = x.next;
            x.data = null;
            x.next = null;
            x = next;
        }
        size = 0;
        head = tail = null;
            
    }
}
