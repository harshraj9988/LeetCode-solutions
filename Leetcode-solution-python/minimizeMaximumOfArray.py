import math
from typing import List


def check(arr: List[int], val: int) -> bool:
    nums = arr.copy()
    for i in range(len(nums) - 1, 0, -1):
        if nums[i] > val:
            nums[i - 1] += (nums[i] - val)
            nums[i] = val
    return nums[0] <= val


class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        mini, maxi = min(nums), max(nums)
        ans = 0
        while mini <= maxi:
            mid = mini + (maxi - mini) // 2
            if check(nums, mid):
                ans = mid
                maxi = mid - 1
            else:
                mini = mid + 1
        return ans


class Solution2:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        ans = pre_sum = 0
        for i in range(len(nums)):
            pre_sum += nums[i]
            ans = max(ans, math.ceil(pre_sum / (i + 1)))
        return ans
