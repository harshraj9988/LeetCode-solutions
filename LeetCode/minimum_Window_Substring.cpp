/**
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?
*/

#include <bits/stdc++.h>
using namespace std;
class Solution
{
private:
    bool check(vector<int> &v)
    {
        for (auto &i : v)
        {
            if (i > 0)
                return false;
        }
        return true;
    }

public:
    string minWindow(string s, string t)
    {
        int n = s.size();
        int m = t.size();
        vector<int> freq(58, 0);
        for (auto &ch : t)
        {
            freq[ch - 'A']++;
        }

        int mini = INT_MAX;
        int st = -1, et = 0;
        for (int i = 0, j = 0; j < n; j++)
        {
            freq[s[j] - 'A']--;
            if (check(freq))
            {
                if ((j - i + 1) < mini)
                {
                    st = i;
                    et = j;
                    mini = j - i + 1;
                }
                freq[s[i] - 'A']++;
                i++;
                freq[s[j] - 'A']++;
                j--;
            }
        }
        if (st == -1)
            return "";
        return s.substr(st, et - st + 1);
    }
};
