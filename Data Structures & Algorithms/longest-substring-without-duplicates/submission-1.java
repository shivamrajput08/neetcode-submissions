class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0 , right = 0 , maxlen = 0;
        while(right < s.length()){
            char ch  = s.charAt(right);
            if(!set.contains(ch)){
                set.add(ch);
                maxlen = Math.max(maxlen , right - left + 1);
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxlen;
    }
}
