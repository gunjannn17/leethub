#include <string>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    int nextGreaterElement(int n) {
        string s = to_string(n);
        int len = s.length();
        
        // Step 1: Find the first digit from the right that is smaller than the one next to it
        int i = len - 2;
        while (i >= 0 && s[i] >= s[i + 1]) {
            i--;
        }
        
        // If no such digit is found, we can't make a larger number
        if (i < 0) return -1;
        
        // Step 2: Find the smallest digit to the right of 'i' that is greater than s[i]
        int j = len - 1;
        while (s[j] <= s[i]) {
            j--;
        }
        
        // Swap them
        swap(s[i], s[j]);
        
        // Step 3: Reverse the digits after index 'i' to get the smallest possible sequence
        reverse(s.begin() + i + 1, s.end());
        
        // Convert the string back to a number
        // We use stoll (string to long long) to prevent overflow during conversion
        long long result = stoll(s);
        
        // Check if the result fits in a standard 32-bit signed integer
        if (result > INT_MAX) {
            return -1;
        }
        
        return result;
    }
};
