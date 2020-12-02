import java.util.*;

class meetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        //first sort the array of times by the ones starting earliest
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //now create a minheap which will have meetings ending the earliest first
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        //traverse through the sorted intervals array and add to the heap one by one
        for(int i = 0; i < intervals.length; i++){
            if(!minHeap.isEmpty()){
                int[] temp = minHeap.poll();
                //next meeting starts after the current meeting
                if(intervals[i][0] >= temp[1]){
                    temp[1] = intervals[i][1];
                } else{
                    minHeap.add(intervals[i]);
                }
                //add the removed node back into the minheap
                minHeap.add(temp);
            } else{
                minHeap.add(intervals[i]);
            }
        }
        return minHeap.size();
    }
}