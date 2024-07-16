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
        if (top >= (n - 1)) {
            System.out.println("Stack Overflow");
        } else {
            top = top + 1;
            arr[top] = x;
        }
        return;
    }

    char pop() {
        if (top == -1) {
            return '$';
        } else {
            top = top - 1;
            return arr[top + 1];
        }
    }

    char peek() {
        if (top == -1) {
            return '$';
        } else {
            return arr[top];
        }
    }

    void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i] + " ");
        }
        return;
    }

    String reverseString(String s) {
        String r = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                r += ')';
            } else if (s.charAt(i) == ')') {
                r += '(';
            } else {
                r += s.charAt(i);
            }
        }
        r += ')';
        return r;
    }

    String postFix(String s) {
        String r = reverseString(s);
        System.out.println(r);
        push('(');
        String ans = "";
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) == '(') {
                push(r.charAt(i));
            } else if (r.charAt(i) >= 'a' && r.charAt(i) <= 'z') {
                ans += (r.charAt(i));
            } else if (r.charAt(i) == ')') {
                while(peek()!='('){
                    char a = pop();
                    ans += a;
                }
                pop();
            } else {
                int p = precedence(r.charAt(i));
                int k = precedence(peek());
                if (r.charAt(i) == '^') {
                    while (peek() != '(') {
                        k = precedence(peek());
                        if (k == 6) {
                            char a = pop();
                            ans += a;
                        } else {
                            break;
                        }
                    }
                    push(r.charAt(i));
                } else {
                    while (peek() != '(') {
                        k = precedence(peek());
                        if (k == p || k < p) {
                            break;
                        } else if (k > p) {
                            char a = pop();
                            ans += a;
                        }
                    }
                    push(r.charAt(i));
                }
            }
            System.out.println("stack at "+i+"=");
            display();
            System.out.println("ans at "+i+"="+ans);
        }
        return reverseString(ans);
    }

    int precedence(char a) {
        if (a >= 'a' && a <= 'z') {
            return 7;
        }
        switch (a) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 3;
            case '/':
                return 3;
            case '^':
                return 6;
            case '(':
                return 0;
            case ')':
                return 0;
            default:
                return -5;
        }
    }
}

public class InfixToPrefix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the infix String:");
        String s = sc.next();

        MyStack st = new MyStack((s.length() + 1));
        System.out.println(st.postFix(s));
    }

}