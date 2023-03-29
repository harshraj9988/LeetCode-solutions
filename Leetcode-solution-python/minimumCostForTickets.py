from typing import List


def binary_search(arr: List[int], target: int) -> int:
    start, end, mid = 0, len(arr) - 1, 0
    while start <= end:
        mid = start + (end - start) // 2
        if arr[mid] < target:
            start = mid + 1
        elif arr[mid] > target:
            end = mid - 1
        else:
            return mid
    return start


class Solution:
    def recursion(self, days: List[int], costs: List[int], day: int, n: int) -> int:
        if day >= n:
            return 0
        one_day_pass = costs[0] + self.recursion(days, costs, day + 1, n)
        seven_days_pass = costs[1] + self.recursion(days, costs, binary_search(days, days[day] + 7), n)
        thirty_days_pass = costs[2] + self.recursion(days, costs, binary_search(days, days[day] + 30), n)
        return min(one_day_pass, seven_days_pass, thirty_days_pass)

    def memoization(self, days: List[int], costs: List[int], day: int, n: int, dp: List[int]) -> int:
        if day >= n:
            return 0
        if dp[day] != -1:
            return dp[day]
        one_day_pass = costs[0] + self.memoization(days, costs, day + 1, n, dp)
        seven_days_pass = costs[1] + self.memoization(days, costs, binary_search(days, days[day] + 7), n, dp)
        thirty_days_pass = costs[2] + self.memoization(days, costs, binary_search(days, days[day] + 30), n, dp)
        dp[day] = min(one_day_pass, seven_days_pass, thirty_days_pass)
        return dp[day]

    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = len(days)
        dp = [-1] * n
        return self.memoization(days, costs, 0, n, dp)


ar = [1, 4, 6, 8, 20]
c = [2, 7, 15]

print(binary_search(ar, 7))
