import java.util.Scanner;

/*
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
　　注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。
样例输入
FFFF
样例输出
65535
 */
public class _11十六进制转十进制_字符处理 {
    public static void main(String[] args) {
        String n = new Scanner(System.in).nextLine();
        System.out.println( Long.valueOf(n, 16));
    }
}
