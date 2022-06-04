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

    // time complexity O(n)
    // space complexity O(n)
    public static int sizeHelper(Node node){
        // base condition
        // not required because the size =0 for children for loop will not run
        /*if(node.children.size()==0){
            return 0;
        }*/

        // faith
        /*int sizeIs =0;
        for (Node child :node.children) {
             sizeIs += sizeHelper(child);
        }
        sizeIs += node.children.size();
        // my work
        return sizeIs;*/
        //method 2
        int sizeIs = 0;
        for (Node child:node.children) {
            sizeIs+=sizeHelper(child);
        }
        return 1+sizeIs;
    }
    public static int size(Node node){
        int sizeIs = sizeHelper(node);
        //return  1+sizeIs;
        //method 2
        return  sizeIs;
        // write your code here
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        int sz = size(root);
        System.out.println(sz);
        // display(root);
    }

}