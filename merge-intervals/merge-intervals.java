class Solution {
    public int[][] merge(int[][] intervals) {
        ///Sort the intervals array using merge sort
        int[][] sorted_intervals = mergeSortIntervals(intervals, 0, intervals.length - 1);
        ArrayList<int[]> merges = new ArrayList<int[]>();
        ///sort the array
        int interval_start = sorted_intervals[0][0];
        int interval_end = sorted_intervals[0][1];
        for(int i = 1; i < sorted_intervals.length; i++){
            int current_start = sorted_intervals[i][0];
            int current_end = sorted_intervals[i][1];
            if(current_start <= interval_end){
                 if(current_end > interval_end){
                    interval_end = current_end;
                 } 
            } 
            else{
                    merges.add(new int[]{interval_start, interval_end});///save previous segment
                    interval_start = current_start;//start a new segment
                    interval_end = current_end;
            }
        }
        merges.add(new int[]{interval_start, interval_end});///save the last segment
        int [][] merges_arr = new int[merges.size()][];
        for(int i = 0; i < merges.size();i++){
            merges_arr[i] = merges.get(i);
        }
        return merges_arr;
    }

    public int[][] mergeSortIntervals(int[][] array, int start, int end){
        if(end == start) {
            return new int[][]{array[start]};
            }
        int mid  = (start + end) / 2;
        int[][] left = mergeSortIntervals(array, start, mid);
        int[][] right = mergeSortIntervals(array, mid + 1, end);
        return mergeArrays(left, right);
    }
    public int[][] mergeArrays(int[][]left, int[][] right){
        int i = 0, j = 0, k = 0;
        int[][] mergedArray = new int[left.length + right.length][];
        
        while(i < left.length && j < right.length){
            if(compareSmaller(left[i], right[j])){
                mergedArray[k++] = left[i++];
            }else{
                mergedArray[k++] = right[j++];
            }
        }
        while(i < left.length){
            mergedArray[k++] = left[i++];
        }
        while(j < right.length){
            mergedArray[k++] = right[j++];
        }         
        return mergedArray;
    }
    public boolean compareSmaller(int[] a, int[] b){
        if(a[0] < b[0]) return true;
        else if(a[0] > b[0]) return false;
        else { ///case of equality
            return a[1] <= b[1];
        }
    }
}