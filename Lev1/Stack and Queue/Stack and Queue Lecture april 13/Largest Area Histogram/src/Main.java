import java.util.*;
// incomplete solution
public class Main{
    public static  int maxArea(int a[],int area){
        int n = a.length;

        // from the right boundary
        int nseR[] = new int[n];
        Stack<Integer> sR = new Stack<>();
        nseR[n-1] = n;
        sR.push(n-1);


        for(int i =n-2;i>=0;i--){

            while(sR.size()>0&&a[i]<=a[sR.peek()]){
                sR.pop();
            }

            if(sR.size()==0){
                nseR[i] = i+1;
            }else{
                nseR[i] = sR.peek();
            }

            sR.push(i);

        }



        int nseL[] = new int[n];
        nseL[0] = -1;
        Stack<Integer> sL = new Stack<>();

        for(int i =1;i<n;i++){

            while(sL.size()>0&&a[i]<=a[sL.peek()]){
                sL.pop();
            }

            if(sL.size()==0){
                nseL[i] = i+1;
            }else{
                nseL[i] = sL.peek();
            }

            sL.push(i);

        }

        //finding the max area
        for (int i = 0; i < n; i++) {
            int width = nseR[i]-nseL[i]-1;
            int currArea = a[i]*width;

            if(currArea>area){
                area = currArea;
            }
        }

        return area;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        int area = 0;
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }

        area = maxArea(a,0);
        System.out.println(area);
        // code
    }
}