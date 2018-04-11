package chapter1;

import java.util.Scanner;

public class Replacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Replacement replacement = new Replacement();
        while(sc.hasNext()) System.out.println(replacement.replaceSpace(sc.nextLine(),0));
    }
    public String replaceSpace(String iniString, int length) {
        // write code here
        int space_count =0;
        for (int i = 0; i < iniString.length(); i++) {
            if(iniString.charAt(i)==32) space_count++;
        }
        if(space_count ==0) return iniString;
        char[] chars = new char[iniString.length()+2*space_count];
        int j = chars.length-1;
        for (int i = iniString.length()-1; i >=0; i--) {
            if(iniString.charAt(i) == 32){
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            }else chars[j--] = iniString.charAt(i);
        }
        return new String(chars);
    }
}
