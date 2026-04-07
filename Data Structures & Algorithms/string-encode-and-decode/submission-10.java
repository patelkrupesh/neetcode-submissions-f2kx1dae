class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i).length());
            sb.append("#");
            sb.append(strs.get(i));
            
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {        
        List<String> result = new ArrayList<>();
        int currNum = 0;
        for(int i=0;i<str.length();i++){
            while (str.charAt(i) != '#') i++;

            int num = Integer.parseInt(str.substring(currNum, i));
            result.add(str.substring(i+1, i+1+num));
                // System.out.println("got one : "+result);
            currNum = i+1+num;
            i = currNum;
        }
        return result;                                     
    }
}
