class Solution {
   public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new LinkedList<>();

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i-1][1] >= intervals[i][0]) {
                intervals[i][0] = Math.min(intervals[i - 1][0],intervals[i][0]);
                intervals[i][1] = Math.max(intervals[i - 1][1],intervals[i][1]);
            }
            else {
                list.add(intervals[i - 1]);
            }
        }
        list.add(intervals[intervals.length - 1]);
        int[][] arr= new int[list.size()][2];
        for(int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        return arr;
    }
}