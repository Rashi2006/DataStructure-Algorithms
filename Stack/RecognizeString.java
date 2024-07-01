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
            System.out.println("Element is pushed successfully");
        }
        return;
    }

    int pop() {
        if (top == -1) {
            return -1;
        } else {
            top = top - 1;
            return arr[top+1];
        }
    }

}

public class RecognizeString{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String and please space at the end:");
        String s= sc.nextLine();
        Stack st = new Stack(s.length());
        
        int idx=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='c'){
                idx=i;
                break;
            }else{
                st.push(s.charAt(i));
            }
        }

        boolean isFound=true;
        for(int i=idx+1;i<s.length()-1;i++){
            if(s.charAt(i)!= st.pop()){
                isFound=false;
                break;
            }
        }
        
        if(!isFound ){
            System.out.println("Invalid String");
        }else{
            System.out.println("Valid String");
        }
     }
}
