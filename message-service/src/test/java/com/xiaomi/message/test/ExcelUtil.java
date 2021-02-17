package com.xiaomi.message.test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ExcelUtil {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("资产负债表","利润表","现金流量表");
        List<String> paths = Arrays.asList("资产负债","利润","现金流量");
        String dest = "重庆";
        for (int index = 0; index < 3; index ++){
            String oriPath = "C:\\Users\\hekun1997\\Downloads\\"+ dest +"\\" + paths.get(index);
            File rootFile = new File(oriPath);
            File[] files = rootFile.listFiles();
            int i = 3;
            String rootPath = "C:\\Users\\hekun1997\\Downloads\\"+ dest +"\\" + paths.get(index)+"\\";

            for (File file : files){
                String path = rootPath + i + "月" + dest + names.get(index) + ".xls";
                System.out.println(path);
                file.renameTo(new File(path));
                i ++;
            }
        }
    }
}
