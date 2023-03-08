from typing import List


def minimumTime(self, time: List[int], totalTrips: int) -> int:
    ans, start, end = 0, 0, min(time) * totalTrips + 1

    def check(val: int) -> bool:
        rem_trips = int(totalTrips)
        for t in time:
            rem_trips -= (val // t)
        return rem_trips <= 0

    while start < end:
        mid = start + (end - start) // 2
        temp = check(mid)
        if temp:
            ans = int(mid)
            end = mid
        else:
            start = mid + 1
    return ans
