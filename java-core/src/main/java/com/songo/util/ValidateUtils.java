package com.songo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author SonGo
 * @Create 2020/7/23 10:50
 * @Description
 */
public class ValidateUtils {

    static final String[] strs = {"111","12"};

    public static boolean isMobileNumber(String nationalCode, String mobileNumber) {
        boolean isMobileNumber = false;
        for (MobileRegularExp regularExp : MobileRegularExp.values()) {
            Pattern pattern = Pattern.compile(regularExp.getRegularExp());
            Matcher matcher = pattern.matcher(new StringBuilder().append(nationalCode).append(mobileNumber).toString());
            if (matcher.matches()) {
                isMobileNumber = true;
                // 枚举中把最常用的国际区号拍在前面可以减少校验开销
                break;
            }
        }
        //
        //for (String str : strs) {
        //    System.out.println(str);
        //}
        return isMobileNumber;
    }

    public static void main(String[] args) {
        System.out.println(isMobileNumber("+86", "15652433359"));
    }

}
