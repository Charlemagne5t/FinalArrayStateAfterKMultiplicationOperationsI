import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparing((int[] a) -> a[1]));

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while (k > 0) {
            int[] cur = pq.poll();
            cur[0] *= multiplier;
            pq.offer(cur);
            k--;
        }
        while (!pq.isEmpty()) {
            nums[pq.peek()[1]] = pq.poll()[0];
        }

        return nums;
    }
}