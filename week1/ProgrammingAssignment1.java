package week1;

public class ProgrammingAssignment1 {
    /**
     * Programming Assignment #1
     * Quiz: Programming Assignment #1 1 question
     * In this programming assignment you will implement one or more of the integer multiplication algorithms described in lecture.
     * <p>
     * To get the most out of this assignment, your program should restrict itself to multiplying only pairs of single-digit numbers. You can implement the grade-school algorithm if you want, but to get the most out of the assignment you’ll want to implement recursive integer multiplication and/or Karatsuba’s algorithm.
     * <p>
     * So: what’s the product of the following two 64-digit numbers?
     * <p>
     * 3141592653589793238462643383279502884197169399375105820974944592
     * <p>
     * 2718281828459045235360287471352662497757247093699959574966967627
     * <p>
     * [TIP: before submitting, first test the correctness of your program on some small test cases of your own devising. Then post your best test cases to the discussion forums to help your fellow students!]
     * <p>
     * [Food for thought: the number of digits in each input number is a power of 2. Does this make your life easier? Does it depend on which algorithm you’re implementing?]
     * <p>
     * The numeric answer should be typed in the space below. So if your answer is 1198233847, then just type 1198233847 in the space provided without any space / commas / any other punctuation marks.
     * <p>
     * (We do not require you to submit your code, so feel free to use any programming language you want — just type the final numeric answer in the following space.)
     */

    public static double multiplying(double num1, double num2, int n) {
        double a = 0, b = 0, c = 0, d = 0, ac = 0, bd = 0, gauss = 0;
        if (n == 1) {
            return num1 * num2;
        }
        if (n > 1) {
            b = num1 % Math.pow(10, (n / 2));
            a = (num1 - b) / Math.pow(10, (n / 2));
            d = num2 % Math.pow(10, (n / 2));
            c = (num2 - d) / Math.pow(10, (n / 2));
            ac = multiplying(a, c, n / 2);
            bd = multiplying(b, d, n / 2);
            gauss = multiplying(a + b,c + d, n / 2) - ac - bd;
        }
        return Math.pow(10, n) * ac + Math.pow(10, (n / 2)) * gauss + bd;
    }

}

