#include <bits/stdc++.h>
using namespace std;

class Solution
{
private:
    int recursion(vector<int> &days, vector<int> &costs, int day, int end)
    {
        if (day >= end)
        {
            return 0;
        }
        int oneDayPass = costs[0] + recursion(days, costs, day + 1, end);
        int sevenDaysPass = costs[1] + recursion(days, costs, lower_bound(days.begin(), days.end(), days[day] + 7) - days.begin(), end);
        int thirtyDaysPass = costs[2] + recursion(days, costs, lower_bound(days.begin(), days.end(), days[day] + 30) - days.begin(), end);
        return min(oneDayPass, min(sevenDaysPass, thirtyDaysPass));
    }

    int memoization(vector<int> &days, vector<int> &costs, int day, int end, vector<int> &dp)
    {
        if (day >= end)
        {
            return 0;
        }
        if (dp[day] != -1)
        {
            return dp[day];
        }

        int oneDayPass = costs[0] + memoization(days, costs, day + 1, end, dp);
        int sevenDaysPass = costs[1] + memoization(days, costs, lower_bound(days.begin(), days.end(), days[day] + 7) - days.begin(), end, dp);
        int thirtyDaysPass = costs[2] + memoization(days, costs, lower_bound(days.begin(), days.end(), days[day] + 30) - days.begin(), end, dp);
        return dp[day] = min(oneDayPass, min(sevenDaysPass, thirtyDaysPass));
    }

public:
    int mincostTickets(vector<int> &days, vector<int> &costs)
    {
        vector<int> dp(days.size()+1, -1);
        return memoization(days, costs, 0, days.size(), dp);
    }
};
