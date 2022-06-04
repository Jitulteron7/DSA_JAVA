package com.company;

import java.util.Stack;

public class Main {

    public static  void pushToBottom(int data,Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushToBottom(data,s);
        s.push(top);
    }

    public  static  void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverse(s);
        pushToBottom(top,s);
    }
    public static void main(String[] args) {
	// write your code here
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        reverse(s);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
