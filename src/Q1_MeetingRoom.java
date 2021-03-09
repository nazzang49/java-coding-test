import java.util.Arrays;
import java.util.Comparator;

/**
 * 미팅룸 예약시간 정렬
 * @author 박진영
 * 2020-10-14
 */
class Period {

    int start;
    int end;

    Period() {
        this.start = 0;
        this.end = 0;
    }

    Period(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

public class Q1_MeetingRoom {

    public static void main(String[] args) {
        Q1_MeetingRoom meetingRoom = new Q1_MeetingRoom();

        /* 초기값 = 0 */
        Period interval1 = new Period(15, 20);
        Period interval2 = new Period(5, 10);
        Period interval3 = new Period(0, 30);

        Period[] intervals = {interval1, interval2, interval3};
        System.out.println(meetingRoom.solve(intervals));
    }

    public boolean solve(Period[] intervals) {
        if (intervals == null) {
            return false;
        }
        print(intervals);

        /* sort by start */
        Arrays.sort(intervals, new Comparator<Period>() {
            @Override
            public int compare(Period o1, Period o2) {
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

    private void print(Period[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            Period interval = intervals[i];
            System.out.println(interval.start + " - " + interval.end);
        }
    }
}
