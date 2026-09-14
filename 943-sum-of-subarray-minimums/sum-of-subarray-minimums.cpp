#include <vector>
#include <stack>

using namespace std;

class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        int n = arr.size();
        long long MOD = 1e9 + 7;
        
        // left[i] stores the distance to the previous smaller element
        vector<int> left(n);
        // right[i] stores the distance to the next smaller element
        vector<int> right(n); 
        
        stack<int> s;
        
        // Step 1: Find previous smaller elements
        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[s.top()] >= arr[i]) {
                s.pop();
            }
            left[i] = s.empty() ? i + 1 : i - s.top();
            s.push(i);
        }
        
        // Clear the stack to reuse it
        while (!s.empty()) {
            s.pop();
        }
        
        // Step 2: Find next smaller elements
        for (int i = n - 1; i >= 0; i--) {
            while (!s.empty() && arr[s.top()] > arr[i]) {
                s.pop();
            }
            right[i] = s.empty() ? n - i : s.top() - i;
            s.push(i);
        }
        
        // Step 3: Calculate the total sum
        long long totalSum = 0;
        for (int i = 0; i < n; i++) {
            long long count = (long long)left[i] * right[i];
            totalSum = (totalSum + count * arr[i]) % MOD;
        }
        
        return totalSum;
    }
};