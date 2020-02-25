package DivideAndConquerSortingAndSearchingAndRandomizedAlgorithms.week1;

import java.math.BigInteger;

import static java.lang.Integer.valueOf;

public class KaratsubaAlgorithm {
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
            gauss = multiplying(a + b, c + d, n / 2) - ac - bd;
        }
        return Math.pow(10, n) * ac + Math.pow(10, (n / 2)) * gauss + bd;
    }


    public static BigInteger karatsuba(BigInteger num1, BigInteger num2, int n) {
        BigInteger a;
        BigInteger b;
        BigInteger c;
        BigInteger d;
        BigInteger ac = new BigInteger("0");
        BigInteger bd = new BigInteger("0");
        BigInteger gauss = new BigInteger("0");
        BigInteger ten = new BigInteger("10");
        if (n == 1) {
            return num1.multiply(num2);
        }
        if (n > 1) {
            b = num1.remainder(ten.pow(n / 2));
            a = (num1.subtract(b)).divide(ten.pow(n / 2));
            d = num2.remainder(ten.pow(n / 2));
            c = (num2.subtract(d)).divide(ten.pow(n / 2));
            ac = karatsuba(a, c, n / 2);
            bd = karatsuba(b, d, n / 2);
            gauss = (karatsuba(a.add(b), c.add(d), n / 2).subtract(ac)).subtract(bd);
        }
        return ac.multiply(ten.pow(n)).add(gauss.multiply((ten.pow(n / 2)))).add(bd);
    }

    public static String recMult(String num1, String num2, int n) {
        String a;
        String b;
        String c;
        String d;
        String ac = "";
        String bd = "";
        String ad = "";
        String bc = "";
        String sum_ad_bc;
        if (n == 1) {
            return multiply(num1, num2);
        }
        if (n > 1) {
            a = num1.substring(0, n / 2);
            b = num1.substring(n / 2, n);
            c = num2.substring(0, n / 2);
            d = num2.substring(n / 2, n);
            ac = recMult(a, c, n / 2);
            bd = recMult(b, d, n / 2);
            ad = recMult(a, d, n / 2);
            bc = recMult(b, c, n / 2);
        }
        ac = pow(ac, n);
        sum_ad_bc = pow(add(ad, bc), n / 2);
        return add(add(ac, sum_ad_bc), bd);
    }

    private static String pow(String a, int n) {
        for (int i = 0; i < n; ++i) {
            a = new StringBuilder().append(a).append("0").toString();
        }
        return a;
    }

    static boolean isSmaller(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return true;
        }
        if (s2.length() < s1.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return true;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return false;
            }
        }
        return false;
    }

    public static String add(String s1, String s2) {
        if (isSmaller(s2, s1)) {
            String t = s1;
            s1 = s2;
            s2 = t;
        }

        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();
        int p = 0;
        String res = "";

        for (int i = 0; i < s1.length(); i++) {
            int sum = ((s1.charAt(i) - '0') + (s2.charAt(i) - '0') + p);
            res += (char) (sum % 10 + '0');

            p = sum / 10;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            int sum = ((s2.charAt(i) - '0') + p);
            res += (char) (sum % 10 + '0');
            p = sum / 10;
        }
        if (p > 0) {
            res += (char) (p + '0');
        }
        return new StringBuilder(res).reverse().toString();
    }

    static String subtract(String s1, String s2) {
        boolean negative = false;
        if (isSmaller(s1, s2)) {
            String t = s1;
            s1 = s2;
            s2 = t;
            negative = true;
        }

        String res = "";

        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();

        int p = 0;

        for (int i = 0; i < s2.length(); i++) {
            int sub = ((s1.charAt(i) - '0') - (s2.charAt(i) - '0') - p);

            if (sub < 0) {
                sub = sub + 10;
                p = 1;
            } else {
                p = 0;
            }

            res += (char) (sub + '0');
        }

        for (int i = s2.length(); i < s1.length(); i++) {
            int sub = ((s1.charAt(i) - '0') - p);

            if (sub < 0) {
                sub = sub + 10;
                p = 1;
            } else {
                p = 0;
            }

            res += (char) (sub + '0');
        }

        if (negative) {
            return new StringBuilder(res).append("-").reverse().toString();
        }
        return new StringBuilder(res).reverse().toString();
    }


     static String multiply(String s1, String s2) {
        return String.valueOf(valueOf(s1) * valueOf(s2));
    }
}

