import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }
    public static int[] solve(int[] arr){
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> s = new Stack<>();
        ans[0] = 1;
        s.push(0);
        for(int i =1;i<n;i++){
            while(s.size()>0&&arr[i]>arr[s.peek()]){
                s.pop();
            }
            if(s.size()==0){
                ans[i] = i+1;
            }else{
                ans[i] = i-s.peek();
            }
            s.push(i);

        }
        return ans;

    }
    public static void main(String arg[]){
        //input
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int solution[] = solve(arr);
        display(solution);
    }
}
