#include <bits/stdc++.h>

#define printArr(arr)                    \
    for (int i = 0; i < arr.size(); i++) \
        cout << arr[i] << " ";           \
    cout << endl;
#define print2DArr(arr)                         \
    for (int i = 0; i < arr.size(); i++)        \
    {                                           \
        for (int j = 0; j < arr[0].size(); j++) \
        {                                       \
            cout << arr[i][j] << " ";           \
        }                                       \
        cout << endl;                           \
    }

using namespace std;

class Solution
{
public:
    vector<int> successfulPairs(vector<int> &spells, vector<int> &potions, long long success)
    {
        int n = spells.size();
        int m = potions.size();
        vector<int> ans(n);
        sort(potions.begin(), potions.end());
        for (int i = 0; i < n; i++)
        {
            long long reqPot = (success / (long long)spells[i]);
            if (success % (long long)spells[i])
                reqPot++;
            if(reqPot > potions[m-1]) continue;
            int totalPairs = potions.end() - lower_bound(potions.begin(), potions.end(), int(reqPot));
            ans[i] = totalPairs;
        }
        return ans;
    }
};
