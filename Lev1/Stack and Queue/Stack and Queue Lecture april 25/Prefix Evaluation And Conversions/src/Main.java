import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int operation(int v1,int v2, char op) {
        if(op=='+'){
                return v1+v2;
        }else if(op=='-'){
            return v1-v2;
        }
        else if(op=='*'){
            return v1*v2;
        }
        else {
            return v1/v2;
        }
    }

    public static void main(String arg[]) {
        //input 
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        Stack<Integer> val = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> post = new Stack<>();

        for (int i = exp.length()-1; i >=0 ; i--) {
            char ch = exp.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                //val
                int v1 = val.pop();
                int v2 = val.pop();
                int v = operation(v1,v2,ch);
                val.push(v);

                //infix
                String infixV1= infix.pop();
                String infixV2= infix.pop();
                String infixV = "("+infixV1+ch+infixV2+")";
                infix.push(infixV);

                // post
                String postV1= post.pop();
                String postV2= post.pop();
                String postV = postV1+postV2+ch;
                post.push(postV);

            }else{
                val.push(ch-'0');
                infix.push(ch+"");
                post.push(ch+"");

            }
        }
        System.out.println(val.peek());
        System.out.println(infix.peek());
        System.out.println(post.peek());

    }
}
