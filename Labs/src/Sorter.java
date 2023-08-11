import CITS2200.Sort;

public class Sorter implements Sort{
    private int count;
    public int getCount(){
        return count;
    }
    public void reset(){
        count = 0;
    }
    public void insertionSort(long[] arr){

        for(int i =1; i < arr.length; i++){
            long key = arr[i];
            int j = i -1 ;
            while(j>= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j = j -1;
            }
            arr[j+1] = key;

        }
    }

    public void mergeSort(long[] arr){
        mergeSorter(arr);


    }
    public void mergeSorter(long[] arr){
        int mid = arr.length/2;

        long[] left = new long[mid];
        long[] right = new long[arr.length - mid];
        for (int i =0; i < mid; i++){
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++){
            right[i - mid] = arr[i];

        }
        mergeSorter(left);
        mergeSorter(right);
        merge(arr, left, right);
    }
    public void merge(long[]arr, long[]left, long[]right){
        int i =0;
        int j = 0;
        int k= 0;
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                arr[k] = right[j];
                j++;
                k++;
            }else if(left[i]> right[j]){
                arr[k] = left[i];
                i++;
                k++;
            }
        }

        while(i < left.length){
            arr[k] = arr[i];
            k++;
            i++;
        }
        while(j < right.length){
            arr[k] = arr[j];
            k++;
            j++;
        }
    }

    @Override
    public void quickSort(long[] longs) {



    }
    public void quickSorter(long[]longs, int l, int h){
        int low = 0;
        int high = longs.length -1;
        int pivotIndex = partition(longs, low, high);
        quickSorter(longs, low, pivotIndex);
        quickSorter(longs, pivotIndex +1, high);
    }
    public int partition(long[] longs, int low, int high){
        long pivotValue = longs[high];
        int i = low -1 ;
        for (int j = low; j < high; j++){
            if(longs[j] < pivotValue){
                i++;
                long temp = longs[j];
                longs[j] = longs[i];
                longs[i] = temp;
            }
        }
        longs[i+1] = pivotValue;
        return i + 1;

    }
}


