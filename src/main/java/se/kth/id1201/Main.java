package se.kth.id1201;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
       //searchBenchmark();
       duplicateBenchmark();
    }

    public static int[] sortedArray(int n){
        Random r = new Random();
        int[] array = new int[n];
        int next = 0;
        for(int i = 0;i < n; i++){
            next += r.nextInt(10)+1;
            array[i]=next;
        }
        return array;
    }
    
    public static int[] unsortedArray(int n){
        Random r = new Random();
        int[] array = new int[n];
        for(int i = 0;i < n; i++){
            array[i] = r.nextInt(100000000);
        }
        return array;
    }

    public static boolean search_unsorted(int[] array, int key){
        for (int index = 0; index < array.length; index++){
            if(array[index]==key){
                return true;
            }
        }
        return false;
    }

    public static boolean search_sorted(int[] array, int key){
        for (int index = 0; index < array.length; index++){
            if(array[index]==key){
                return true;
            }
            if(array[index]>key){
                return false;
            }
        }
        return false;
    }

    public static boolean binary_search(int[] array, int key){
        int first=0;
        int last = array.length-1;

        while(true){
            int middle = (first+last)/2;
            if(array[middle]==key){
                return true;
            }

            if(array[middle]<key && middle<last){
                first = middle+1;
                middle = (first+last)/2;
                continue;
            }

            if(array[middle]>key && middle>first){
                last = middle-1;
                middle = (first+last)/2;
                continue;
            }

            return false;
        }
    }

    public static boolean duplicateSearchLinear(int[] array1, int[] array2){
        for(int i = 0; i < array1.length; i++){
            for(int j =0; j< array2.length; j++){
                if (array1[i]==array2[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean duplicateSearchBinary(int[] array1, int[] array2){
        for(int i=0; i<array1.length; i++){
            if(binary_search(array2, array1[i])){
                return true;
            }
        }
        return false;
    }

    public static boolean duplicateSearchBetter(int[] array1, int[] array2){
        int pointer_1 = 0; 
        int pointer_2 = 0;
        if(array1[0] > array2[array2.length-1]||array1[array1.length-1] < array2[0]){
                return false;
            }
        while(pointer_1<array1.length && pointer_2<array2.length){
            if(array1[pointer_1]<array2[pointer_2]){
                pointer_1++;
            }
            if(array1[pointer_1]>array2[pointer_2]){
                pointer_2++;
            }
            if(array1[pointer_1]==array2[pointer_2]){
                return true;
            }
        }
        return false;
    }
    

    public static void duplicateBenchmark(){
        int[] sortedArray_1;
        int[] sortedArray_2;
        long startTime;
        long endTime;

        int max_repetition = 10;
        long[] linearSortedRuntime = new long[max_repetition];
        long[] binarySortedRuntime = new long[max_repetition];
        long[] betterSortedRuntime = new long[max_repetition];

        long linearSortedSumtime = 0;
        long binarySortedSumtime = 0;
        long betterSortedSumtime = 0;

        int length = 10000;
        for (int i = 0; i < max_repetition; i++){
            sortedArray_1 = sortedArray(length);
            sortedArray_2 = sortedArray(length);

            startTime = System.nanoTime();
            duplicateSearchLinear(sortedArray_1, sortedArray_2);
            endTime = System.nanoTime();
            linearSortedRuntime[i] = endTime-startTime;

            startTime = System.nanoTime();
            duplicateSearchBinary(sortedArray_1, sortedArray_2);
            endTime = System.nanoTime();
            binarySortedRuntime[i] = endTime-startTime;

            startTime = System.nanoTime();
            duplicateSearchBetter(sortedArray_1, sortedArray_2);
            endTime = System.nanoTime();
            betterSortedRuntime[i] = endTime-startTime;
        }


        for (int i = 0; i < max_repetition; i++){
            linearSortedSumtime += linearSortedRuntime[i];
            binarySortedSumtime += binarySortedRuntime[i];
            betterSortedSumtime += binarySortedRuntime[i];
        }

        System.out.printf("n: %,d, linear: %.2f ns, binary: %.2f ns, better:%.2f ns\n",
                        length, 
                        (double)(linearSortedSumtime /max_repetition), 
                        (double)(binarySortedSumtime/max_repetition), 
                        (double)(betterSortedSumtime/max_repetition));
    }

    public static void searchBenchmark(){
        int[] unsortedArray;
        int[] sortedArray;
        long startTime;
        long endTime;

        int max_repetition = 10;
        long[] unsortedRunningtime = new long[max_repetition];
        long[] sortedRunningtime = new long[max_repetition];
        long[] binarySortRunningtime = new long[max_repetition];
        long unsortedSumTime = 0;
        long sortedSumTime = 0;
        long binarySortSumTime = 0;

        int length = 1000000;
        for (int i = 0; i < max_repetition; i++){
            unsortedArray = unsortedArray(length);
            startTime = System.nanoTime();
            search_unsorted(unsortedArray, 1000);
            endTime = System.nanoTime();
            unsortedRunningtime[i] = endTime-startTime;
            
            sortedArray = sortedArray(length);
            startTime = System.nanoTime();
            search_sorted(sortedArray, 1000);
            endTime = System.nanoTime();
            sortedRunningtime[i] = endTime-startTime;

            sortedArray = sortedArray(length);
            startTime = System.nanoTime();
            binary_search(sortedArray, 1000);
            endTime = System.nanoTime();
            binarySortRunningtime[i] = endTime-startTime;
        }

        for (int i = 0; i < max_repetition; i++){
            unsortedSumTime += unsortedRunningtime[i];
            sortedSumTime += sortedRunningtime[i];
            binarySortSumTime += binarySortRunningtime[i];
        }

        System.out.printf("n: %,d, linear unsorted: %.2f ns, linear sorted: %.2f ns, linear unsorted-sorted: %.2f ns\n",
                        length, 
                        (double)(unsortedSumTime/max_repetition), 
                        (double)(sortedSumTime/max_repetition), 
                        (double)(unsortedSumTime/max_repetition-sortedSumTime/max_repetition));
        System.out.printf("n: %,d, binary search: %.2f ns\n", 
                        length, 
                        (double)binarySortSumTime/max_repetition);
    }
}