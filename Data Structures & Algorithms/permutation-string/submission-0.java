class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null && s2 == null) return true;
        if(s1.length() == 0) return true;
        if(s2.length() < s1.length()) return false;

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for(Character c1 = 'a'; c1<='z';c1++){
            s1Map.put(c1, 0);
            s2Map.put(c1, 0);
        }
        for(Character ch : s1.toCharArray()){
            s1Map.put(ch, s1Map.get(ch)+1);
        }
        int winLength = s1.length();
        for(int i=0;i<winLength && i<s2.length();i++){
            s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i))+1);
        }
        if(s1Map.equals(s2Map)){
                return true;
            }
        for(int i=0;i+winLength<s2.length();i++){            
            s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i))-1);            
            Character c2 = s2.charAt(i+winLength);
            s2Map.put(c2, s2Map.get(c2)+1);
            if(s1Map.equals(s2Map)){
                return true;
            }
        }
        return false;
    }
}
