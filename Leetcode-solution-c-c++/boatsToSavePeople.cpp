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
    int numRescueBoats(vector<int> &people, int limit)
    {
        sort(people.begin(), people.end());
        int i = 0, j = people.size() - 1;
        int count = 0;
        while (i <= j)
        {

            if (people[j] + people[i] <= limit)
            {
                i++;
            }
            count++;
            j--;
        }
        return count;
    }
};

int main()
{
    vector<int> people = {3, 2, 3, 2, 2};
    int limit = 6;
    cout << Solution().numRescueBoats(people, limit) << endl;
}