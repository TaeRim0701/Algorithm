import java.util.Arrays;

public class MergeSort {
    static int [] sortedArr;

    public static void main(String[] args) {
        int [] arr = {7,6,5,8,3,5,9,1};
        sortedArr = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // 나누는 함수
    public static void mergeSort(int[] arr, int start, int end) {
        if  (start >= end) return;
        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr,  int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                sortedArr[k] = arr[i];
                i++;
            } else {
                sortedArr[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            sortedArr[k] = arr[i];
            i++;
            k++;
        }

        while (j <= end) {
            sortedArr[k] = arr[j];
            j++;
            k++;
        }

        for (int l = start; l <= end; l++) arr[l] = sortedArr[l];
    }
}
