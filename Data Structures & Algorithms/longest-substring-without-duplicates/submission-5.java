class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int ans = 0;
        int curr = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!charMap.containsKey(ch)){
                charMap.put(ch, i);
                curr++;
                // System.out.println("if curr : "+curr);
                if(ans<curr) ans = curr;
            }else{
                int pos = charMap.get(ch);
                // System.out.println("else curr : "+curr+", pos:"+pos+", i :"+i);
                if(pos>=i-curr){curr = i - pos;            
                }else{
                    curr++;
                    // System.out.println("else if curr : "+curr);
                    if(ans<curr) ans = curr;
                }
                // System.out.println("else curr : "+curr);
                charMap.put(ch, i);
            }
        }
        return ans;
    }
}
