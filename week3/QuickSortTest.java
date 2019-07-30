package week3;

import org.junit.Test;
import week2.Inversions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {

    @Test
    public void partitionTestForFirstElement(){
        List<Integer> arr = new ArrayList();
        arr.add(2);
        arr.add(1);
        QuickSort.partition(arr, 0);

        List<Integer> arr1 = new ArrayList();
        arr1.add(1);
        arr1.add(2);

        assertEquals(arr, arr1);


        List<Integer> arr3 = new ArrayList();
        arr3.add(3);
        arr3.add(1);
        arr3.add(2);
        QuickSort.partition(arr3, 0);


        assertEquals(java.util.Optional.ofNullable(arr3.get(2)), java.util.Optional.of(3));
    }

    @Test
    public void quickSortTest(){
        List<Integer> arr = new ArrayList();
        arr.add(2);
        arr.add(1);
        QuickSort.quickSort(arr, 2);

        List<Integer> arr0 = new ArrayList();
        arr0.add(1);
        arr0.add(2);

        assertEquals(arr0, arr);

        List<Integer> arr1 = new ArrayList();
        arr1.add(3);
        arr1.add(1);
        arr1.add(2);
        arr1.add(6);
        arr1.add(4);
        arr1.add(5);
        QuickSort.quickSort(arr1, 3);

        List<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        arr2.add(4);
        arr2.add(5);
        arr2.add(6);

        assertEquals(arr2, arr1);

        try {
            ArrayList file = Inversions.reader("C:/Users/Lyulik/Desktop/coursera/QuickSort.txt");
            System.out.println(file);
            ArrayList test = file;
            Collections.sort(test);
            System.out.println(test);
            QuickSort.quickSort(file, 1);
            System.out.println(file);
            System.out.println("NUMBER OF COMPARISONS first element:: " + QuickSort.quickSort(file, 1));
            System.out.println("NUMBER OF COMPARISONS last element:: " + QuickSort.quickSort(file, 2));
            System.out.println("NUMBER OF COMPARISONS last element:: " + QuickSort.quickSort(file, 3));
            assertEquals(file, test);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}