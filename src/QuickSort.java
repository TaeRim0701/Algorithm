import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        // start가 end보다 크거나 같으면 정렬할 게 1개 이하라는 뜻이니 종료
        if (start >= end) {
            return;
        }

        // part는 분할이 끝난 후 pivot의 위치
        int part = partition(arr, start, end);

        // 왼쪽 그룹 정렬 (처음부터 part 바로 앞까지)
        quickSort(arr, start, part - 1);
        // 오른쪽 그룹 정렬 (part부터 끝까지)
        quickSort(arr, part, end);
    }

    // 배열을 피벗 기준으로 나누고, 나뉜 경계 인덱스를 반환하는 함수
    public static int partition(int[] arr, int start, int end) {
        // 1. 피벗을 중간 값으로 설정
        int pivot = arr[(start + end) / 2];

        // 2. start와 end가 서로 교차할 때까지 반복
        while (start <= end) {
            // 왼쪽에서 피벗보다 크거나 같은 값을 찾을 때까지 전진
            while (arr[start] < pivot) start++;

            // 오른쪽에서 피벗보다 작거나 같은 값을 찾을 때까지 후진
            while (arr[end] > pivot) end--;

            // 3. 엇갈리지 않았다면 두 값을 교환 (큰 건 오른쪽, 작은 건 왼쪽으로)
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        // 4. 교차된 지점의 start가 오른쪽 그룹의 시작점이 됨
        return start;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}