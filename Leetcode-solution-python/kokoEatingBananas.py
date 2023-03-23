import math
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        min_speed, max_speed = 1, max(piles)

        print(piles)

        def check(_speed: int) -> bool:
            count = 0
            for pile in piles:
                count += math.ceil(pile / _speed)
            return count <= h

        while min_speed < max_speed:
            speed = min_speed + (max_speed - min_speed) // 2
            if check(speed):
                max_speed = speed
            else:
                min_speed = speed + 1

        return min_speed
