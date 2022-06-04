import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    // global variable
    static  int state = 0;
    static Node predecessor;
    static Node successor;
   /* public static void predecessorAndSuccessor(Node node, int data) {
        // write your code here
        if(state ==0 && node.data==data){
            state = 1;
            return;
        }

        if (state ==0){
            predecessor = node;
        }

        for (Node child:node.children) {
            if(state ==1){
                successor = child;
                state =2;
                return;
            }
            predecessorAndSuccessor(child,data);

        }
    }*/
    //another way to write
    public  static  void predecessorAndSuccessor(Node node, int data){
        if (state==0){
            if(node.data!=data){
                predecessor=node;
            }else{
                state =1;
            }
        }else if(state ==1){
            successor=node;
            state =2;
        }

        for (Node child:node.children) {
            predecessorAndSuccessor(child,data);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        predecessor = null;
        successor = null;
        predecessorAndSuccessor(root, data);
        if(predecessor == null){
            System.out.println("Predecessor = Not found");
        } else {
            System.out.println("Predecessor = " + predecessor.data);
        }

        if(successor == null){
            System.out.println("Successor = Not found");
        } else {
            System.out.println("Successor = " + successor.data);
        }
    }

}