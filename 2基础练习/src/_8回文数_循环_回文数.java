/*
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
输出格式
　　按从小到大的顺序输出满足条件的四位十进制数。
 */
public class _8回文数_循环_回文数 {
    public static void main(String[] args) {
        int a1;
        int b1;
        int b2;
        int a2;
        for (int i = 1000; i < 10000; i++) {
            a1 = i/1000;
            b1 = i/100%10;
            b2 = i%100/10;
            a2 = i%10;
            if(a1==a2&&b1==b2)
                System.out.println(i);
        }
    }
}
