package week2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inversions {
    /**
     * This file contains all of the 100,000 integers between 1 and 100,000 (inclusive) in some order, with no integer repeated.
     * <p>
     * Your task is to compute the number of inversions in the file given, where the i^{th}i
     * th
     * row of the file indicates the i^{th}i
     * th
     * entry of an array.
     * <p>
     * Because of the large size of this array, you should implement the fast divide-and-conquer algorithm covered in the video lectures.
     * <p>
     * The numeric answer for the given input file should be typed in the space below.
     * <p>
     * So if your answer is 1198233847, then just type 1198233847 in the space provided without any space / commas / any other punctuation marks. You can make up to 5 attempts, and we'll use the best one for grading.
     * <p>
     * (We do not require you to submit your code, so feel free to use any programming language you want --- just type the final numeric answer in the following space.)
     * <p>
     * [TIP: before submitting, first test the correctness of your program on some small test files or your own devising. Then post your best test cases to the discussion forums to help your fellow students!]
     */

    public static ArrayList<Integer> reader() throws IOException {
        List<Integer> array = new ArrayList<Integer>();
        try (Scanner sc = new Scanner(new File("C:/Users/Lyulik/Desktop/coursera/nums.txt"))) {
            while (sc.hasNext()) {
                int i = sc.nextInt();
                array.add(i);
            }
        }
        //System.out.println(array);
        return (ArrayList<Integer>) array;
    }

    public static long invWrapper(List arrayList){
         ArrayList<Integer> output = new ArrayList<>(arrayList.size());
         return inversions(arrayList,output,arrayList.size());
    }

    public static long inversions(List arrayList,List output, int length) { // sort and count
        long first = 0;
        long second = 0;
        long split = 0;

        if (length == 1) {
            return 0;
        } else {
            int left, right, mid;
            left = 0;
            right = length - 1;
            mid = (left + right) / 2;


            first = inversions(arrayList.subList(left, mid), output, length / 2);
            second = inversions(arrayList.subList(mid + 1, right), output, length / 2);
            split = countSplitInv(arrayList, length, output);
        }

        return first + second + split;
    }

    private static long countSplitInv(List<Integer> arrayList, int length, List output) { //merge and count
        int left = 0;
        int right = length - 1;
        int mid = (left + right) / 2;
        int i = left;
        int j = mid + 1;
        long count = 0;

        while ((i <= mid - 1) && (j <= right)) {
            if (arrayList.get(i) < arrayList.get(j)) {
                output.add(arrayList.get(i));
                i++;
            } else if (arrayList.get(j) < arrayList.get(i)) {
                output.add(arrayList.get(j));
                j++;
                count = count + (length / 2 - 1 - i);
            }
        }

        while (i <= mid - 1) {
            output.add(arrayList.get(i));
            i++;
        }

        while (j <= right) {
            output.add(arrayList.get(j));
            j++;
        }

        for (int k = 0; k < arrayList.size(); k++) {
            arrayList.clear();
            arrayList.add((Integer) output.get(k));
        }

        return count;
    }

    public static void main(String args[]) throws IOException {
        long res = 0;
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(2);
        arr.add(4);
        arr.add(6);
        res = Inversions.invWrapper(arr);

        System.out.println(res);


//        try {
//            System.out.println(invWrapper(reader(), reader().size()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
