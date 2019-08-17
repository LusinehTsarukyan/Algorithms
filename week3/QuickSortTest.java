package week3;

import org.junit.Test;
import week2.Inversions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {

    @Test
    public void partitionTest(){
        List<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(5);
        arr.add(8);
        arr.add(7);
        arr.add(6);
        arr.add(9);

        System.out.println(QuickSort.partition(arr, 1));
        System.out.println(QuickSort.partition(arr, 2));
        System.out.println(QuickSort.partition(arr, 3));
    }

    @Test
    public void partitionTestForFirstElement() {
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
    public void quickSortTest() {
        List<Integer> arr = new ArrayList();
        arr.add(19);
        arr.add(17);
        arr.add(4);
        arr.add(12);
        arr.add(18);
        arr.add(2);
        arr.add(7);
        arr.add(10);
        arr.add(8);
        arr.add(16);
        arr.add(9);
        arr.add(3);
        arr.add(5);
        arr.add(6);
        arr.add(15);
        arr.add(11);
        arr.add(20);
        arr.add(1);
        arr.add(13);
        arr.add(14);


//        int one = QuickSort.quickSort(arr, 1);
//        int two = QuickSort.quickSort(arr, 2);
//        int three = QuickSort.quickSort(arr, 3);

//        assertEquals(91, one);
//        assertEquals(78, two);
//        assertEquals(66, three);
//
//        List<Integer> arr1 = new ArrayList();
//        arr1.add(3);
//        arr1.add(1);
//        arr1.add(2);
//        arr1.add(6);
//        arr1.add(4);
//        arr1.add(5);
//        QuickSort.quickSort(arr1, 3);
//
//        List<Integer> arr2 = new ArrayList<>();
//        arr2.add(1);
//        arr2.add(2);
//        arr2.add(3);
//        arr2.add(4);
//        arr2.add(5);
//        arr2.add(6);
//
//        assertEquals(arr2, arr1);
//
//        List<Integer> arr3 = new ArrayList<>();
//        arr3.add(2148);
//        arr3.add(9058);
//        arr3.add(7742);
//        arr3.add(3153);
//        arr3.add(6324);
//        arr3.add(609);
//        arr3.add(7628);
//        arr3.add(5469);
//        arr3.add(7017);
//        arr3.add(504);
//        int count = QuickSort.quickSort(arr3, 1);
//
//        assertEquals(25, count);

        try {
            ArrayList file = Inversions.reader("C:/Users/Lyulik/Desktop/coursera/QuickSort.txt");
            System.out.println(file);
//            ArrayList test = file;
//            Collections.sort(test);
//            System.out.println(test);
            //QuickSort.quickSort(file, 1);
//            System.out.println(file);
//            System.out.println("NUMBER OF COMPARISONS first element:: " + QuickSort.quickSort(file, 1));
//            System.out.println("NUMBER OF COMPARISONS last element:: " + QuickSort.quickSort(file, 2));
            System.out.println("NUMBER OF COMPARISONS last element:: " + QuickSort.quickSort(file, 3));
//            assertEquals(file, test);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}