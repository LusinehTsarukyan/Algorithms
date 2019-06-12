package week1;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgrammingAssignment1Test {
    @Test
    public void multiplyingTest() {
        double a = 1234;
        double b = 5678;
        int n = 4;
        double product = ProgrammingAssignment1.multiplying(a, b, n);

        assertEquals(7006652, product);

        double a1 = 12;
        double b1 = 34;
        int n1 = 2;
        double product1 = ProgrammingAssignment1.multiplying(a1, b1, n1);

        assertEquals(408, product1);

        double a2 = 1;
        double b2 = 2;
        int n2 = 1;
        double product2 = ProgrammingAssignment1.multiplying(a2, b2, n2);

        assertEquals(2, product2);
    }

}
