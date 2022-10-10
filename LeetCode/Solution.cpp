#include <bits/stdc++.h>
using namespace std;

int solve(string &s, int n)
{
    if (n < 2)
        return 0;
    if (n == 2)
        return s[0] == s[1];
    int ans = 0;
    for (int i = 1; i < n - 1; i++)
    {
        if (s[i] == s[i - 1])
        {
            int a = i - 1, b = i;
            while (a >= 0 && b < n && s[a--] == s[b++])
                ans++;
        }
        else if(s[i-1]==s[i+1]){
            int a = i-1, b = i+1;
             while (a >= 0 && b < n && s[a--] == s[b++])
                ans++;
        }
    }
    return ans;
}

int main()
{
    string s;
    cin >> s;
    int n = s.size();
    cout << solve(s, n) << endl;
    return 0;
}