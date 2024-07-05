import java.util.*;
public class Practice {
    public static void main(String[] args) {
        String ans="";
        Stack<Character> st = new Stack<>();
        StringBuffer sb;
        st.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if((s.charAt(i)==(s.charAt(i+1)+32)) || ((s.charAt(i)+32)==(s.charAt(i+1)))){
            }else{
                st.push(s.charAt(i));
            }
         }
        for(int i=0;i<st.size();i++){
            ans+=st.pop();
        }
        sb = new StringBuffer(ans);
        return sb.reverse().toString();
    }
}
