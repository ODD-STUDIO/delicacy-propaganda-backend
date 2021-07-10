package com.odd.delicacy.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Tanglinfeng
 * @date 2021/7/10 8:45
 */
public class FileUtil {

    /**
     * 文件上传方法
     *
     * @param file
     * @return 文件名
     */
    public static String uploadFile(MultipartFile file) {
        long timestamp = Instant.now().toEpochMilli();   // 时间戳重命名图片
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String path = sdf.format(new Date());

        // 获取文件后缀名
        String suffixName = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf('.'));
        String filePath = "http://img.afblog.love/data/images/" + path + "/";
        String fileName = timestamp + suffixName;
        File dest = new File(filePath + fileName);
        dest.mkdirs();
        try {
            file.transferTo(dest);
            return path + "/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
