class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i));
            sb.append(":;");
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {        
        List<String> result = new ArrayList<>();
        int curr = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ':' && i+1<str.length() 
                    && str.charAt(i+1) == ';'){  
                // if(i+2<str.length() && str.charAt(i+2) == '#')
                //     continue;
                int end = i;
                result.add(str.substring(curr, end));
                curr = i+2;
                // System.out.println("got one : "+result);
            }
        }
        return result;                                     
    }
}
