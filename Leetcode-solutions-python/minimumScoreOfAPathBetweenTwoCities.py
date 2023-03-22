from typing import List


class Solution:
    def dfs(self, node: int, adj: dict[int, list], visited: List[bool]) -> int:
        visited[node] = True
        minimum = int(10 ** 9)
        for road in adj[node]:
            minimum = min(minimum, road[1])
            if visited[road[0]]:
                continue
            minimum = min(minimum, self.dfs(road[0], adj, visited))
        return minimum

    def minScore(self, n: int, roads: List[List[int]]) -> int:
        adj = dict()
        visited = [False] * n
        for road in roads:
            if road[0] - 1 not in adj:
                adj[road[0] - 1] = []
            if road[1] - 1 not in adj:
                adj[road[1] - 1] = []
            adj[road[0] - 1].append([road[1] - 1, road[2]])
            adj[road[1] - 1].append([road[0] - 1, road[2]])

        for node in range(n):
            if visited[node]:
                continue
            minimum = self.dfs(node, adj, visited)
            if visited[n - 1]:
                return minimum
        return -1
