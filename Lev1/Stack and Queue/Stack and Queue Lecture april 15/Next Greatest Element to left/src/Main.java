import java.util.*;

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
        int ngL[] = new int[n];
        ngL[0] = -1;
        s.push(arr[0]);
        for(int i =1;i<n;i++){
            while(s.size()>0&&arr[i]>s.peek()){
                s.pop();
            }
            if(s.size()==0){
                ngL[i] = -1;
            }else{
                ngL[i] = s.peek();
            }
            s.push(arr[i]);
        }
        return ngL;
    }
}
