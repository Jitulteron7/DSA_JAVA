import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int operation(int v1,int v2,char op) {
        if(op=='+'){
            return v1+v2;
        }else if(op=='-'){
            return v1-v2;
        }else if(op == '*'){
            return v1*v2;
        } else {
            return v1/v2;
        }
    }

    public static void main(String arg[]) {
        //input
        Scanner scn = new Scanner(System.in);
        String  exp = scn.nextLine();
        Stack<Integer> ans = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> pre = new Stack<>();

        // code
        for(int i =0;i<exp.length();i++){
            char ch = exp.charAt(i);

            if(ch=='+'||ch=='-'||ch=='/'||ch=='*'){
                // value
                int v2 = ans.pop();
                int v1 = ans.pop();
                int result = operation(v1,v2,ch);
                ans.push(result);
                // infix
                String infixV2 = infix.pop();
                String infixV1 = infix.pop();
                String infixV = "("+infixV1+ch+infixV2+")";
                infix.push(infixV);

                //prefix
                String preV2 = pre.pop();
                String preV1 = pre.pop();
                String preV = ch+preV1+preV2;
                pre.push(preV);

            }else{
                ans.push(ch-'0');
                infix.push(ch+"");
                pre.push(ch+"");
            }

        }

        System.out.println(ans.peek());
        System.out.println(infix.peek());
        System.out.println(pre.peek());

    }
}
