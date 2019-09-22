package algorithms;

public class ArrayAlgorithms {

    // Quick Sort implementation
    public int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int part = partition(arr, start, end);
            quickSort(arr, start, part-1);
            quickSort(arr, part+1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = start;
        int i = pivot + 1;
        int j = end;
        while (i <= j) {
            if (arr[pivot] > arr[i]) {
                int swap = arr[pivot];
                arr[pivot] = arr[i];
                arr[i] = swap;
                pivot = i;
                i++;
            } else {
                int swap = arr[j];
                arr[j] = arr[i];
                arr[i] = swap;
                j--;
            }
        }
        return pivot;
    }

    public void heapSort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0;) {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            i--;
            heapify(arr, 0, i+1);
        }
    }

    private void buildMaxHeap(int[] arr) {
        for (int i = (int) (arr.length / 2) - 1; i >= 0; i--)
            heapify(arr, i, arr.length);
    }

    private void heapify(int[] arr, int root, int heapsize) {
        int left = 2 * root;
        int right = (2 * root) + 1;
        int max = root;
        if (left < heapsize && arr[left] > arr[max])
            max = left;
        if (right < heapsize && arr[right] > arr[max])
            max = right;
        if (max != root) {
            int swap = arr[root];
            arr[root] = arr[max];
            arr[max] = swap;
            heapify(arr, max, heapsize);
        }
    }

    /**
     * This implementation handles the case where the target is not in the
     * array by returning the index at which the value should be inserted.
     */
    public int binearyInsertSearch(int[] nums, int target) {
        return binaryInsertSearch(nums, target, 0, nums.length - 1);
    }

    public int binaryInsertSearch(int[] arr, int target, int start, int end) {
        int midpoint = (start + end) / 2;
        if (target < arr[midpoint] && start != end)
            return binaryInsertSearch(arr, target, start, midpoint);
        else if (target > arr[midpoint] && start != end)
            return binaryInsertSearch(arr, target, (start != midpoint) ? midpoint : midpoint + 1, end);
        else if (target <= arr[midpoint])
            return midpoint;
        else
            return midpoint + 1;
    }

    /**
     * This implementation handles the case where the target is not in the
     * array by returning -1.
     */
    public int binearySearch(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] arr, int target, int start, int end) {
        int midpoint = (start + end) / 2;
        if (target < arr[midpoint] && start != end)
            return binarySearch(arr, target, start, midpoint);
        else if (target > arr[midpoint] && start != end)
            return binarySearch(arr, target, (start != midpoint) ? midpoint : midpoint + 1, end);
        else if (target == arr[midpoint])
            return midpoint;
        else
            return -1;
    }
}
