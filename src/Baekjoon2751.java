import java.util.Scanner;

public class Baekjoon2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        quickSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) System.out.println(arr[i]);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int part = partition(arr, start, end);

        quickSort(arr, start, part - 1);
        quickSort(arr, part, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];

        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;

            if (start <= end) {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }

        return start;
    }
}
