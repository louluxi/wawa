package com.irandoo.xhep.base.util;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * 
 * @author ager
 *
 */
public class CommonsTools {
    
    
    

    /**
     * 
     * @param path
     * @param list
     * @param width
     * @param height
     * @return
     * @throws Exception
     * 方法废用，使用下面方法
     */
    @Deprecated
    public static String uploadOne(String path, List<FileUpload> list, int width, int height)
            throws Exception {
        List<String> oneList = upload(path, list, width, height);
        if (null != oneList && !oneList.isEmpty()) {
            return oneList.get(0);
        }
        return null;
    }
    
    /**
     * 单张图片
     * @param path
     * @param list
     * @param width
     * @param height
     * @return
     * @throws Exception
     */
    public static String uploadImg(String path, List<FileUpload> list, int width, int height)
            throws Exception {
        List<String> oneList = uploadImgs(path, list, width, height);
        if (null != oneList && !oneList.isEmpty()) {
            return oneList.get(0);
        }
        return null;
    }
    
    /**
     * 多张图片
     * @param path
     * @param list
     * @param width
     * @param height
     * @return
     * @throws Exception
     */
    public static List<String> uploadImgs(String path, List<FileUpload> list,int width, int height)
            throws Exception {
        return upload(path, list, width, height);
    }
    
    
    /**
     * 单个非图片
     * @param path
     * @param list
     * @return
     * @throws Exception
     */
    public static String uploadFile(String path, List<FileUpload> list)
            throws Exception {
        List<String> oneList = uploadFiles(path, list);
        if (null != oneList && !oneList.isEmpty()) {
            return oneList.get(0);
        }
        return null;
    }
    
    /**
     * 多个非图片
     * @param path
     * @param list
     * @return
     * @throws Exception
     */
    public static List<String> uploadFiles(String path, List<FileUpload> list)
            throws Exception {
        return upload(path, list, 0, 0);
    }


    /**
     * 上传图片 width和height非0
     * 
     * @param path
     * @param list
     * @param width
     * @param height
     * @return
     * @throws Exception
     */
    public static List<String> upload(String path, List<FileUpload> list, int width, int height)
            throws Exception {

        File[] uploadFiles = null;
        String[] fileNames = null;
        String filename = null;
        File uploadFile = null;
        File file = null;

        List<String> newList = new ArrayList<String>();

        for (FileUpload fileUpload : list) {

            uploadFiles = fileUpload.getUploadFiles();
            fileNames = fileUpload.getFileNames();
            for (int i = 0; i < uploadFiles.length; i++) {

                uploadFile = uploadFiles[i];

                // 文件大小为0，不考虑
                if (!uploadFile.exists()) {
                    continue;
                }

                // 如果文件夹不存在，创建文件夹,将文件保存到目录
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String ext = fileNames[i].substring(fileNames[i].indexOf("."), fileNames[i].length());// 获取文件扩展名

                ext = ext.toLowerCase();
                Date date=new Date();
                filename = date.getTime() + ext;

                file = new File(path + File.separator + filename);

                /**
                 * 如果是图片
                 */
                if (0 != width && 0 != height && isImage(uploadFile)) {
                    AverageImageScale.resizeFix(uploadFile, file, width, height);
                }
                /**
                 * 非图片
                 */
                else {

                    FileInputStream in = null;
                    FileOutputStream out = null;
                    try {
                        in = new FileInputStream(uploadFile);
                        out = new FileOutputStream(file);
                        IOUtils.copy(in, out);
                    }
                    finally {
                        IOUtils.closeQuietly(in);
                        IOUtils.closeQuietly(out);
                    }
                }
                newList.add(filename);
            }
        }

        return newList;

    }


    /**
     * 
     * @param file
     * @return
     */
    private static boolean isImage(File file) {

        Image src = null;
        try {
            src = javax.imageio.ImageIO.read(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (null == src) {
            return false;
        }
        return true;

    }
    /**
     * 删除path路径下的所有文件
     * @param path
     * @return
     */
    public static boolean delAllFile(String path)
    {
      boolean flag = false;
      File file = new File(path);
      if (!file.exists()) {
        return flag;
      }
      if (!file.isDirectory()) {
        return flag;
      }
      String[] tempList = file.list();
      File temp = null;
      for (int i = 0; i < tempList.length; i++) {
        if (path.endsWith(File.separator))
          temp = new File(path + tempList[i]);
        else {
          temp = new File(path + File.separator + tempList[i]);
        }
        if (temp.isFile()) {
          temp.delete();
        }
        if (temp.isDirectory()) {
          delAllFile(path + "/" + tempList[i]);
          delFolder(path + "/" + tempList[i]);
          flag = true;
        }
      }
      return flag;
    }
    
    /**
     * 删除文件夹下的所有文件
     * @param folderPath
     */
    public static void delFolder(String folderPath)
    {
      try
      {
        delAllFile(folderPath);
        String filePath = folderPath;
        filePath = filePath.toString();
        File myFilePath = new File(filePath);
        myFilePath.delete();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}
