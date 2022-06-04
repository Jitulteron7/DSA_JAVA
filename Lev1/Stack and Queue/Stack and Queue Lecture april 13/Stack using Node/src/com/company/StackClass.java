package com.company;

public class StackClass {
     static class Node{
        int data;
        Node next = null;
        public Node(int data){
                this.data = data;
                this.next = null;
        }
    }

    static class Stack{
            public  static Node head;

            public static boolean isEmpty(){
                return head==null;
            }
            public static void push(int data){
                Node newNode = new Node(data);
                if(isEmpty()){
                    head = newNode;
                    return;
                }
                newNode.next = head;
                head = newNode;

            }
            public static int pop(){
                if(isEmpty()){
                    return -1;
                }
                int top  = head.data;
                head =head.next;
                return top;
            }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int top  = head.data;

            return top;
        }
    }

    public static void main(String[] args) {
	// write your code here
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
}
