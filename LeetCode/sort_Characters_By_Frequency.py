from collections import Counter


class Solution:
    def frequencySort(self, s: str) -> str:
        x = Counter(s)
        ans = ""
        for char, freq in x.most_common():
            ans = ans + char*freq
        return ans

