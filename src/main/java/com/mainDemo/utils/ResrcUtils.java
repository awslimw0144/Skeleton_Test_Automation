package com.mainDemo.utils;

public class ResrcUtils {
    public static String getFilePath(Class className, String fileName){
        return className.getResource("/"+fileName).getPath();
    }
}
