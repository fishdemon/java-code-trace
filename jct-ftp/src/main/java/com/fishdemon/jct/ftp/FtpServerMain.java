package com.fishdemon.jct.ftp;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

import java.util.ArrayList;
import java.util.List;

/**
 * ftp server starter
 */
public class FtpServerMain {

    //创建匿名用户
    public static void createFtp1(){
        try {
            FtpServerFactory serverFactory = new FtpServerFactory();
            BaseUser user = new BaseUser();
            user.setName("anonymous");
            user.setHomeDirectory("E:\\ftpServer");
            serverFactory.getUserManager().save(user);
            FtpServer server = serverFactory.createServer();
            server.start();
            System.out.println("ftp搭建完成");
        }catch (FtpException e){
            e.printStackTrace();
        }
    }

    // 创建一个用户，用户名密码登陆
    public static void createFtp2(){
        try {
            FtpServerFactory serverFactory = new FtpServerFactory();
            BaseUser user = new BaseUser();
            user.setName("test");
            user.setPassword("123456");
            user.setHomeDirectory("E:\\ftpServer");
            serverFactory.getUserManager().save(user);
            FtpServer server = serverFactory.createServer();
            server.start();
            System.out.println("ftp搭建完成");
        }catch (
                FtpException e){
            e.printStackTrace();
        }
    }

    //增加用户可写权限
    public static void createFtp3(){
        try {
            FtpServerFactory serverFactory = new FtpServerFactory();
            BaseUser user = new BaseUser();
            user.setName("test");
            user.setPassword("123456");
            user.setHomeDirectory("E:\\ftpServer");
            List<Authority> authority = new ArrayList<Authority>();
            authority.add(new WritePermission());
//            //最大同时登录人数+最大同时登录ip
//            authority.add(new ConcurrentLoginPermission(2,3));
//            //最大下载速度+最大上传速度
//           authority.add(new TransferRatePermission(10,30));
            user.setAuthorities(authority);
            serverFactory.getUserManager().save(user);
            FtpServer server = serverFactory.createServer();
            server.start();
            System.out.println("ftp搭建完成");
        }catch (
                FtpException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 启动后访问 ftp://localhost (用web浏览器或文档浏览器都可以)
        createFtp3();
    }

}
