class Solution {    
    public int characterReplacement(String s, int k) {   
            if (s.length() == 0) return 0;
            int max_win = 0;
            int l = 0;
            int len = s.length();
            int r = 0;
            int currentWindowLength = 1;
            int ans = 0;
            int current_max_from_hashmap = 0;
            char curr_max = s.charAt(0);
            Map<Character, Integer> charMap = new HashMap<>();
            Character ch = s.charAt(0);
            int existingCount = 0;
            int updatedCount = 0;
            while (r < len) {
                ch = s.charAt(r);
                existingCount = charMap.getOrDefault(ch, 0);
                updatedCount = existingCount + 1;
                
                charMap.put(ch, updatedCount);
                if ( updatedCount >= current_max_from_hashmap) {
                    current_max_from_hashmap = updatedCount;
                    curr_max = ch;
                }

                while(currentWindowLength - current_max_from_hashmap > k) {
                    charMap.put(s.charAt(l), charMap.get(s.charAt(l)) - 1);                      
                        l++;
                        currentWindowLength--;
                        
                }
                if (currentWindowLength - current_max_from_hashmap <= k) {
                    if (ans < currentWindowLength) {
                        ans = currentWindowLength;
                    }
                }
                
                r++;
                currentWindowLength++;
            }
            
            return ans;
        }
}
