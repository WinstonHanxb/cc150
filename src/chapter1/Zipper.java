package chapter1;

public class Zipper {
    // 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
    // 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
    // 给定一个string iniString为待压缩的串(长度小于等于10000)，
    // 保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
    public String zipString(String iniString) {
        // write code here
        int len = iniString.length();
        int newLen = 0;
        StringBuffer sb = new StringBuffer();
        int count;
        for (int i = 1; i < len; i++) {
            count = 1;
            if(newLen > len) return iniString;
            while(i<len && iniString.charAt(i) == iniString.charAt(i-1)){
                count++;
                i++;
            }
            sb.append(iniString.charAt(i-1));
            sb.append(count);
            newLen+=2;
        }
        return sb.toString();
    }
}
