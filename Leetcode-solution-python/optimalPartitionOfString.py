def index(c):
    return ord(c) - ord('a')


class Solution:
    def partitionString(self, s: str) -> int:
        n = len(s)
        freq = [False] * 26
        i, j, count = 0, 0, 1
        while j < n:
            if freq[index(s[j])]:
                while i < j:
                    freq[index(s[i])] = False
                    i += 1
                count += 1
            freq[index(s[j])] = True
            j += 1
        return count
