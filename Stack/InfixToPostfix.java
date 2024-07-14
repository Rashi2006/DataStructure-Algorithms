import java.util.Scanner;

class MyStack {
    int top = -1;
    int n;
    char[] arr;

    MyStack(int n) {
        this.n = n;
        arr = new char[n];
    }

    void push(char x) {
        if (top >= (n-1)) {
            System.out.println("Stack Overflow");
        } else {
            top = top + 1;
            arr[top] = x;
            System.out.println("Element is pushed successfully");
        }
        return;
    }

    char pop() {
        if (top == -1) {
            return '$';
        } else {
            top = top - 1;
            return arr[top+1];
        }
    }

    void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i] + " ");
        }
        return;
    }

    String postFix(String s){

        push('(');

        String polish="";
        int Rank=0;

        int i=0;
        
        while(i<s.length()){
            char next=s.charAt(i);
            if(top<0){
                return "Invalid String1";
            }

            while(stackPrecedence(arr[top])>inputPrecedence(next)){
                char temp=pop();
                polish+=temp;
                Rank=Rank+rank(temp);
                if(Rank<1){
                    return "Invalid String 2";
                }
            }
            if(stackPrecedence(arr[top])!=inputPrecedence(next)){
                push(next);
            }else{
                pop();
            }
            i++;
        }
        System.out.println("Rank="+Rank);
        if(top!=-1 || Rank!=1){
            return "Invalid String 3";
        }else{
            return polish;
        }
    }

    int inputPrecedence(char r){
        if(r>='a' && r<='z'){
            return 7;
        }
        switch(r){
           case '+': return 1;
           case '-': return 1;
           case '*': return 3;
           case '/': return 3;
           case '^': return 6;
           case '(': return 9;
           case ')': return 0;
           default : return -5;
        }
    }

    int stackPrecedence(char r){
        if(r>='a' && r<='z'){
            return 8;
        }
        switch(r){
           case '+': return 2;
           case '-': return 2;
           case '*': return 4;
           case '/': return 4;
           case '^': return 5;
           case '(': return 0;
           case ')': return -5;
           default : return -5;
        }
    }

    int rank(char r){
        if(r>='a' && r<='z'){
            return 1;
        }
        else {
            return -1;
        }
    }
}

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the infix String:");
        String s = sc.next();

        MyStack st=new MyStack((s.length()+1));
        System.out.println(st.postFix(s));
    }

}
