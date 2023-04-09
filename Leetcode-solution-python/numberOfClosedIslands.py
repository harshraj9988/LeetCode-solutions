from typing import List


def flood(grid: List[List[int]], x: int, y: int, m: int, n: int) -> bool:
    if x < 0 or x >= m or y < 0 or y >= n:
        return False
    if grid[x][y] == 1:
        return True
    grid[x][y] = 1
    dx = [-1, 0, 1, 0, -1]
    ans = True
    for i in range(4):
        nx, ny = x + dx[i], y + dx[i + 1]
        ans = flood(grid, nx, ny, m, n) and ans
    return ans


class Solution:

    def closedIsland(self, grid: List[List[int]]) -> int:
        ans, m, n = 0, len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0 and flood(grid, i, j, m, n):
                    ans += 1

        return ans


