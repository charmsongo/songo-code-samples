package com.songo;

/**
 * @Author SonGo
 * @Create 2020/7/17 9:43
 * @Description
 */
public class SwitchTest {

    public static void main(String[] args) {
        System.out.println(switchMethod(3));
    }

    private static int switchMethod(int i) {
       switch(i){
           case 1:
           case 2:
           case 3:
               return 1;
           case 4:
               return 4;
           default:
               return 11;
       }

    }
}
