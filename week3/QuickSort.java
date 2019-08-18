package week3;

import week2.Inversions;

import java.io.IOException;
import java.util.*;

public class QuickSort {
    /**
     * 1.The file contains all of the integers between 1 and 10,000 (inclusive, with no repeats) in unsorted order. The integer in the i^{th}i
     * th
     * row of the file gives you the i^{th}i
     * th
     * entry of an input array.
     * <p>
     * Your task is to compute the total number of comparisons used to sort the given input file by QuickSort. As you know, the number of comparisons depends on which elements are chosen as pivots, so we'll ask you to explore three different pivoting rules.
     * <p>
     * You should not count comparisons one-by-one. Rather, when there is a recursive call on a subarray of length mm, you should simply add m-1m−1 to your running total of comparisons. (This is because the pivot element is compared to each of the other m-1m−1 elements in the subarray in this recursive call.)
     * <p>
     * WARNING: The Partition subroutine can be implemented in several different ways, and different implementations can give you differing numbers of comparisons. For this problem, you should implement the Partition subroutine exactly as it is described in the video lectures (otherwise you might get the wrong answer).
     * <p>
     * DIRECTIONS FOR THIS PROBLEM:
     * <p>
     * For the first part of the programming assignment, you should always use the first element of the array as the pivot element.
     * <p>
     * HOW TO GIVE US YOUR ANSWER:
     * <p>
     * Type the numeric answer in the space provided.
     * <p>
     * So if your answer is 1198233847, then just type 1198233847 in the space provided without any space / commas / other punctuation marks. You have 5 attempts to get the correct answer.
     * <p>
     * (We do not require you to submit your code, so feel free to use the programming language of your choice, just type the numeric answer in the following space.)
     * <p>
     * <p>
     * <p>
     * 2.GENERAL DIRECTIONS AND HOW TO GIVE US YOUR ANSWER:
     * <p>
     * See the first question.
     * <p>
     * DIRECTIONS FOR THIS PROBLEM:
     * <p>
     * Compute the number of comparisons (as in Problem 1), always using the final element of the given array as the pivot element. Again, be sure to implement the Partition subroutine exactly as it is described in the video lectures.
     * <p>
     * Recall from the lectures that, just before the main Partition subroutine, you should exchange the pivot element (i.e., the last element) with the first element.
     * <p>
     * <p>
     * <p>
     * 3.GENERAL DIRECTIONS AND HOW TO GIVE US YOUR ANSWER:
     * <p>
     * See the first question.
     * <p>
     * DIRECTIONS FOR THIS PROBLEM:
     * <p>
     * Compute the number of comparisons (as in Problem 1), using the "median-of-three" pivot rule. [The primary motivation behind this rule is to do a little bit of extra work to get much better performance on input arrays that are nearly sorted or reverse sorted.] In more detail, you should choose the pivot as follows. Consider the first, middle, and final elements of the given array. (If the array has odd length it should be clear what the "middle" element is; for an array with even length 2k2k, use the k^{th}k
     * th
     * element as the "middle" element. So for the array 4 5 6 7, the "middle" element is the second one ---- 5 and not 6!) Identify which of these three elements is the median (i.e., the one whose value is in between the other two), and use this as your pivot. As discussed in the first and second parts of this programming assignment, be sure to implement Partition exactly as described in the video lectures (including exchanging the pivot element with the first element just before the main Partition subroutine).
     * <p>
     * EXAMPLE: For the input array 8 2 4 5 7 1 you would consider the first (8), middle (4), and last (1) elements; since 4 is the median of the set {1,4,8}, you would use 4 as your pivot element.
     * <p>
     * SUBTLE POINT: A careful analysis would keep track of the comparisons made in identifying the median of the three candidate elements. You should NOT do this. That is, as in the previous two problems, you should simply add m-1m−1 to your running total of comparisons every time you recurse on a subarray with length mm.
     */

    static int count = 0;

    public static int quickSort(List<Integer> input, int pivotType) {
        if (input.size() > 1) {

            count += input.size() - 1;
            int pivotInd = partition(input, pivotType);

            quickSort(input.subList(0, pivotInd), pivotType);
            quickSort(input.subList(pivotInd + 1, input.size()), pivotType);
        }

        return count;
    }

    private static int choosePivot(List<Integer> input, int pivotType) {
        if (pivotType == 1) {
            return input.get(0);
        } else if (pivotType == 2) {
            return input.get(input.size() - 1);
        } else if (pivotType == 3) {
            ArrayList arr = new ArrayList();
            arr.add(input.get(0));
            arr.add(input.get(input.size() - 1));
            arr.add(input.get(input.size() - input.size() / 2 - 1));
            Collections.sort(arr);
            return (int) arr.get(1);
        } else {
            return -1;
        }
    }


    public static int partition(List<Integer> input, int pivotType) {
        int pivot = choosePivot(input, pivotType);
        int i = 1;

        if (pivot != input.get(0)) {
            Collections.swap(input, 0, input.indexOf(pivot));
            pivot = input.get(0);
        }
        for (int j = 1; j < input.size(); ++j) {
            if (input.get(j) < pivot) {
                Collections.swap(input, j, i);
                i++;
            }
        }
        Collections.swap(input, 0, i - 1);

        return i - 1;
    }

    public static void main(String args[]) throws IOException {
        try {
            ArrayList file = Inversions.reader("C:/Users/Lyulik/Desktop/coursera/QuickSort.txt");
            System.out.println((file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}