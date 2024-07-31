package datatype.queue;

public class Node<E> {
    E data;
    Node<E> next; // 다음 노드를 가리키는 역할을 하는 변수

    Node(E data){
        this.data = data;
        this.next = null;
    }
}
