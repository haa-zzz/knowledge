package 复习;

import java.math.BigDecimal;
import java.math.BigInteger;

public class 大数BigInteger和BigDecimal {
    /*
    BigInteger :实现任意精度的整数运算
    BigDecimal:实现任意精度的浮点数运算
     */
    public static void main(String[] args) {
        BigInteger bi = BigInteger.valueOf(1);
        BigInteger bi1 = new BigInteger("1234");
        bi.add(bi1);                                        //   +
        bi.subtract(bi1);                                   //   -
        bi.multiply(bi1);                                   //   *
        bi.divide(bi1);                                     //   /
        bi.mod(bi1);                                        //   %
        BigDecimal bd = new BigDecimal("1000.00");
        BigDecimal bd2 = new BigDecimal("21");
        BigDecimal bd3 = bd.divide(bd2, 5, BigDecimal.ROUND_HALF_UP);
        System.out.printf("" + bd3);

    }

}
