/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
 class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
    int peak = findPeakIndex(mountainArr);
    int leftSearch = binarySearch(mountainArr, target, 0, peak, true);
    if (leftSearch != -1) {
        return leftSearch;
    }
    return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
}

private int findPeakIndex(MountainArray mountainArr) {
    int left = 0, right = mountainArr.length() - 1;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}

private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean ascending) {
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midVal = mountainArr.get(mid);
        if (midVal == target) {
            return mid;
        }
        if (ascending) {
            if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } else {
            if (midVal > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    return -1;
}
}