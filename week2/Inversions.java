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

    public static ArrayList<Integer> reader(String path) throws IOException {
        List<Integer> array = new ArrayList<Integer>();
        try (Scanner sc = new Scanner(new File(path))) {
            while (sc.hasNext()) {
                int i = sc.nextInt();
                array.add(i);
            }
        }
        //System.out.println(array);
        return (ArrayList<Integer>) array;
    }

    public static long invWrapper(List input) {
        ArrayList<Integer> output = new ArrayList<>(input.size());
        return inversions(input, output);
    }

    public static long inversions(List input, List output) { // sort and count
        long first = 0;
        long second = 0;
        long split = 0;

        if (input.size() == 1) {
            return 0;
        } else {
            first = inversions(input.subList(0, input.size() / 2), output);
            second = inversions(input.subList(input.size() / 2, input.size()), output);
            split = countSplitInv(input, output);
        }

        return first + second + split;
    }

    private static long countSplitInv(List<Integer> input, List output) { //merge and count
        int i = 0;
        int j = input.size() / 2;
        long count = 0;

        while ((i <= input.size() / 2 - 1) && (j <= input.size() - 1)) {
            if (input.get(i) < input.get(j)) {
                output.add(input.get(i));
                i++;
            } else if (input.get(j) < input.get(i)) {
                output.add(input.get(j));
                j++;
                count = count + (input.size() / 2 - i);
            }
        }

        while (i <= input.size() / 2 - 1) {
            output.add(input.get(i));
            i++;
        }

        while (j <= input.size() - 1) {
            output.add(input.get(j));
            j++;
        }

        input.clear();
        for (int k = 0; k < output.size(); k++) {
            input.add((Integer) output.get(k));
        }
        output.clear();

        return count;
    }

    public static void main(String args[]) throws IOException {
        long res;
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(2);
        arr.add(4);
        arr.add(6);
        res = Inversions.invWrapper(arr);

        System.out.println(res);


        try {
            ArrayList file = reader("C:/Users/Lyulik/Desktop/coursera/nums.txt");
            System.out.println(invWrapper(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
