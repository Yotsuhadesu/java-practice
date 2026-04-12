package SelectionSort;

public class SelectionSortingFromMemory {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            int minIndx = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndx])
                    minIndx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[minIndx];
            arr[minIndx] = tmp;
        }
        for(int num : arr)
            System.out.print(num + " ");
    }
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(arr);
    }
}
