import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int [] arr = {7,6,5,8,3,5,9,1,6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int  n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i); // 힙에서 자식이 있는 노드들이 잘 배치 돼있는지 확인

        for (int i = n - 1; i > 0; i--) { // 확정된 값들을 배열 끝에 놓고 제외시킬 거기 때문에
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp; // 현재 root에 있는 값(가장 큰 값)을 배열 끝에 있는 값과 swap

            heapify(arr, i, 0); // 맨 끝 노드 제외하고 다시 heapify 진행
        }
    }

    public static void heapify(int[] arr, int n, int root) {
        int p = root; // 부모 노드
        int l = root * 2 + 1; // 왼쪽 자식 노드
        int r = root * 2 + 2; // 오른쪽 자식 노드

        if (l < n && arr[l] > arr[p]) p = l; // 왼쪽 자식 노드가 있는데 부모 노드보다 크면 부모노드 후보로 선정
        if (r < n && arr[r] > arr[p]) p = r; // 오른쪽 자식 노드가 있는데 부모 노드보다 크면 부모노드 후보로 선정

        if (root != p) { // 부모 노드 후보와 현재 부모 노드가 다르다면
            int temp = arr[p];
            arr[p] = arr[root];
            arr[root] = temp; // 현재 부모 노드와 부모 노드 후보를 sawp, 이 시점에서 p는 최종 부모 노드
            heapify(arr, n, p); // 바뀐 heap은 이상 없는지 확인
        }
    }
}
