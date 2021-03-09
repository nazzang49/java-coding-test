import java.util.ArrayList;
import java.util.List;

public class Q5_MergeInterval {

    public static void main(String[] args) {
        Q5_MergeInterval a = new Q5_MergeInterval();
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);
        List<Interval> intervals = List.of(i1, i2, i3, i4);
        List<Interval> answer = a.merge(intervals);
        System.out.println(answer.size());
        System.out.println(answer);
    }

    public List<Interval> merge(List<Interval> intervals) {
        Interval criteria = intervals.get(0);
        List<Interval> answer = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval now = intervals.get(i);
            if (criteria.end >= now.start) {
                criteria.end = Math.max(criteria.end, now.end);
            } else {
                answer.add(criteria);
                criteria = now;
            }
        }

        // last
        if (!answer.contains(criteria)) {
            answer.add(criteria);
        }
        return answer;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}