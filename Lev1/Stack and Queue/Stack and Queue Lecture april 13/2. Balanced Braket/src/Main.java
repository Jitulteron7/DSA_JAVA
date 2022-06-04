import java.util.Scanner;
import java.util.Stack;

public  class Main{

    public static  boolean charDetect(Stack<Character> s, Character cores){
        if(s.size()==0){
            return false;
        }
        else if(s.peek()==cores){
            s.pop();
            return true;
        }else {
            return false;
        }
    }
    public static  void main(String arg[]){

            Scanner scn = new Scanner(System.in);
            String exp = scn.nextLine();
            Stack<Character> s = new Stack<>();

            for(int i =0;i<exp.length();i++){
                char ch =exp.charAt(i);
                if(ch =='('||ch=='['||ch=='{'){
                    s.push(ch);
                }else{

                    if (ch==')'){
                        boolean val = charDetect(s,'(');
                        if(!val){
                            System.out.println(false);
                            return;
                        }
                    }
                    else if (ch=='}'){
                        boolean val = charDetect(s,'{');
                        if(!val){
                            System.out.println(false);
                            return;
                        }
                    }else if (ch == ']'){
                        boolean val = charDetect(s,'[');
                        if(!val){
                            System.out.println(false);
                            return;
                        }
                    }
                }
            }

            if(s.size()==0){
                System.out.println(true);
            }else{
                System.out.println(false);
            }

    }
}
