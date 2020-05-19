package com.fishdemon.jct.ftp;

/**
 *
 */
public class FtpClientMain {

    public static void main(String[] args) {
        FtpClientService ftp = new FtpClientService();
        //ftp.uploadFile("ftpFile/data", "123.docx", "E://123.docx");
        //ftp.downloadFile("ftpFile/data", "123.docx", "F://");
        ftp.deleteFile("ftpFile/data", "123.docx");
        System.out.println("ok");
    }

}
