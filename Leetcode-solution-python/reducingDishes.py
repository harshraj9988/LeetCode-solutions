from typing import List


class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        max_satisfaction = curr_satisfaction = total_satisfaction = 0
        satisfaction.sort(reverse=True)

        for num in satisfaction:
            curr_satisfaction += num
            total_satisfaction += curr_satisfaction
            if total_satisfaction > max_satisfaction:
                max_satisfaction = total_satisfaction

        return max_satisfaction
