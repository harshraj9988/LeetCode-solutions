from typing import List


class Solution:
    def maximumCostSubstring(self, s: str, chars: str, vals: List[int]) -> int:
        arr = [-1001] * len(s)
        for i in range(len(s)):
            for j in range(len(chars)):
                if s[i] == chars[j]:
                    arr[i] = vals[j]
                    break
            if arr[i] == -1001:
                arr[i] = ord(s[i]) - ord('a')

        maxi, temp = 0, 0
        for x in arr:
            if x > temp + x:
                temp = x
            else:
                temp += x
            maxi = max(maxi, temp)
        return maxi
