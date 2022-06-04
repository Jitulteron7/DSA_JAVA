import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public  static  class Node{
        int data;
        ArrayList<Node> children;
        Node(int data){
             this.data=data;
             children = new ArrayList<>();
        }
    }
    public  static  Node construct(int arr[]){
        Stack<Node> st = new Stack<>();
        Node root = new Node(arr[0]);
        st.push(root);

        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]==-1){
                st.pop();
            }else{
                Node node = new Node(arr[i]);
                st.peek().children.add(node);
                st.push(node);
            }
        }
        return root;
    }
    public  static void display(Node node) {
        // my work
        String str = node.data+" -> ";
        for (Node child :node.children) {
            str+=child.data+", ";
        }
        str+=" .";
        System.out.println(str);

        // faith
        // will print parent->child1,child2...
        for (Node child:node.children) {
            display(child);
        }

    }
    public static void main(String arg[]) {
        int arr[]={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = construct(arr);
        display(root);
    }
}
