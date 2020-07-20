
import java.util.Arrays;
import java.util.Scanner;

public class Main {
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

       /* Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] shiliu = new String[n];
        //输入数据
        for (int i = 0; i < n; i++) {
            shiliu[i] = sc.next();
        }*/
        //逐一将十六进制转换为十进制，再将十进制转换为八进制
//        for (int i = 0; i < n; i++) {
//            Long aLong = Long.valueOf(shiliu[i], 16);
//            String s = Long.toOctalString(aLong);
//            System.out.println(s);
//        }


}
