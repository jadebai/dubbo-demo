package com.baiyu.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author baiyu
 * @description: FileTest
 * @date: 2018/7/4
 */
public class FileTest {

    public static void main(String[] args) {
        String filePath = "D:\\文档";
        List<String> list = getPaths(filePath);
        for (String path : list){
            System.out.println("path===="+path);
        }
    }

    public static List<String> getPaths(String path){
        List<String> paths = new ArrayList<>();
        File file = new File(path);
        if (file.exists() && file.isDirectory()){
            File[] fileList = file.listFiles();
            for (File file1 : fileList) {
                paths.add(file1.getAbsolutePath());
                if (file1.isDirectory()){
                    paths.addAll(getPaths(file1.getAbsolutePath()));
                }
            }
        }
        return paths;
    }
}
