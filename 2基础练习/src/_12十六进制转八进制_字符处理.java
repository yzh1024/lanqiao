import java.util.Arrays;
import java.util.Scanner;

/*
资源限制
时间限制：1.0s   内存限制：512.0MB
问题描述
　　给定n个十六进制正整数，输出它们对应的八进制数。

输入格式
　　输入的第一行为一个正整数n （1<=n<=10）。
　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。

输出格式
　　输出n行，每行为输入对应的八进制正整数。

　　【注意】
　　输入的十六进制数不会有前导0，比如012A。
　　输出的八进制数也不能有前导0。

样例输入
　　2
　　39
　　123ABC

样例输出
　　71
　　4435274

　　【提示】
　　先将十六进制数转换成某进制数，再由某进制数转换成八进制。
 */
//使用比较传统的方法，自己写出各种进制的表，这里就要用到二进制和八进制的关系了
//这里大概说一下，如果想继续钻研的可以自己百度一下
//因为是这里最高是16进制每一个二进制的里面都对着一个16进制的数字
//因为正好2的4次方是16进制，2进制的四位数正好把每一个四进制的数都一一对应着
//取得时候直接按照相等的值取就可以了
//这道题就是先把16进制转换成二进制，再按照对应的方法取八进制对应的值
public class _12十六进制转八进制_字符处理 {
    public static void main(String[] args) {
        // 接受输入 n
        Scanner scanner = new Scanner(System.in);
        String input_n = scanner.nextLine();
        int n = Integer.parseInt(input_n);

        // 接受输入十六进制数的字符串
        String[] input_nums = new String[n];
        for (int i = 0; i < n; i++) {
            input_nums[i] = scanner.nextLine();
        }
        scanner.close();
        // 十六进制表
        String[] HEXs = {
                "0", "1", "2", "3", "4", "5", "6", "7",
                "8", "9", "A", "B", "C", "D", "E", "F"
        };
        // 二进制表
        String[] BINs = {
                "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"
        };
        // 八进制表
        String[] OCTs = {
                "0", "1", "2", "3", "4", "5", "6", "7"
        };
        // 十六进制表和二进制表，在所有成员上值一一对应
        // 十六进制表、二进制表和八进制表，在前八位成员上值一一对应
        for (int m = 0; m < n; m++) { // 遍历每个十六进制数字
            String hex = input_nums[m]; // 十六进制表示形式
            StringBuffer sbBin = new StringBuffer();
            StringBuffer sbOct = new StringBuffer();
            // 十六进制转二进制
            // 将十六进制数每一位转换成四位的二进制数字
            for (int i = 0; i < hex.length(); i++) { // 遍历每个十六进制位
                String c = Character.toString(hex.charAt(i));
                // 查询当前位字符在 HEXs中的下标
                int index = Arrays.binarySearch(HEXs, c);
                sbBin.append(BINs[index]);
            }
            // 在二进制数前面插入若干个"0"，使得二进数的位数为 3 的倍数
            while (sbBin.length() % 3 != 0) {
                sbBin.insert(0, "0");
            }
            int octLen = sbBin.length() / 3; // 计算目标八进制数的长度
            // 每次取三位二进制数，转换成对应的八进制
            for (int i = 0; i < octLen; i++) {
                String span = sbBin.substring(3 * i, 3 * i + 3);
                int index = Arrays.binarySearch(BINs, "0" + span);
                sbOct.append(OCTs[index]);
            }
            // 此时已经得到结果，需要去除前导 0
            while (sbOct.charAt(0) == '0') {
                sbOct.delete(0, 1);
            }
            System.out.println(sbOct.toString());
        }
    }
}
