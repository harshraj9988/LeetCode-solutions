from typing import List
from collections import Counter


class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        ans = []
        freq = Counter(nums)
        while len(freq):
            temp = []
            for x in freq:
                if freq[x] > 0:
                    temp.append(x)
                    freq[x] = freq[x] - 1
            if len(temp) == 0:
                return ans
            ans.append(temp)

        return ans
