//public class Solution {
   // public List<List<Integer>> threeSum(int[] nums) {
        //Set<List<Integer>> res = new HashSet<>();
        //Arrays.sort(nums);
       // for (int i = 0; i < nums.length; i++) {
           // for (int j = i + 1; j < nums.length; j++) {
                //for (int k = j + 1; k < nums.length; k++) {
                   // if (nums[i] + nums[j] + nums[k] == 0) {
                       // List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        //res.add(tmp);
                 //   }
               // }
          //  }
      //  }
      //  return new ArrayList<>(res);

   // }
//}

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }

        return res;
    }
}