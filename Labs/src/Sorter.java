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
}


