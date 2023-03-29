from typing import List


class Solution:
    def dfs(self, node: int, adj: List[List[int]], visited: List[bool]) -> int:
        visited[node], count = True, 1
        for next_node in adj[node]:
            if visited[next_node]:
                continue
            count += self.dfs(next_node, adj, visited)
        return count

    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        adj, visited, postfix, ans = [[] for i in range(n)], [False for i in range(n)], 0, 0
        for a, b in edges:
            adj[a].append(b)
            adj[b].append(a)

        for node in range(n):
            if visited[node]:
                continue
            temp = self.dfs(node, adj, visited)
            ans += (postfix * temp)
            postfix = temp + postfix

        return ans
