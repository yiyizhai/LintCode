# LintCode
My own soltions to questions on LintCode   
###1 Edit Distance   
Dynamic Programming: The ith position at word1, the j th position at word2:   
                     If the two characters are different: 1 + Min(delete, add, replace)    
                     else: the value equals the value at (i = i - 1 && j = j - 1)     
###2 Longest Common Substring (Similiar to LIS):     
  Dynamic Programming: Define transfer functions num(i,j) as when the ith character is included, what the length is gonna be:    
  if A's character at A == B's character at B: num(i,j) = num(i-1, j-1) + 1      
  else: num(i, j) = 0     
  Keep a max value to record the maximum num(i,j), which's gonna be the result     
