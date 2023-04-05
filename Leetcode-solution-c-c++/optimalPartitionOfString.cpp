#include<bits/stdc++.h>

#define printArr(arr)                     \
   for (int i = 0; i < arr.size(); i++)   \
       cout << arr[i] << " ";           \
   cout << endl;
#define print2DArr(arr)                        \
   for (int i = 0; i < arr.size(); i++)        \
   {                                           \
       for (int j = 0; j < arr[0].size(); j++) \
       {                                       \
           cout << arr[i][j] << " ";         \
       }                                       \
       cout << endl;                           \
   }

using namespace std;

class Solution {
public:
    int partitionString(string s) {
        int count = 1;
        unordered_set<char> st;
        int n = s.size();
        for(int i=0; i<n; i++) {
            if(st.find(s[i]) == st.end()){
                st.insert(s[i]);
            }else{
                count++;
                st.clear();
                st.insert(s[i]);
            }
        }
        return count;
    }
};