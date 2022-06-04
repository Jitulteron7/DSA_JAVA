import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void findCelebrity(int arr[][]) {

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <arr.length ; i++) {
            s.push(i);
        }

        while(s.size()>1){
            int v2 = s.pop();
            int v1 = s.pop();

            if(arr[v1][v2]==0){// for v1 not knows v2
                s.push(v1);
            }else  {
                s.push(v2);
            }
        }

        int val = s.pop();

        for (int i = 0; i <arr.length ; i++) {
            if(val!=i){
                if(arr[val][i]!=0||arr[i][val]!=1){
                    System.out.println("None");
                    return;
                }
            }
        }

        System.out.println(val);
    }


    public static void main(String arg[]) {
        //input 
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[][] = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = scn.next();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        scn.close();
        // code 
        findCelebrity(arr);
    }
}
