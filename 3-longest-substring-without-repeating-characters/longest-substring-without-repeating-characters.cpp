#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // Vector to store the last seen index of each character (ASCII size 128)
        // Initialized to -1 because we haven't seen any characters yet
        vector<int> lastSeen(128, -1);
        
        int maxLength = 0;
        int left = 0; // Left boundary of our sliding window
        
        for (int right = 0; right < s.length(); ++right) {
            char currentChar = s[right];
            
            // If we've seen this character before and it's inside our current window
            if (lastSeen[currentChar] >= left) {
                // Move the left boundary right after the last occurrence of this character
                left = lastSeen[currentChar] + 1;
            }
            
            // Update the last seen index of the character
            lastSeen[currentChar] = right;
            
            // Calculate the window size and update the max length
            maxLength = max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
};
