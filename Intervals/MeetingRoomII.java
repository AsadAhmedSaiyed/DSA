import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomII {

    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (!pq.isEmpty() && pq.peek() <= intervals.get(i).start) {
                pq.remove();
            }
            pq.add(intervals.get(i).end);
        }
        return pq.size();
    }
}
