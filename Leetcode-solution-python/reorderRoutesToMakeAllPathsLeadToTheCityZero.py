from typing import List, Set


class Solution:
    def dfs(self, node: int, bidirectional: List[List[int]], unidirectional: List[Set[int]],
            visited: List[bool]) -> int:
        count = 0

        for next_node in bidirectional[node]:
            if visited[next_node]:
                continue
            if node not in unidirectional[next_node]:
                count += 1
            visited[next_node] = True
            count += self.dfs(next_node, bidirectional, unidirectional, visited)

        return count

    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        bidirectional, unidirectional, visited = [list()] * n, [set()] * n, [False] * n
        visited[0] = True

        for a, b in connections:
            unidirectional[a].add(b)
            bidirectional[a].append(b)
            bidirectional[b].append(a)

        return self.dfs(0, bidirectional, unidirectional, visited)
