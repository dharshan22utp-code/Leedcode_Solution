import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        // 1. Sort the array to easily handle duplicates and use two pointers
        Arrays.sort(nums);
        int n = nums.length;
        
        // 2. Fix the first element (i)
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first position
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // 3. Fix the second element (j)
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second position
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                // 4. Use two pointers for the remaining two elements
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    // Use long to prevent integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for the third position
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // Skip duplicates for the fourth position
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        // Move both pointers inward
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Sum is too small, move left pointer rightward
                    } else {
                        right--; // Sum is too large, move right pointer leftward
                    }
                }
            }
        }
        
        return result;
    }
}
