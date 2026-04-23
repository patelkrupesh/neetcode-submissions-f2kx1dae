class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dic = new HashMap<>();
        for(String s : strs){
            int[] count = new int[26];
            for(Character ch : s.toCharArray()){
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            // System.out.println(key);
            dic.computeIfAbsent(key, k-> new ArrayList<>()).add(s);            
        }
        List<List<String>> res = new ArrayList(dic.values());
        return res;
    }
}
