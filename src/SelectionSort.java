public class SelectionSort {
    public static void main(String[] args) {
        int i, j, index, temp;
        int [] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        for (i = 0; i < arr.length; i++) {
            index = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
