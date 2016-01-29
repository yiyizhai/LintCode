public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || B == null){
            return 0;
        }
        
        int lenA = A.length();
        int lenB = B.length();
        
        int[][] num = new int[lenA + 1][lenB + 1];
        
        for(int i = 1; i <= lenA; i++){
            for(int j =1; j <= lenB; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    num[i][j] = Math.max(num[i - 1][j - 1] + 1, Math.max(num[i][j - 1], num[i - 1][j]));
                }else{
                    num[i][j] = Math.max(num[i - 1][j - 1], Math.max(num[i][j - 1], num[i - 1][j]));
                }
            }
        }
        
        return num[lenA][lenB];
    }
}
