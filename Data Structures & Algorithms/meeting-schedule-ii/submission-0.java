/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int size = intervals.size();
        int[] start = new int[size];
        int[] end = new int[size];

        for (int i = 0; i < size; i++) {
            Interval interval = intervals.get(i);
            start[i] = interval.start;
            end[i] = interval.end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int max = 0;

        int count = 0;
        int s = 0;
        int e = 0;
        while (e < size) {
            if (s < size && start[s] < end[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}
