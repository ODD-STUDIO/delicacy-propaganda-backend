package com.odd.delicacy.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tanglinfeng
 * @date 2021/7/11 10:49
 */
@Slf4j
public class FtpUtil {


    // ftp服务器地址
    public static final String host = "118.31.34.27";

    public static final Integer port = 21;

    public static final String username = "delicacy";

    public static final String password = "CREz64es5JWnWYY4";

    public static FTPClient ftpClient = null;

    /**
     * 连接FTP服务器
     *
     * @return
     */
    public static boolean loginFtp() throws IOException {
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");
        ftpClient.connect(host, port);
        return ftpClient.login(username, password);
    }

    /**
     * 上传文件
     *
     * @param fileName       上传到ftp的文件名
     * @return true if success
     */
    public static boolean uploadFile(String fileName, InputStream in) {
        try {
            loginFtp();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            // 开启被动模式
            ftpClient.enterLocalPassiveMode();
            boolean flag = ftpClient.storeFile(fileName, in);
            in.close();
            ftpClient.logout();
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.error(log, "上传失败", fileName);
            return false;
        }
    }

}
