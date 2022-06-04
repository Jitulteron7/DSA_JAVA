import java.util.*;

public class Main {

    public  static  int precedance(char op){
        if(op =='+'||op=='-'){
            return 1;
        }else if(op=='/'||op=='*'){
            return  2;
        }else{
            return 0;
        }
    }
    public static int operation(int v1,int v2,char op){
        if(op=='+'){
            return v2+v1;
        }else if(op=='-'){
            return v2-v1;
        }else if(op == '/'){
            return v2/v1;
        }else {
            return v2*v1;
        }
    }

    public  static  void main(String arg[]){
        Scanner  scn = new Scanner((System.in));
        String exp = scn.nextLine();

        Stack<Character> optors = new Stack<>();
        Stack<Integer> opdans = new Stack<>();

        for (int i = 0; i <exp.length() ; i++) {
                char ch  = exp.charAt(i);

                if(ch=='('){
                    optors.push(ch);
                }else if(Character.isDigit(ch)){
                    opdans.push(ch-'0'); //converting characters to digit
                }else if(ch == ')'){
                    while(optors.peek()!='('){
                        char op = optors.pop();
                        int v1 = opdans.pop();
                        int v2 = opdans.pop();
                        int result  = operation(v1,v2,op);
                        opdans.push(result);

                    }
                    optors.pop();

                }else if(ch=='+'||ch=='-'||ch=='/'||ch=='*'){
                    //ch wants to solve higher priority operators first
                    while(optors.size()>0 && precedance(ch)<=precedance(optors.peek()) && ch!='('){
                        char op = optors.pop();
                        int v1 = opdans.pop();
                        int v2 = opdans.pop();
                        int result  = operation(v1,v2,op);
                        opdans.push(result);
                    }
                    //ch push itself
                        optors.push(ch);
                }
        }

        while(optors.size()!=0){
            char op = optors.pop();
            int v1 = opdans.pop();
            int v2 = opdans.pop();
            int result  = operation(v1,v2,op);
            opdans.push(result);
        }

        System.out.println(opdans.peek());
    }
}
