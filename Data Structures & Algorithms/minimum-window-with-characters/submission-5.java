class Solution {
        public static String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t.length() == 0) return "";
        if(t.length() > s.length()) return "";



        Map<Character, Integer> compareMap = new HashMap<>();
        for(Character ch : t.toCharArray()){
            compareMap.put(ch, compareMap.getOrDefault(ch, 0)+1);
        }

        int matchesNeeded = compareMap.size();
        int current_match_count = 0;
        Map<Character, Integer> currMap = new HashMap<>();
        int l = -1;
        int r = -1;
        int result_size = Integer.MAX_VALUE;
        int ans_l = 0;
        int ans_r = 0;
        boolean ansFound = false;

        //start from l
        // right ++ till right is less than size
        // add right to map only if in original map
        //      increase count in map
        //check if the count of our map matches the original map with ==
        //  if yes, increase the matched no ++
        //if matched number >= orgonal string size then it is a potential answer
                // compare with existing answer to check if current is smaller than result.
        // when you are in a match position
                // remove l, if l was included in the map then reduce the count in map
                // if the l count is still >= then do change, but if it is < then resuce the current_match_count--
                // if current_match_count == matchesNeeded then update the result if size is smaller.
        // do this until current_match_count == matchesNeeded is true

        while (r < s.length()-1){
            r++;
            char ch = s.charAt(r);
            if(compareMap.containsKey(ch)){
                currMap.put(ch, currMap.getOrDefault(ch, 0) + 1);
                if(currMap.get(ch) == compareMap.get(ch)){
                    current_match_count++;
                }

                while(matchesNeeded <= current_match_count && l < r){
                    // we got result
                    ansFound = true;
                    if(r - l < result_size){
                        result_size = r - l;
                        ans_l = l;
                        ans_r = r;
                    }

                    l++;
                    if(l < s.length()-1){
                        ch = s.charAt(l);
                        if(currMap.containsKey(ch)){
                            currMap.put(ch, currMap.get(ch) - 1);
                            if(currMap.get(ch) < compareMap.get(ch)){
                                current_match_count --;
                            }
                        }
                    }
                }
            }
        }

        if(!ansFound)
            return "";
        return s.substring(ans_l+1, ans_r+1);
    }
}
