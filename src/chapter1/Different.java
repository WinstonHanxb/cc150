package chapter1;

import java.util.Scanner;

public class Different {
    public boolean checkDifferent(String iniString) {
        if(iniString.length()>256) return false;
        for(int i=0;i<iniString.length();i++){
            for (int j = i+1; j < iniString.length(); j++) {
                if(iniString.charAt(i)==iniString.charAt(j)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Different df = new Different();
        while(sc.hasNext()) System.out.println(df.checkDifferent(sc.next()));
    }
}