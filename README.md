# LintCode
My own soltions to questions on LintCode
1 Edit Distance
Dynamic Programming: The ith position at word1, the j th position at word2:
                     If the two characters are different: 1 + Min(delete, add, replace)
                     else: the value equals the value at (i = i - 1 && j = j - 1)
