class Solution {
    private boolean isValid(String s, int k, int l, int len){
        if(s.length() == 0) return true;
        if(k+1 >= len) return true;
        if(l+len > s.length()){
            return false;
        }
        if(k >= len) return true;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = l ; i < l+len; i++){
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        ArrayList<Integer> sorted = new ArrayList<Integer>(map.values());
        Collections.sort(sorted, Collections.reverseOrder());        
        sorted.remove(0);
        
        int count = 0;
        for(Integer c : sorted){
            count+=c;
        }
        return count<=k ; 
    }
    public int characterReplacement(String s, int k) {   
        if(s.length() == 0) return 0;     
        int max_win = 0;
        int l = 0;
        int len = 0;
        while (l+len <= s.length()){
            if(isValid(s, k, l, len)){                
                if(len > max_win) max_win = len;
                len++;                
            }else{
                l++;
                len--;
            }
        }
        return max_win;
    }
}
