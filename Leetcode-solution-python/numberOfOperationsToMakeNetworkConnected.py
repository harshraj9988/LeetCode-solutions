from typing import List


class Solution:
    def findParent(self, u: int, parent: List[int]) -> int:
        if u == parent[u]:
            return u
        parent[u] = self.findParent(parent[u], parent)
        return parent[u]

    def createUnion(self, u: int, v: int, parent: List[int], rank: List[int]):
        par_u, par_v = self.findParent(u, parent), self.findParent(v, parent)
        if par_u == par_v:
            return
        rank_u, rank_v = rank[par_u], rank[par_v]
        if rank_u < rank_v:
            parent[par_u] = par_v
        elif rank_u > rank_v:
            parent[par_v] = par_u
        else:
            parent[par_v] = par_u
            rank[par_u] += 1

    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        parent, rank = [i for i in range(n)], [0] * n
        s = set()
        if len(connections) < n:
            return -1
        for u, v in connections:
            self.createUnion(u, v, parent, rank)
        for i in range(n):
            self.findParent(i, parent)
        for par in parent:
            s.add(par)
        return len(s) - 1
