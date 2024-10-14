class Solution {
    /**
     * @param {List<List<Integer>> nums} //k lists
     * @return {int[]}
     */
    // Slove precedure :
    // 1. Find the largest number among first index element of each list O(k)
    // 2. Track the largest and samllest range
    // 3. Literade through all element in k lists one by one. We fist poll the samllest array and compare the distance
    // between the largest number we get from step 1 and record as samllest distance
    // 4. After we poll a element we add new one which after (i+1) the element just polled, then we compare and find the
    // largest element among k lists
    // 5. Repeat 3-5 until literate through all elements
    public int[] smallestRange(List<List<Integer>> nums) {
        //Create a heap to store the smaillest number amoung K lists *** (a, b) -> a[0] - b[0] compare by
        // first elemnt of each array***
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int curMax = Integer.MIN_VALUE;
        for (int i =0; i < nums.size(); i++) {
            pq.offer(new int[]{nums.get(i).get(0), 0, i});
            curMax = Math.max(curMax, nums.get(i).get(0));
        }
        int[] smallRange = new int[]{0, Integer.MAX_VALUE};
        while (true){
            // Get the minimum element from the heap
            int[] cur = pq.poll();
            int curValue = cur[0], curIndex = cur[1], listIndex = cur[2];
            // Update the smallest range if a better one is found
            if ((curMax - curValue) < (smallRange[1] - smallRange[0]) ||
                    (curMax - curValue) == (smallRange[1] - smallRange[0]) && curValue < smallRange[0]){
                smallRange[0] = curValue;
                smallRange[1] = curMax;
            }
            // Move to the next element in the same list
            if (curIndex < nums.get(listIndex).size()-1){
                pq.offer(new int[]{nums.get(listIndex).get(curIndex+ 1), curIndex+1, listIndex});
                curMax = Math.max(curMax, nums.get(listIndex).get(curIndex+ 1));

            }
            else {
                // Quit when reach the end of list
                break;
            }
        }
        return smallRange;
    }
}