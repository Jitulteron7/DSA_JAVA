import java.io.*;
import java.util.*;

// what ? how ? Implication ? why? prove?

public class Main {

    public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            // write your code here
            return data.size();
        }

        void push(int val) {
            if(data.size()==0){
                data.push(val);
                min = val;
            }
            else if(val<min){
                data.push(2*val-min);
                min = val;
            }else{
                data.push(val);
            }
            // write your code here

        }

        int pop() {
            if(data.size()==0){
                System.out.println("Stack underflow");
                return -1;
            }else{
                if(data.peek()<min){
                    int val = min;
                    // note: 2*PushVal(prev push which value is smaller than the previous min ) - prevMin = data.pop() (current top value)
                    // => prevMin = 2*pushVal - data.pop()
                    min = 2*min-data.pop();
                    return val;
                }else{
                    return  data.pop();
                }
            }
        }

        int top() {
            // write your code here
            if(data.size()==0){
                System.out.println("Stack underflow");
                return -1;
            }
            else if(data.peek()<min){
                return min;
            }else{
                return data.peek();
            }

        }

        int min() {
            if(data.size()==0){
                System.out.println("Stack underflow");
                return -1;
            }
            return min;
            // write your code here
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}