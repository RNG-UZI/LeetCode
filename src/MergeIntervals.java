class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for(Interval itv: intervals){
        	if(itv.start < end){
        		end = Math.max(end, itv.end);
        	}else{
        		res.add(new Interval(start, end));
        		start = itv.start;
        		end = itv.end;
        	}
        }
        res.add(new Interval(start, end));
        return res;
    }
}