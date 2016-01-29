public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int lenA = A.length();
        int lenB = B.length();
        
        int[][] num = new int[lenA + 1][lenB + 1];
        for(int i = 0; i <= lenA; i++){
            num[i][0] = 0;
        }
        for(int j = 0; j <= lenB; j++){
            num[0][j] = 0;
        }
        
        int max = 0;
        for(int i = 1; i<= lenA; i++){
            for(int j = 1; j <= lenB; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                        num[i][j] = num[i - 1][j - 1] + 1;
                }else{
                    num[i][j] = 0;
                }
                if(num[i][j] > max){
                    max = num[i][j];
                }
            }
        }
        return max;
    }
}