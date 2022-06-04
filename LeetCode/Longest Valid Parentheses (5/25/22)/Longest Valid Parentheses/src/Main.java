import java.util.Scanner;
import java.util.Stack;

public class Main {

    // approach 1 using stack
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public static class Solution1 {
        public int longestValidParentheses(String s) {
            Stack<Integer> st = new Stack<>();
            int lvp = 0 ;
            st.push(-1);
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch=='('){
                    st.push(i);
                }else {
                    st.pop();
                    if(st.isEmpty()){
                        st.push(i);
                    }else{
                        lvp = Math.max(lvp,i-st.peek());

                    }
                }
            }
            return lvp;

        }
    }
    // approach 2 using without space
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public  static  class Solution2 {
        public  static  int longestValidParentheses(String s ){
            int lvp=0;
            int open =0,close=0;
            // 0 to n
            for (int i = 0; i <s.length() ; i++) {
                char ch = s.charAt(i);
                if(ch == '('){
                    open++;
                }else{
                    close++;
                }
                if(open==close){
                    lvp = Math.max(lvp,2*close);
                }else if(close>open){
                    close= open = 0;
                }
            }

            close= open = 0;
            // n to 0
            for (int i = s.length()-1; i >=0 ; i--) {
                char ch = s.charAt(i);
                if(ch == '('){
                    open++;
                }else{
                    close++;
                }
                if(open==close){
                    lvp = Math.max(lvp,2*close);
                }else if(close<open){
                    close= open = 0;
                }
            }




            return lvp;
        }
    }

    public static void main(String arg[]) {
        //input 
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();

        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();

        int ans1 = solution1.longestValidParentheses(exp);
        int ans2 = solution2.longestValidParentheses(exp);

        System.out.println(ans1);
        System.out.println(ans2);


    }
}
