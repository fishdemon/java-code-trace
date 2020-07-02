package com.fishdemon.jct.util.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 压缩文件
 * @author Anjin.Ma
 * @description ZipUtil
 * @date 2020/6/18
 */
public class ZipUtil {

    public static void main(String[] args) throws Exception {
        compress("D://gradle","D://gradle.zip");
//        unCompress("D://notification-system-master.zip","E://test");
    }

    /**
     * 压缩文件
     * @param srcFilePath 压缩源路径, 可以是文件，也可以是文件夹
     * @param destFilePath 压缩目的路径, 如 D://test.zip
     */
    public static void compress(String srcFilePath, String destFilePath) {
        // src file
        File src = new File(srcFilePath);

        if (!src.exists()) {
            throw new RuntimeException(srcFilePath + "不存在");
        }

        // zip file
        File zipFile = new File(destFilePath);

        try {
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            String baseDir = "";
            compressbyType(src, zos, baseDir);
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 按照原路径的类型就行压缩。文件路径直接把文件压缩，
     * @param src
     * @param zos
     * @param baseDir
     */
    private static void compressbyType(File src, ZipOutputStream zos,String baseDir) {
        if (!src.exists()) {
            return;
        }
        System.out.println("压缩路径" + baseDir + src.getName());
        //判断文件是否是文件，如果是文件调用compressFile方法,如果是路径，则调用compressDir方法；
        if (src.isFile()) {
            // src是文件
            compressFile(src, zos, baseDir);
        } else if (src.isDirectory()) {
            // src是文件夹
            compressDir(src, zos, baseDir);
        }
    }

    /**
     * 压缩文件
     */
    private static void compressFile(File file, ZipOutputStream zos,String baseDir) {
        if (!file.exists()) {
            return;
        }
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            // ZipEntry() 只能针对单个固定文件的压缩，也就是你压缩什么，就写清楚全路径
            ZipEntry entry = new ZipEntry(baseDir + file.getName());
            zos.putNextEntry(entry);
            int count;
            byte[] buf = new byte[1024];
            while ((count = bis.read(buf)) != -1) {
                zos.write(buf, 0, count);
            }
            bis.close();

        } catch (Exception e) {

        }
    }

    /**
     * 压缩文件夹
     */
    private static void compressDir(File dir, ZipOutputStream zos,String baseDir) {
        if (!dir.exists()) {
            return;
        }
        File[] files = dir.listFiles();
        // 空文件夹处理
        if(files.length == 0){
            try {
                zos.putNextEntry(new ZipEntry(baseDir + dir.getName() + File.separator));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (File file : files) {
            compressbyType(file, zos, baseDir + dir.getName() + File.separator);
        }
    }

    /**
     *
     * @param zipFilePath   zip 云路径
     * @param destFilePath  解压后的路径
     */
    public static void unCompress(String zipFilePath, String destFilePath) throws Exception {
        File zipFile = new File(zipFilePath);
        if (!zipFile.exists()) {
            throw new Exception(zipFile.getPath() + " 文件不存在");
        }

        // 开始解压
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry zipEntry = null;
        File file = null;
        while ((zipEntry = zis.getNextEntry()) != null) {
            if (!zipEntry.isDirectory()) {
                // 处理文件
                // zipEntry.getName 包含在zip中的路径加文件名称
                file = new File(destFilePath, zipEntry.getName());
                if (!file.exists()) {
                    new File(file.getParent()).mkdirs();
                }
                try (OutputStream out = new FileOutputStream(file);
                     BufferedOutputStream bos = new BufferedOutputStream(out)) {
                    int len = -1;
                    byte[] buf = new byte[1024];
                    while ((len = zis.read(buf)) != -1) {
                        out.write(buf, 0, len);
                    }
                }
            } else {
                // 处理文件夹
                String dirPath = destFilePath + "/" + zipEntry.getName();
                new File(dirPath).mkdirs();
            }
        }
    }

}
