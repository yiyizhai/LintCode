public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if(word1 == null && word2 == null){
            return 0;
        }else if(word1 == null){
            return word2.length();
        }else if(word2 == null){
            return word1.length();
        }
        
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] num = new int[len1 + 1][len2 + 1];
        if(len1 == 0){
            return len2;
        }
        if(len2 == 0){
            return len1;
        }
        
          for(int i = 0; i <= len2; i++){
            num[0][i] = i;
        }
        for(int i = 0; i <= len1; i++){
            num[i][0] = i;
        }
        
        for(int i = 1; i< len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    num[i][j] = num[i - 1][j - 1];
                }else{
                    num[i][j] = 1 + Math.min(num[i - 1][j - 1], Math.min(num[i][j - 1], num[i - 1][j]));
                }
            }
        }
      
        return num[len1][len2];
    }

}