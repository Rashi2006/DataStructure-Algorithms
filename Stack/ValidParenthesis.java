import java.util.Scanner;
class Stack {
    int top = -1;
    int n;
    char[] arr;

    Stack(int n) {
        this.n = n;
        arr = new char[n];
    }

    void push(char x) {
        if (top >= (n-1)) {
            System.out.println("Stack Overflow");
        } else {
            top = top + 1;
            arr[top] = x;
            // System.out.println("Element is pushed successfully");
        }
        return;
    }

    char pop() {
        if (top == -1) {
            return 1;
        } else {
            top = top - 1;
            return arr[top+1];
        }
    }
    char peek() {
        if(top != -1){
            return arr[top];
        }else{
            return 1;
        }
       
    }
    boolean isEmpty() {
        if(top==-1) {
            return true;
        }else{
            return false;
        }
    }
}
public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the set of parenthesis:");
        String p = sc.next();

        Stack st= new Stack(p.length());
        int count=0;

        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='(' || p.charAt(i)=='{' || p.charAt(i)=='['){
               st.push(p.charAt(i));
            }else if(p.charAt(i)==')' && !st.isEmpty()){
                if(st.peek()!='('){
                   break;
                }else{
                    st.pop();
                }
                
            }else if(p.charAt(i)==']' && !st.isEmpty()){
                if(st.peek()!='['){
                    break;
                 }else{
                     st.pop();
                 }
               
            }else if(p.charAt(i)=='}' && !st.isEmpty()){
                if(st.peek()!='{'){
                    break;
                 }else{
                     st.pop();
                 }
            }else{
                count++;
            }
        }
        if(st.isEmpty() && count==0){
            System.out.println("Valid");
        }else{
            System.out.println("InValid");
        }
    }
}
