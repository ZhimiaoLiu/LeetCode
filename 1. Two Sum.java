class Solution {
    //Use Map to save time for space
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        //Literate thorugh the array, store each value in map
        for (int i = 0; i < nums.length; i++) {
            //If find the value(As Key in Map) == (target - current) value in the map, we return the index
            // of current and found value(As value in Map)
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{numMap.get(target - nums[i]), i};
            }
            numMap.put(nums[i], i);

        }
        return result;
    }
}