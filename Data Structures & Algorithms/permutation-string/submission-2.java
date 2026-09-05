class Solution {
    private boolean matches(int a[] , int b[]){
        for(int i = 0 ; i< 26 ; i++){
        if(a[i] != b[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(int i = 0 ; i < s1.length() ; i++){
            freq1[s1.charAt(i) - 'a']++;
        }
        int window = s1.length();
        for(int i = 0 ; i < s2.length() ; i++){
            freq2[s2.charAt(i)- 'a']++;
            if(i >= window){
                freq2[s2.charAt(i-window) - 'a']--;
            }
            if(matches(freq1,freq2)) return true;
        }
        return false;
    }
}
