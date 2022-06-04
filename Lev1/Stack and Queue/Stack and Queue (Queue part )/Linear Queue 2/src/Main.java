import java.io.*;

// FIFO

// Here in this method we are using static array
// So size is fixed. Now
// Working:
// on add val will be added from the rear part (rear = front+size). After addition size increase by 1
// on remove front value is returned then front pointer is increased and size is decreased
// Note : unlike the previous algo here we are able to add value [even after size is full then remove and then add ]
// eg input
/*
        3
        add 10
        add 20
        add 30
        display
        peek
        remove
        add 40
        display
        quit
*/
// we will get and error :  Index 3 out of bounds for length 3
// This is a linear queue

// operation:
// Time complexity
// display() O(n)
// add() O(1)
// remove() O(n)
// peek() O(1)
// but time complexity of remove is now o(n)
// so to remove this problem we use Circular Queue

public class Main {

    public static class CustomQueue {
        int[] data;
        // int front [no use of front since front index will not move]
        int rear;
        int size;


        public CustomQueue(int cap) {
            data = new int[cap];
            rear = -1;
            size = 0;
        }

        int size() {
            // write ur code here
            return size;
        }

        void display() {
            // write ur code here
            for (int i = 0; i < size; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            // write ur code here
            if(size==data.length){
                System.out.println("Queue overflow");
            }
            else{
                data[++rear]=val;
                size++;
            }
        }

        int remove() {

            if(size==0){
                System.out.println("Queue underflow");
                return -1;
            }else{

                int front = data[0];
                for (int i = 0; i <rear ; i++) {
                    data[i]=data[i+1];
                }
                data[rear] = 0;
                rear--;
                size--;
                return front;
            }

            // write ur code here
        }

        int peek() {
            // write ur code here
            if(size==0){
                System.out.println("Queue underflow");
                return -1;
            }
            return data[0];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomQueue qu = new CustomQueue(n);

        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if(str.startsWith("remove")){
                int val = qu.remove();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("peek")){
                int val = qu.peek();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(qu.size());
            } else if(str.startsWith("display")){
                qu.display();
            }
            str = br.readLine();
        }
    }

}