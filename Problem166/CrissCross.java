/*
With a matrix like this:
   [ x1   x2   x3   x4  ]
   [ x5   x6   x7   x8  ]
   [ x9   x10  x11  x12 ]
   [ x13  x14  x15  x16 ]
The last element of each column (x13, x14, x15 & x16) will be the difference between
the sum of the first row and the other three elements of the column.
We can then determine the value of another element (x5) by isolating it in the two 
equations which determine the value of x16.
Therefore, we can iterate over all element other elements with values ranging from 0 to 9
and increment a counter only when the four rows and the two diagonals have the same sum.
By definition, the four columns will always be equal.
*/

public class CrissCross {
    public static int add(int n1, int n2, int n3, int n4) {
        return n1 + n2 + n3 + n4;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int sum, x5, x13, x14, x15, x16;
        int i = 0;
        for (int x1 = 0; x1 < 10; x1++) {
            for (int x2 = 0; x2 < 10; x2++) {
                for (int x3 = 0; x3 < 10; x3++) {
                    for (int x4 = 0; x4 < 10; x4++) {
                        sum = add(x1, x2, x3, x4);
                        for (int x9 = 0; x9 < 10; x9++) {
                            for (int x10 = 0; x10 < 10; x10++) {
                                for (int x11 = 0; x11 < 10; x11++) {
                                    for (int x12 = 0; x12 < 10; x12++) {
                                        if(sum == add(x9, x10, x11, x12)){
                                            for (int x6 = 0; x6 < 10; x6++) {
                                                x14 = x1 + x3 + x4 - x6 - x10;
                                                for (int x7 = 0; x7 < 10; x7++) {
                                                    x15 = x1 + x2 + x4 - x7 - x11;
                                                    for (int x8 = 0; x8 < 10; x8++) {
                                                        x5 = x2 + x3 - x8 - x12 - x9 + x14 + x15;
                                                        x13 = x2 + x3 + x4 - x5 - x9;
                                                        x16 = x1 + x2 + x3 - x8 - x12;
                                                        if (sum == add(x13, x14, x15, x16)
                                                            && sum == add(x1, x6, x11, x16)
                                                            && sum == add(x4, x7, x10, x13)
                                                            && x5 < 10 && x5 >= 0
                                                            && x13 < 10 && x13 >= 0
                                                            && x14 < 10 && x14 >= 0
                                                            && x15 < 10 && x15 >= 0
                                                            && x16 < 10 && x16 >= 0) {
                                                                i++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(i);
        long stopTime = System.nanoTime();
        System.out.println((double) (stopTime - startTime) / 1_000_000_000);
    }
}
