/**
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.



Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:

Input: board = [["X"]]
Output: [["X"]]


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */
#include <bits/stdc++.h>
using namespace std;

class Solution
{

private:
    void bfs(vector<vector<char>> &board, vector<vector<int>> &visited, int m, int n, int i, int j, vector<int> &del)
    {
        queue<pair<int, int>> q;
        q.push(make_pair(i, j));
        visited[i][j] = 1;
        while (!q.empty())
        {
            int size = q.size();
            while (size--)
            {
                int x = q.front().first;
                int y = q.front().second;
                q.pop();

                for (int z = 0; z < 4; z++)
                {
                    int nx = x + del[z];
                    int ny = y + del[z + 1];
                    if (
                        nx >= 0 && nx < m &&
                        ny >= 0 && ny < n &&
                        (board[nx][ny] == 'O') &&
                        (visited[nx][ny] == 0))
                    {
                        visited[nx][ny] = 1;
                        q.push(make_pair(nx, ny));
                    }
                }
            }
        }
    }

public:
    void solve(vector<vector<char>> &board)
    {
        int m = board.size();
        int n = board[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        vector<int> dim = {-1, 0, 1, 0, -1};
        for(int i=0; i<n; i++){
            if(board[0][i]=='O' && visited[0][i]==0){
                bfs(board, visited, m, n, 0, i, dim);
            }
            if(board[m-1][i]=='O' && visited[m-1][i]==0){
                bfs(board, visited, m, n, m-1, i, dim);
            }
        }
        for(int i=1; i<m-1; i++){
            if(board[i][0]=='O' && visited[i][0]==0){
                bfs(board, visited, m, n, i, 0, dim);
            }
            if(board[i][n-1]=='O' && visited[i][n-1]==0){
                bfs(board, visited, m, n, i, n-1, dim);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j] = 'X';
                }
            }
        }
    }
};