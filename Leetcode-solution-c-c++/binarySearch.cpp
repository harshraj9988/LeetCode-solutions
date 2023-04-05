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
    int search(vector<int> &nums, int target)
    {
        int start = 0, end = nums.size() - 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target)
            {
                start = mid + 1;
            }
            else if (nums[mid] > target)
            {
                end = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
};