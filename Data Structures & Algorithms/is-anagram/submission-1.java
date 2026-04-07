class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(Character ch : s.toCharArray()){
            charMap.put(ch, charMap.getOrDefault(ch, 0)+1);
        }
        for(Character ch : t.toCharArray()){
            int count = charMap.getOrDefault(ch, 0);
            if(count == 0)
                return false;
            else
                charMap.put(ch, count-1);
        }
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
            if(entry.getValue() != 0)
                return false;
        }
        return true;
    }
}
