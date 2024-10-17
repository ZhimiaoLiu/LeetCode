/**
 * @param  {int} a
 * @param {int} b
 * @param {int} c
 **/
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        //Stroe the most frequent element of a, b, c
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>((x, y) ->
                (y.count - x.count));
        // if a = 3,b = 1, c = 0 then
        //      3, 'a'
        //     /     \
        //   1, 'b'  0,'c'
        if (a > 0) {
            maxHeap.add(new Pair(a, 'a'));
        }

        if (b > 0) {
            maxHeap.add(new Pair(b, 'b'));
        }

        if (c > 0) {
            maxHeap.add(new Pair(c, 'c'));
        }
        //create string builder to append each string
        StringBuilder ans = new StringBuilder();
        //literate the whole heap if possible
        while (!maxHeap.isEmpty()) {
            //we pick the most frequent element for each literation,
            Pair temp = maxHeap.poll();
            int count = temp.count;
            Character cr = temp.character;
            //when we append the most frequent element for twice, try to append a second most frequent element
            //check if had two most frequent element and if we append the most frequent element twice
            if (ans.length() >= 2 && ans.charAt(ans.length() - 1) == cr && ans.charAt(ans.length() - 2) == cr) {
                // if there is not a second most frequent element, then end the loop
                if (maxHeap.isEmpty()) {
                    break;
                }
                // append the a second most frequent element
                Pair temp1 = maxHeap.poll();
                ans.append(temp1.character);
                // if a second most frequent element can be used, the update the heap
                if (temp1.count - 1 >0) {
                    maxHeap.add(new Pair(temp1.count-1, temp1.character));
                }
            }
            //append the most frequent element
            else {
                ans.append(cr);
                count--;
            }
            //update the most frequent element
            if (count > 0) {
                maxHeap.add(new Pair(count, cr));
            }
        }
        return ans.toString();
    }
    //help class
    class Pair {

        int count;
        char character;

        Pair(int count, char character) {
            this.count = count;
            this.character = character;
        }
    }
}