from typing import List
from functools import reduce


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        length = len(flowerbed)
        for i in range(length):
            if (flowerbed[i] == 1) or (i > 0 and flowerbed[i - 1] == 1) or (i < length - 1 and flowerbed[i + 1] == 1):
                continue
            else:
                n -= 1
                flowerbed[i] = 1
        return n <= 0


def getMaximumEvenSum(val):
    evens = list(filter(lambda z: z % 2 == 0 and z > 0, val))
    odds = list(filter(lambda z: z % 2 == 1, val))
    odds.sort()
    odds.reverse()
    curr_sum = int(reduce(lambda a, b: a + b, evens))
    for i in range(0, len(odds), 2):
        if i + 1 == len(odds):
            break
        if (curr_sum + odds[i] + odds[i + 1]) < curr_sum:
            break
        curr_sum += odds[i] + odds[i + 1]
    return curr_sum


arr = [6, 3, 4, -1, 9, 17]
print(getMaximumEvenSum(arr))
