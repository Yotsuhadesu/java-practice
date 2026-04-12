package SelectionSort;

public class SelectionSorting {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            int minIndx = i;    // set the current index as the one with the minium value
            for(int j = i + 1; j < n; j++) {    // i as the left-side limiter
                if(arr[j] < arr[minIndx]) { // if the current value is lower than the stored lowest value
                    minIndx = j;    // store the index of the lower value
                }
            }
            int tmp = arr[i];   // store the element at index i of the array
            // interchange current value with the lowest value of the pass
            arr[i] = arr[minIndx];
            arr[minIndx] = tmp;
        }
        for(int num : arr)
            System.out.print(num + " ");
    }
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        selectionSort(arr); // 11 12 22 25 34 64 90
    }
}
