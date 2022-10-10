class Solution {
public:
    bool isValid(string s) {
         stack<char>st; 
        for(auto it: s) {
            if(it=='(' || it=='{' || it == '[') st.push(it); 
            else {
                if(st.size() == 0) return false; 
                char ch = st.top(); 
                st.pop(); 
                if((it == ')' and ch == '(') or  (it == ']' and ch == '[') or (it == '}' and ch == '{')) continue;
                else return false;
            }
        }
        return st.empty(); 
        
    }
};


 // for(int i =0; s[i]!='\0';i++)
//         {
//             if(s[i] == '(' or s[i]=='{' or s[i]=='[')
//                 st.push(s[i]);
//             else{
//                 if(st.empty()) return false;
//                 char c = st.top();
//                 st.pop();
                
//                 if(s[i]==')'&&c=='(' or s[i]=='}' && c=='}' or s[i]==']' && c=='[')
//                     continue;
//                 else{
//                     return false;
//                 }
//             }
//         }
//         return st.empty();