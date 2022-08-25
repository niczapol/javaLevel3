package lesson6;

import org.junit.jupiter.api.*;

class ArrayTruncationTest {

    private ArrayTruncation arrayTruncation;
    private int[] initialArr;
    private int[] expectedArr;

    @BeforeEach
    void startUp() {
        arrayTruncation = new ArrayTruncation();
    }

    @Test
    void firstTruncationTest() {
        initialArr = new int[]{1, 7, 3, 4, 3, 1, 8, 4, 3, 8, 4, 9, 9, 0};
        expectedArr = new int[]{9, 9, 0};
        Assertions.assertArrayEquals(expectedArr, arrayTruncation.truncation(initialArr));
    }

    @Test
    void secondTruncationTest() {
        initialArr = new int[]{1, 7, 3, 4, 3, 1, 8, 4, 3, 8, 4};
        expectedArr = new int[]{};
        Assertions.assertArrayEquals(expectedArr, arrayTruncation.truncation(initialArr));
    }

    @Test
    void thirdTruncationTest() {
        initialArr = new int[]{4, 4, 4, 4, 4, 4, 4};
        expectedArr = new int[]{};
        Assertions.assertArrayEquals(expectedArr, arrayTruncation.truncation(initialArr));
    }

    @Test
    void arrTruncationExceptionTest() {
        initialArr = new int[]{1, 7, 3, 3, 1, 8, 3, 8, 9, 9, 0};
        Assertions.assertThrows(RuntimeException.class, () -> arrayTruncation.truncation(initialArr));
    }

    @Test
    void firstArrContainsTest() {
        initialArr = new int[] {1, 1, 1, 4, 4, 4, 1, 4, 1};
        Assertions.assertTrue(ArrayTruncation.isArrContainsNumbersOneAndFour(initialArr));
    }

    @Test
    void secondArrContainsTest() {
        initialArr = new int[] {1, 1, 1, 1, 1};
        Assertions.assertFalse(ArrayTruncation.isArrContainsNumbersOneAndFour(initialArr));
    }

    @Test
    void ThirdArrContainsTest() {
        initialArr = new int[] {1, 1, 1, 4, 4, 5, 4, 1, 4, 1};
        Assertions.assertFalse(ArrayTruncation.isArrContainsNumbersOneAndFour(initialArr));
    }

    @Test
    void fourthArrContainsTest() {
        initialArr = new int[] {4, 4, 4, 4, 4, 4};
        Assertions.assertFalse(ArrayTruncation.isArrContainsNumbersOneAndFour(initialArr));
    }
}