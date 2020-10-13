import java.util.Arrays;
import java.util.Comparator;

/**
 * 미팅룸 예약시간 정렬
 * @author 박진영
 */
class Interval {

    int start;
    int end;

    Interval() {
        this.start = 0;
        this.end = 0;
    }

    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

public class Q1_MeetingRoom {

    public static void main(String[] args) {
        Q1_MeetingRoom meetingRoom = new Q1_MeetingRoom();

        /* 초기값 = 0 */
        Interval interval1 = new Interval(15, 20);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(0, 30);

        Interval[] intervals = {interval1, interval2, interval3};
        System.out.println(meetingRoom.solve(intervals));
    }

    public boolean solve(Interval[] intervals) {
        if (intervals == null) {
            return false;
        }
        print(intervals);

        /* sort by start */
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                // 오름차순
                return o1.start - o2.start;
            }
        });

        print(intervals);

        /* compare previous end to current start */
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }

    private void print(Interval[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = intervals[i];
            System.out.println(interval.start + " - " + interval.end);
        }
    }
}
