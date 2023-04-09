from typing import List


def dangerous(grid: List[List[int]], x: int, y: int, m: int, n: int):
    if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] == 0:
        return
    grid[x][y] = 0
    dx = (-1, 0, 1, 0, -1)
    for i in range(4):
        dangerous(grid, x+dx[i], y+dx[i+1], m, n)


class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        m, n, ans = len(grid), len(grid[0]), 0
        for i in range(m):
            if grid[i][0] == 1:
                dangerous(grid, i, 0, m, n)
            if grid[i][n-1] == 1:
                dangerous(grid, i, n-1, m, n)
        for i in range(n):
            if grid[0][i] == 1:
                dangerous(grid, 0, i, m, n)
            if grid[m-1][i] == 1:
                dangerous(grid, m-1, i, m, n)

        for i in range(m):
            for j in range(n):
                ans += grid[i][j]

        return ans
