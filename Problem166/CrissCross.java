public class CrissCross {
    public static int add(int n1, int n2, int n3, int n4) {
        return n1 + n2 + n3 + n4;
    }

    public static void main(String[] args) {
        int i = 0;
        for (int x1 = 0; x1 < 10; x1++) {
            for (int x2 = 0; x2 < 10; x2++) {
                for (int x3 = 0; x3 < 10; x3++) {
                    for (int x5 = 0; x5 < 10; x5++) {
                        for (int x6 = 0; x6 < 10; x6++) {
                            for (int x7 = 0; x7 < 10; x7++) {
                                for (int x9 = 0; x9 < 10; x9++) {
                                    for (int x10 = 0; x10 < 10; x10++) {
                                        for (int x11 = 0; x11 < 10; x11++) {
                                            for (int x13 = 0; x13 < 10; x13++) {
                                                for (int x14 = 0; x14 < 10; x14++) {
                                                    for (int x15 = 0; x15 < 10; x15++) {
                                                        int x16 = x1 + x5 + x9 - x14 - x15;
                                                        int x12 = x1 + x5 + x13 - x10 - x11;
                                                        int x8 = x1 + x9 + x13 - x6 - x7;
                                                        int x4 = x5 + x9 + x13 - x2 - x3;
                                                        if (add(x1, x5, x9, x13) == add(x2, x6, x10, x14)
                                                            && add(x1, x5, x9, x13) == add(x3, x7, x11, x15)
                                                            && add(x1, x5, x9, x13) == add(x4, x8, x12, x16)
                                                            && add(x1, x5, x9, x13) == add(x1, x6, x11, x16)
                                                            && add(x1, x5, x9, x13) == add(x4, x7, x10, x13)
                                                            && x4 >= 0 && x4 < 10 && x8 >= 0 && x8 < 10
                                                            && x12 >= 0 && x12 < 10 && x16 >= 0 && x16 < 10) {
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
    }
}
