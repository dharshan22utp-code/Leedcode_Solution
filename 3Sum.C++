#include <vector>
#include <algorithm>

class Solution {
public:
    std::vector<std::vector<int>> threeSum(std::vector<int>& nums) {
        std::vector<std::vector<int>> result;
        int n = nums.size();
        
        // 1. Sort the array to easily handle duplicates and use two pointers
        std::sort(nums.begin(), nums.end());
        
        for (int i = 0; i < n - 2; ++i) {
            // Optimization: If the smallest number is greater than 0, 
            // the sum of 3 numbers can never be 0.
            if (nums[i] > 0) break;
            
            // Skip duplicate values for the first element i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // 2. Set up two pointers for the remaining part of the array
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a valid triplet
                    result.push_back({nums[i], nums[left], nums[right]});
                    
                    // Skip duplicate values for the second element (left)
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicate values for the third element (right)
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // Move both pointers inward after finding a match
                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    // Sum is too small, move the left pointer to increase the sum
                    left++;
                } 
                else {
                    // Sum is too big, move the right pointer to decrease the sum
                    right--;
                }
            }
        }
        
        return result;
    }
};
