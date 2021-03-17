package youtube.engineer.linkedList;

public class LinkedList {
    Node header;

    static class Node{
        int data;
        Node next = null;
    }

    LinkedList(){
        header = new Node();
    }

    void append(int d){
        Node end = new Node();
        end.data = d;
        Node n = header;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    void delete(int d){
        Node n = header;
        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
            }else{
                n = n.next;
            }
        }
    }

    void retrieve(){
        Node n = header.next;
        while(n.next != null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    void removeDups(){
        Node n = header;
        while(n !=null && n.next != null){
            Node r = n;
            while(r.next != null){
                if(n.data == r.next.data){
                    r.next = r.next.next;
                }else{
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    Node getFirst(){
        return header;
    }
}

class testLinkedList{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(2);
        ll.append(3);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(5);
        ll.retrieve();

        ll.removeDups();
        ll.retrieve();

        int k = 3;
        Reference r = new Reference();
        LinkedList.Node node = KthToLast(ll.getFirst(), k,r);
        System.out.println(node.data);

        LinkedList.Node found = KthToLast2(ll.getFirst(), k);
        System.out.println(found.data);
    }


    static class Reference {
        int count = 0;
    }

    private static LinkedList.Node KthToLast(LinkedList.Node n, int k, Reference r){
        if(n == null){
            return null;
        }

        LinkedList.Node found = KthToLast(n.next, k, r);
        r.count++;
        if(r.count == k){
            return n;
        }
        return found;
    }

    private static LinkedList.Node KthToLast2(LinkedList.Node first, int k){
        LinkedList.Node p1 = first;
        LinkedList.Node p2 = first;

        for(int i=0; i<k; i++){
            if(p1 == null) return null;
            p1 = p1.next;
        }
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
