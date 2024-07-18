
import java.util.*;
public class PrefixEvalution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Stack<Integer>st=new Stack<>();

        System.out.println("Enter comma seperated prefix String and please enter comma at first place");
        String s=sc.nextLine();
        char a;
        String r="";
        for(int i=s.length()-1;i>=0;i--){
           
            a=s.charAt(i);
            if(a!=',' && ((a>=48 && a<=57 ) || (a=='-'||a=='+'||a=='/'||a=='*'||a=='^'))){
               r+=a;
               
            }else if(a==','){
                
                System.out.println("r="+r);
                if(r.equals("-")||r.equals("+")||r.equals("/")||r.equals("*")||r.equals("^")){
                  
                    double o2=st.pop();
                    double o1=st.pop();
                    double ans=0;
                    switch(r){
                        case "+":ans=o1+o2;
                                 break;
                        case "-":ans=o1-o2;
                                 break;  
                        case "*":ans=o1*o2;
                                 break;
                        case "/":ans=o1/o2;
                                 break; 
                        case "^":ans=Math.pow(o1,o2);
                                 break;   
                    }
                    st.push((int)ans);
                    System.out.println("ans="+ans);
                }else{
                    
                    int num=Integer.parseInt(r);
                    System.out.println("nums="+num+"i="+i);
                    st.push(num);
                }
                r="";
            }
           
        }
        int ans = st.pop();
        System.out.println("Ans="+ans);
        
    }
}
