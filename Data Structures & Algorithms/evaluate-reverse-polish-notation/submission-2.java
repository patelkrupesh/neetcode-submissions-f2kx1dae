class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String t : tokens){
            if(t.isBlank() || t.isEmpty()) continue;
            // if(t.matches(".*\\d+.*")){
            if(!t.equals("+") && !t.equals("-") && !t.equals("*") && !t.equals("/")){                    
                Integer n = Integer.parseInt(t);
                s.push(n);
            }else{
                if(s.isEmpty()) continue;
                int r = s.pop();
                if(s.isEmpty()) continue;
                int l = s.pop();
                switch(t.charAt(0)){
                    case '+':
                        s.push(l+r);
                        break;
                    case '-':
                        s.push(l-r);
                        break;
                    case '/':
                        s.push((int)l/r);
                        break;
                    case '*':
                        s.push(l*r);
                        break;
                }
            }
        }
        if(s.isEmpty())
            return 0;
        else
            return s.pop();
    }
}
