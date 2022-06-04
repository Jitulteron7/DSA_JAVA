import java.util.Scanner;

public class Main {

    public  static  class Pair{
        int st;
        int et;
        Pair(int st,int et){
                this.st = st;
                this.et =et;
        }
        // incomplete

    }
    public  static  void mergeOverlappingIntervals(int arr[][]){

    }
    public static void main(String arg[]) {
        //input 
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[][] = new int[n][2];

        for (int i = 0; i <n ; i++) {
            String line = scn.next();
            arr[i][0] = Integer.parseInt(line.split(" ")[0]);
            arr[i][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);

        // code 

    }
}
