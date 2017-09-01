package com.zyd;

/**
 * Unit primary for simple App.
 */
public class AppTest {

    public static void main(String[] args){
        String str = null;
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < 100000; i ++){
            sb.append(i).append(";");
        }
        str = sb.toString();
        charAt(str);
        System.out.println("=====================");
        endsWith(str);

    }

    private static void endsWith(String str) {
        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 10000000 ; i ++) {
            if (str.startsWith("abc")) {
                System.out.println(21);
            }
            if (str.endsWith("abc")) {
                System.out.println(212);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(((end-start)) + "ms");
    }

    private static void charAt(String str) {
        long start = System.currentTimeMillis();
        int len = str.length();
        for(int i = 0 ; i < 10000000 ; i ++){
            if(str.charAt(0) == 'a' && str.charAt(1) == 'b' && str.charAt(2) == 'c'){
                System.out.println(1);
            }
            if(str.charAt(len-1) == 'a' && str.charAt(len-2) == 'b' && str.charAt(len-3) == 'c'){
                System.out.println(12);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(((end-start)) + "ms");
    }
}
