from typing import List


def lower_bound(arr: List[int], val: int):
    start, end = 0, len(arr) - 1
    while start <= end:
        mid = start + (end - start) // 2
        if arr[mid] > val:
            end = mid - 1
        elif arr[mid] < val:
            start = mid + 1
        else:
            end = mid - 1
    return start


class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        n, m = len(spells), len(potions)
        ans = [0] * n
        potions.sort()
        for i in range(n):
            req = success // spells[i]
            if success % spells[i] > 0:
                req += 1
            if req > potions[m - 1]:
                continue
            total_pairs = m - lower_bound(potions, req)
            ans[i] = total_pairs
        return ans


