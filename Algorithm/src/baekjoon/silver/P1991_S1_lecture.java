package baekjoon.silver;

import java.io.*;
import java.util.*;

class TreeNode {
    char value;
    TreeNode left;
    TreeNode right;

    TreeNode(char value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class P1991_S1_lecture {
    static Map<Character, TreeNode> nodes = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String[] nodeInfo = br.readLine().split(" ");
            char root = nodeInfo[0].charAt(0);
            char left = nodeInfo[1].charAt(0);
            char right = nodeInfo[2].charAt(0);

            if(!nodes.containsKey(root)) {
                nodes.put(root, new TreeNode(root));
            }
            TreeNode rootNode = nodes.get(root);

            if(left != '.') {
                if(!nodes.containsKey(left)) {
                    nodes.put(left, new TreeNode(left));
                }
                rootNode.left = nodes.get(left);
            }

            if(right != '.') {
                if(!nodes.containsKey(right)) {
                    nodes.put(right, new TreeNode(right));
                }
                rootNode.right = nodes.get(right);
            }
        }

        TreeNode root = nodes.get('A');
    }

    public static void preOrderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.println(node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void inOrderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.value);
        inOrderTraversal(node.right);
    }

    public static void postTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        postTraversal(node.left);
        postTraversal(node.right);
        System.out.println(node.value);
    }
}
