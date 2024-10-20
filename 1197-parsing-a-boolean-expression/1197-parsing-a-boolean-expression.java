class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(ch=='(' || ch==',') continue;
            else if(ch=='f' || ch=='t' || ch=='!' || ch=='|' || ch=='&'){
                st.push(ch);
            }else if(ch==')'){
                boolean isTrue=false, isFalse = false;
                while(st.peek() != '|' && st.peek()!='&' && st.peek()!='!'){
                    char pop = st.pop();
                    if(pop=='t') isTrue = true;
                    if(pop=='f') isFalse = true;
                }
                char op = st.pop();
                if(op=='!') {
                    st.push(isTrue ? 'f':'t');
                }else if(op=='&'){
                    st.push(isFalse ? 'f' : 't');
                }else{
                    st.push(isTrue ? 't' : 'f');
                }
            }
        }
        return st.peek()=='t';
    }
}