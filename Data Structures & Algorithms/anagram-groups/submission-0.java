class Solution {
    private int[] primeNums= {2, 3, 5, 7, 11,  //abcde
                        13, 17, 19, 23, 29, //fghij
                        31, 37, 41, 43, 47, //klmno
                        53, 59, 61, 67, 71,  //pqrst
                        73, 79, 83, 89, 97, 101,  //uvwxyz
                        };
    private int getMul(String str){
        int mul = 1;
        for(Character ch : str.toCharArray()){
            mul*=primeNums[ch - 'a'];
        }
        return mul;
    }
    public List<List<String>> groupAnagrams(String[] strs) {        
        Map<Integer, List<String>> anagramMap = new HashMap<>();
        for(String str: strs){
            int mul = getMul(str);
            anagramMap.computeIfAbsent(mul, k-> new ArrayList<>()).add(str);
        }
        List<List<String>> result = new ArrayList<>(anagramMap.values());
        Collections.sort(result, (a, b)-> a.size()-b.size());
        System.out.println(result);
        return result;
    }
}
