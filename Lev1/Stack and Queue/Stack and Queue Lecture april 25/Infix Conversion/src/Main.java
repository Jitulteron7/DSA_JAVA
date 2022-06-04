import java.util.*;

public class Main {

    public static int precedence(char ch) {
        if(ch=='+'||ch=='-'){
                return 1;
        }else if(ch=='*'||ch=='/'){
            return 2;
        }else{
            return 0;
        }
    }




    public static void main(String arg[]) {
        //input 
        Scanner scn = new Scanner(System.in);
        String exp  = scn.nextLine();
        Stack<Character> op = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<String> pre = new Stack<>();

        for(int i =0;i<exp.length();i++){
            char ch = exp.charAt(i);
            if(ch=='('){
                op.push(ch);
            }else if(ch==')'){

                while(op.peek()!='('){
                    //pre
                    char ops  = op.pop();
                    String v2 = pre.pop();
                    String v1 = pre.pop();
                    String v = ops+v1+v2;
                    pre.push(v);

                    // post
                    v2 = post.pop();
                    v1 = post.pop();
                    v = v1+v2+ops;
                    post.push(v);
                }

                op.pop();


            }else if(ch=='+'||ch=='-'||ch=='/'||ch=='*'){

                while(op.size()>0&&precedence(ch)<=precedence(op.peek())){
                    //pre
                    char ops  = op.pop();
                    String v2 = pre.pop();
                    String v1 = pre.pop();
                    String v = ops+v1+v2;
                    pre.push(v);

                    // post
                    v2 = post.pop();
                    v1 = post.pop();
                    v = v1+v2+ops;
                    post.push(v);
                }
                op.push(ch);

            }else if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9')){
                post.push(ch+"");
                pre.push(ch+"");
            }
        }

        while(op.size()>0){
            //pre
            char ops  = op.pop();
            String v2 = pre.pop();
            String v1 = pre.pop();
            String v = ops+v1+v2;
            pre.push(v);

            // post
            v2 = post.pop();
            v1 = post.pop();
            v = v1+v2+ops;
            post.push(v);
        }

        System.out.println(post.peek()+" Post ");
        System.out.println(pre.peek()+" Pre");


    }
}
