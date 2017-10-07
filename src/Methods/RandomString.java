package Methods;

import java.util.Random;

public class RandomString {

    /**
     * 方法一
     *生成指定长度的字母数字组合字符串
     */
    public static String getAlphanumString(int length) {
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        String charStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int charLength = charStr.length();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charLength);
            buf.append(charStr.charAt(index));
        }
        return buf.toString();
    }

    /**
     * 方法二
     *生成指定长度的字母数字组合字符串
     */
    public static String getAlphanumString_(int length) {
        StringBuffer buf = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 字符串
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                buf.append((char) (choice + random.nextInt(26)));
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                // 数字
                buf.append(String.valueOf(random.nextInt(10)));
            }
        }
        return buf.toString();
    }
    /**
     * 方法三
     *生成指定长度的字母数字组合字符串
     */
    public static String _getAlphanumString(int length) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = Math.round(Math.random()) % 2 == 0 ? "char"
                    : "num";
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 字符串
                int choice = Math.round(Math.random()) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                buf.append((char) (choice + Math.round(Math.random() * 25)));
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                // 数字
                buf.append(String.valueOf(Math.round(Math.random() * 9)));
            }
        }
        return buf.toString();
    }

    /**
     * 方法四
     * 一段生成指定范围的随机整数代码
     * example：生成3-8之间的随机整数，直接调用 getSpecifyNum(3,8) 即返回大于等于3且小于等于8的整数。
     */
    public static int getSpecifyNum(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    public static void main(String[] args) {
        System.out.println(getAlphanumString(4));
        System.out.println(getAlphanumString_(5));
        System.out.println(_getAlphanumString(6));
        System.out.println(getSpecifyNum(3,8));
    }
}
