import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static  int maxArea(int a[],int area){
        int n = a.length;

        // right smallest element
        Stack<Integer> s = new Stack<>();
        int nSR[] = new int[n];
        nSR[n-1] = n;
        s.push(n-1);

        for(int i=n-2;i>=0;i--){
            while(s.size()>0&&a[i]<=a[s.peek()]){
                    s.pop();
            }

            if(s.size()==0){
                nSR[i] = n;
            }else{
                nSR[i] = s.peek();
            }

            s.push(i);
        }

        // left smallest element
        s = new Stack<>();
        int nSL[] = new int[n];
        nSL[0] = -1;
        s.push(0);

        for(int i=1;i<n;i++){
            while(s.size()>0&&a[i]<=a[s.peek()]){
                s.pop();
            }

            if(s.size()==0){
                nSL[i] = -1;
            }else{
                nSL[i] = s.peek();
            }

            s.push(i);
        }

        for(int i =0;i<n;i++){
            int width = nSR[i]-nSL[i]-1;
            int currArea = a[i]*width;
            if(currArea>area){
                area = currArea;
            }
        }

        return area;
    }
    public static void main(String arg[]){
        // input
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        // solution
        int area =0;
        area = maxArea(arr,area);
        System.out.println(area);

    }
}
