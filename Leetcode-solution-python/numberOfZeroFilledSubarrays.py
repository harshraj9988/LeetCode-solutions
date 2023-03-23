from typing import List


class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        zeros = 0
        ans = 0
        for num in nums:
            if num == 0:
                zeros += 1
                ans += zeros
            else:
                zeros = 0
        return ans
