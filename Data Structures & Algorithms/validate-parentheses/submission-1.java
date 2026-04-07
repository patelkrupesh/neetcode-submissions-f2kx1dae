class Solution {
    private Character getPair(Character ch){
        switch(ch){
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';            
        }
        return null;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch =='['){
                stack.push(ch);
            }else if (ch == ')' || ch == '}' || ch ==']'){
                if(stack.isEmpty() || stack.pop() != getPair(ch)){
                    return false;
                }                
            }            
        }
        if(stack.size()!= 0){
                return false;
                }
        System.out.println(stack);
        return true;
    }    
}
