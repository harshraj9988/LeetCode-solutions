/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/

#include <bits/stdc++.h>
using namespace std;
class Solution {
private:
    void rec(vector<vector<char>> &m, string &dig, string str, vector<string> &ans, int i, int &n){
        if(i==n){
            ans.push_back(str);
            return;
        }
        for(auto &ch: m[dig[i]-'2']){
            str[i] = ch;
            rec(m, dig, str, ans, i+1, n);
        }
    }

public:
    vector<string>  letterCombinations(string digits)
    {
        int n = digits.size();
        if(n==0) return {};
        vector<vector<char>> m(9);
        char ch = 'a';
        for(int i=0; i<8; i++){
            for(int j=0; j<3; j++){
                m[i].push_back(ch++);
            }
            if(i==5 || i==7){
                m[i].push_back(ch++);
            }
        }

        string str = "";
        for(int i=0; i<n; i++){
            str+='a';
        }
        
        vector<string> ans;

        rec(m, digits, str, ans, 0, n);

        return ans;
    }
};