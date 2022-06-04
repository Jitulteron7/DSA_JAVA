import java.util.Scanner;
import java.util.Stack;

public class Main {



    public static void main(String arg[]) {
        //input 
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(ch=='d'){
                    st.push(num);
                    num++;
                }else if(ch=='i'){
                    st.push(num);
                    num++;
                    while(!st.isEmpty()){
                        System.out.print(st.pop());
                    }
                }
        }
        st.push(num);
        while (!st.isEmpty()){
            System.out.print(st.pop());
        }


    }
}
