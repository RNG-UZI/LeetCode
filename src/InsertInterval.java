class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<Interval>();
        int i = 0;
        int n = intervals.size();
        int nStart = newInterval.start;
        int nEnd = newInterval.end;
        while(i < n && intervals.get(i).end < newInterval.start) {
        	res.add(intervals.get(i));//find all the intervals before new
        	i++;
        }
        if(i == n) {//if all the intervals are before new, add to the last pos
        	res.add(newInterval);
        	return res;
        }
        nStart = Math.min(newInterval.start, intervals.get(i).start);//find the first overlap interval's start
        while(i < n && intervals.get(i).start <= newInterval.end) {//find the first overlap interval's end
        	nEnd = Math.max(newInterval.end, intervals.get(i).end);
        	i++;
        }
        res.add(new Interval(nStart, nEnd));
        while(i < n) {//add all the non-overlapped intervals left
        	res.add(intervals.get(i++));
        }
        return res;
    }
}