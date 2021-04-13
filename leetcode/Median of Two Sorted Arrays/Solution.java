class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        int n = Math.max(nums1.length, nums2.length);
        int left = 0;
        int right = 0;
        while(left < nums1.length || right < nums2.length) {
            if(left == nums1.length) list.add(nums2[right++]);
            else if(right == nums2.length) list.add(nums1[left++]);
            else if(nums1[left] <= nums2[right]) list.add(nums1[left++]);
            else list.add(nums2[right++]);
    }
        int size = list.size();
        if(size == 1) return (double) list.get(0);
        if(size%2 == 1) return (double) list.get(size/2);
        double a = (double) list.get(size/2);
        double b = (double) list.get(size/2-1);
        return (a+b)/2;
    }
}
