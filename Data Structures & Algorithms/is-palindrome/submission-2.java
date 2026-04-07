class Solution {
    public boolean isPalindrome(String s) {        
        int r = s.length()-1;
        for(int l=0;l<s.length() && r > l ;l++, r--){
            while(l<s.length() && r > l && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(r > l && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(r)) != Character.toLowerCase(s.charAt(l))){
                System.out.println(Character.toLowerCase(s.charAt(l)) +" is not euqal to "+ Character.toLowerCase(s.charAt(r)));
                return false;
            }
        }
        return true;
    }
}
