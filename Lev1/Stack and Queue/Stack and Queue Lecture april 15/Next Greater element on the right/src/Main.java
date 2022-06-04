import java.util.*;

public class Main {
    public  static  void display(int ans[],int arr[]){
        for(int i =0;i< arr.length;i++){
            System.out.println("Next of greatest of "+arr[i]+" is "+ans[i]);
        }
    }

    public  static  int[] solution(int arr[]){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int ans[ ] = new int[n];
        s.push(arr[n-1]);
        ans[n-1] = -1;
        for(int i = n-2;i>=0;i--){
            while(s.size()>0&&arr[i]>=s.peek()){
                s.pop();
            }
            if(s.size()==0){
                ans[i]= -1;
            }else{
                ans[i] = s.peek();
            }

            s.push(arr[i]);

        }
        return ans;
    }
    public static void main(String arg[]){
        Scanner scn = new Scanner(System.in);
        // intput
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i =0;i<n;i++){
             arr[i] = scn.nextInt();
        }
        int nger[] = new int[n];
        // your code
        nger  = solution(arr);
        // display
        display(nger,arr);
    }
}
