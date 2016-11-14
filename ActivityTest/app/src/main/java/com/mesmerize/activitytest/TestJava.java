package com.mesmerize.activitytest;

/**
 * Created by mesmerize on 16/7/25.
 */
public class TestJava {

    public static void main(String[] args) {

        String cha = "abcaadefghijklmnopqrstuvwxyz哈哈哈哈";
//
//        StringBuilder sb = new StringBuilder(cha);
//
//        System.out.println("sb.length() = " + sb.length());
////        String[] ss = s.split("");
////
//        Map<Character, Integer> map = new HashMap<>();
//
//        // 统计的算法基本如下
//        for (int i = 0; i < sb.length(); ++i) {
//            Character key = new Character(sb.charAt(i));
//            Integer count = map.get(key);
//            map.put(key, (count == null) ? 1 : count + 1);
//        }
//
//        int max = 1;
//        String value = "";
//        for (Character co : map.keySet()) {
//
//            for (int i = 0; i <= map.size(); i++) {
//                if (map.get(co) > max) {
//                    max = map.get(co);
//                    value = co.toString();
//                }
//            }
//        }
//
//        System.out.println("出现次数最多 = " + max + "字为::" + value);

        String lowerString = cha.toLowerCase();
//
        StringBuffer transformString = new StringBuffer();
//
        String[] splitString=lowerString.split(" ");
//
//        System.out.println("splitString.length = " + splitString.length);
//
        for(int i=0;i<splitString.length;i++){

            splitString[i]=splitString[i].substring(0,1).toUpperCase()+splitString[i].substring(1);

            transformString.append(splitString[i]);
            transformString.append(" ");
        }
        for(int i=0;i<splitString.length;i++) {

        }


        System.out.println("transformString = " + transformString.toString());
    }
}
