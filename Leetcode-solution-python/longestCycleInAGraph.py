from typing import List


class Solution:

    def dfs(self, node: int, edges: List[int], vis: List[bool], depth: int, par: int) -> int:
        if node == -1:
            return -1
        if vis[node]:
            if node == par:
                return depth
            else:
                return -1
        vis[node] = True
        temp = self.dfs(edges[node], edges, vis, depth + 1, par)
        if temp == -1:
            vis[node] = False
        return temp

    def longestCycle(self, edges: List[int]) -> int:
        ans, n = -1, len(edges)
        vis = [False] * n
        for i in range(n):
            if vis[i] or edges[i] == -1:
                continue
            ans = max(ans, self.dfs(i, edges, vis, 0, i))
        return ans
