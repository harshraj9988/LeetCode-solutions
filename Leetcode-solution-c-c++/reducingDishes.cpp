#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int maxSatisfaction(vector<int> &satisfaction)
    {
        int maxSatisfaction = 0, currSatisfaction = 0, totalSatisfaction = 0;
        sort(satisfaction.begin(), satisfaction.end(), greater<int>());
        for (int num : satisfaction)
        {
            currSatisfaction += num;
            totalSatisfaction += currSatisfaction;
            maxSatisfaction = max(maxSatisfaction, totalSatisfaction);
        }
        return maxSatisfaction;
    }
};