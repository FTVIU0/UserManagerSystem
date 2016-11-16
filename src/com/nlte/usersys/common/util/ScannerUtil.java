package com.nlte.usersys.common.util;

import java.util.Scanner;

/**
 * Created by hp on 2016/11/16.
 */
public class ScannerUtil {
    private static Scanner in = null;

    public static Scanner getScanner() {
        if (in == null){
            return new Scanner(System.in);
        }
        return in;
    }
}
