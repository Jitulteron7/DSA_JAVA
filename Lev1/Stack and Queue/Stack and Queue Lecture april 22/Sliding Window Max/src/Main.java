import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main{


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        // code
        Deque<Integer> dq = new ArrayDeque<>();
        // for first 4 elements
        for (int i = 0; i < k; i++) {

            while(dq.size()>0&&a[dq.getLast()]<a[i]){
                    dq.removeLast();
            }
            dq.addLast(i);
        }

        System.out.println(a[dq.getFirst()]);
        // for rest of the elements
        for (int i = k; i < n; i++) {

            while(dq.size()>0&&a[dq.getLast()]<a[i]){
                dq.removeLast();
            }
            dq.addLast(i);

            if(i-dq.peek()>=k){
                dq.removeFirst();
            }
            System.out.println(a[dq.getFirst()]);
        }
    }
}