package otheralgo;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String sentence = "Hello My Dear Friend How are You";
        bruteSolution(sentence);
        optimalSolution(sentence);

    }

    public static void bruteSolution(String sentence) {
        Stack<String> st = new Stack<>();
        String str = "";
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                st.push(str);
                str = "";
            } else {
                str += sentence.charAt(i);
            }
        }
        st.push(str);

        String ans = "";

        while (st.size() != 1) {
            System.out.println(st.peek());
            ans += st.peek() + " ";
            st.pop();
        }
        System.out.println(st.peek());
        ans += st.peek();
        System.out.println(ans);
    }
    public static void optimalSolution(String sentence){
        int left = 0;
        int right =sentence.length()-1;
        String temp ="";
        String ans = "";


        while(left<=right){
            char letter = sentence.charAt(left);
            if(letter != ' '){
                temp+= letter;
            }else{
                if(!ans.equals("")){
                    ans = temp + " " + ans;
                }else{
                    ans=temp;
                }
                temp="";
            }
            left++;
        }
        if(!temp.equals("")){
            if(!ans.equals("")){
                ans = temp + " " + ans;
            }else{
                ans=temp;
            }
        }
        System.out.println(ans);
    }
}
