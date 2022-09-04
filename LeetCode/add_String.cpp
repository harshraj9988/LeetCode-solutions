/**
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.



Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"


Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.

 *
 */
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string addStrings(string a, string b) {
        int n = a.size() - 1;
        int m = b.size() - 1;

        string ans = "";

        int carry = 0;
        while (n >= 0 && m >= 0)
        {
            int x = (((int)(a[n--] - '0')) + ((int)(b[m--] - '0'))) + carry;
            ans = (char)((int)'0'+(x % 10)) + ans;
            carry = x / 10;
        }

        while (n >= 0)
        {
            int x = ((int)(a[n--] - '0')) + carry;
            ans = (char)((int)'0'+(x % 10)) + ans;
            carry = x / 10;
        }

        while (m >= 0)
        {
            int x = ((int)(b[m--] - '0')) + carry;
            ans = (char)((int)'0'+(x % 10)) + ans;
            carry = x / 10;
        }

        if (carry > 0)
        {
            ans = (char)((int)'0'+(carry % 10)) + ans;
            carry/=10;
        }

        return ans;
    }
};
