import java.util.Scanner;
import java.util.Stack;

public class Main {


    public static void display(int[] a) {


        for (int i =0;i<a.length;i++) {
            System.out.println(a[i]);
        }

    }

    public static void main (String arg[]){
        //input
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int arr[] = new int[n];
            for(int i =0;i<n;i++){
                arr[i] = scn.nextInt();
            }

            int ngL[] = solve(arr);
            display(ngL);
    }

    public static int[] solve(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int nsR[] = new int[n];
        nsR[n-1] = -1;
        s.push(arr[n-1]);
        for(int i =n-2;i>=0;i--){
            while(s.size()>0&&arr[i]<s.peek()){
                s.pop();
            }
            if(s.size()==0){
                nsR[i] = -1;
            }else{
                nsR[i] = s.peek();
            }
            s.push(arr[i]);
        }
        return nsR;
    }
}
