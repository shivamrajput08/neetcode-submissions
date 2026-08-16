class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n > m) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(char ch : s1.toCharArray()){
            s1Freq[ch-'a']++;
        }
        int left = 0;
        for(int right = 0 ; right < m ; right++){
            s2Freq[s2.charAt(right)-'a']++;
            if(right-left+1 > n){
                s2Freq[s2.charAt(left)-'a']--;
                left++;
            }
            if(arraysEqual(s1Freq , s2Freq)){
                return true;
            }
        }
        return false;
    }
    private boolean arraysEqual(int [] a , int []b){
        for(int i = 0 ; i < 26 ; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}
