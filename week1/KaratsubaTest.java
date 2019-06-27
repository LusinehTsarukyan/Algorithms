package week1;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KaratsubaTest {
    @Test
    public void multiplyingTest() {
        double a = 1234;
        double b = 5678;
        int n = 4;
        double product = KaratsubaAlgorithm.multiplying(a, b, n);

        assertEquals(7006652, product);

        double a1 = 12;
        double b1 = 34;
        int n1 = 2;
        double product1 = KaratsubaAlgorithm.multiplying(a1, b1, n1);

        assertEquals(408, product1);

        double a2 = 1;
        double b2 = 2;
        int n2 = 1;
        double product2 = KaratsubaAlgorithm.multiplying(a2, b2, n2);

        assertEquals(2, product2);
    }

    @Test
    public void karatsubaTest(){
        BigInteger a = new BigInteger("1234");
        BigInteger b = new BigInteger("5678");
        int n = 4;
        BigInteger product = KaratsubaAlgorithm.karatsuba(a, b, n);

        assertEquals(a.multiply(b), product);

        BigInteger a1 = new BigInteger("77777777");
        BigInteger b1 = new BigInteger("88888888");
        int n1 = 8;
        BigInteger product1 = KaratsubaAlgorithm.karatsuba(a1, b1, n1);

        assertEquals(a1.multiply(b1), product1);

        BigInteger a3 = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger b3 = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
        int n3 = 64;
        BigInteger product3 = KaratsubaAlgorithm.karatsuba(a3, b3, n3);
        System.out.println(product3);

        assertEquals(a3.multiply(b3), product3);
    }

    @Test
    public void handmadeKaratsuba(){
        BigInteger a3 = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger b3 = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
        int n3 = 64;
        BigInteger product3 = KaratsubaAlgorithm.karatsuba(a3, b3, n3);

        String first = "3141592653589793238462643383279502884197169399375105820974944592";
        String second = "2718281828459045235360287471352662497757247093699959574966967627";
        int n = 64;
        String result = KaratsubaAlgorithm.recMult(first,second,n);

        assertEquals(product3.toString(),result);

        String a = "1234";
        String b = "5678";
        int n1 = 4;
        String product = KaratsubaAlgorithm.recMult(a, b, n1);

        assertEquals("7006652", product);

//        String a = "12";
//        String b = "34";
//        int n1 = 2;
//        String product = KaratsubaAlgorithm.recMult(a, b, n1);
//
//        assertEquals("408", product);
    }

    @Test
    public void add(){
        String a = "5112";
        String b = "22";

        String result = KaratsubaAlgorithm.add(a,b);

        assertEquals(String.valueOf(5112+22), result);
    }

    @Test
    public void sub(){
        String a = "501";
        String b = "11";

        String result = KaratsubaAlgorithm.subtract(a,b);

        assertEquals(String.valueOf(501 - 11), result);
    }

    @Test
    public void mult(){
        String a = "2";
        String b = "3";

        String result = KaratsubaAlgorithm.multiply(a,b);

        assertEquals(String.valueOf(6), result);
    }
}
