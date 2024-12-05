package datatype.graph;

/**
 * 배열로 나타내는 이진트리(자식 노드가 최대 2개)
 * 트리 이용사례
 * - 파일 시스템
 * - 데이터베이스 인덱스
 * - 컴파일러
 */
public class BinaryTree {
    int[] tree;
    int size;

    public BinaryTree(int size) {
        this.size = size;
        tree = new int[size];
    }

    public void setRoot(int value) {
        tree[0] = value;
    }

    public void setLeft(int parentIndex, int value) {
        int leftIndex = 2 * parentIndex + 1;
        if(leftIndex < size) {
            tree[leftIndex] = value;
        }
        else {
            System.out.println("Index out of bounds for left child");
        }
    }

    public void setLRight(int parentIndex, int value) {
        int rightIndex = 2 * parentIndex + 2;
        if(rightIndex < size) {
            tree[rightIndex] = value;
        }
        else {
            System.out.println("Index out of bounds for right child");
        }
    }
}
