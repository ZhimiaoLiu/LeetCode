/**
 * @param  {int[]} nums //0-indexed integer array
 * @param {int} k
 * @return {int[]}
 **/
class Solution {
    public long maxKelements(int[] nums, int k) {
        long result = 0;
        //Create a max-heap and store all the element of array in it
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Collections.reverseOrder()
        );
        for (int i : nums) {
            pq.add(i);
        }
        // 1. Store the current largest element
        // 2. Add the largest element to the score
        // 3. add the (current/3) back in the the heap
        for (int j=0;j<k;j++) {
            long cur = pq.peek();
            int temp = (int)Math.ceil(cur/3.0);
            result += pq.poll();
            pq.add(temp);
        }
        return result;
    }
}