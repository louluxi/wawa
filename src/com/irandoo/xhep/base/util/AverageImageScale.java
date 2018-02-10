package com.irandoo.xhep.base.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import com.irandoo.xhep.base.util.ImageUtils.Position;


/**
 * 
 * @author ager
 *
 */
public class AverageImageScale {
    /**
     * 
     * @param srcFile
     * @param destFile
     * @param boxWidth
     * @param boxHeight
     * @throws IOException
     */
    public static void resizeFix(File srcFile, File destFile, int boxWidth,
            int boxHeight) throws IOException {
        BufferedImage srcImgBuff = ImageIO.read(srcFile);
        int width = srcImgBuff.getWidth();
        int height = srcImgBuff.getHeight();
        if (width <= boxWidth && height <= boxHeight) {
            FileUtils.copyFile(srcFile, destFile);
            return;
        }
        int zoomWidth;
        int zoomHeight;
//        if(1==i)
//        {
//            zoomWidth = boxWidth;
//            zoomHeight = Math.round((float) boxWidth * height / width);
//        }
//        else if(2==i)
//        {
//            zoomWidth = Math.round((float) boxHeight * width / height);
//            zoomHeight = boxHeight;
//        }
//        else
//        {
//            if ((float) width / height > (float) boxWidth / boxHeight) {
//                zoomWidth = boxWidth;
//                zoomHeight = Math.round((float) boxWidth * height / width);
//            } else {
//                zoomWidth = Math.round((float) boxHeight * width / height);
//                zoomHeight = boxHeight;
//            }
//        }
        if ((float) width / height > (float) boxWidth / boxHeight) {
            zoomWidth = boxWidth;
            zoomHeight = Math.round((float) boxWidth * height / width);
        } else {
            zoomWidth = Math.round((float) boxHeight * width / height);
            zoomHeight = boxHeight;
        }
        
        BufferedImage imgBuff = scaleImage(srcImgBuff, width, height,
                zoomWidth, zoomHeight);
        writeFile(imgBuff, destFile);
    }

    /**
     * 
     * @param srcFile
     * @param destFile
     * @param boxWidth
     * @param boxHeight
     * @param cutTop
     * @param cutLeft
     * @param cutWidth
     * @param catHeight
     * @throws IOException
     */
    public static void resizeFix(File srcFile, File destFile, int boxWidth,
            int boxHeight, int cutTop, int cutLeft, int cutWidth, int catHeight)
            throws IOException {
        BufferedImage srcImgBuff = ImageIO.read(srcFile);
        srcImgBuff = srcImgBuff.getSubimage(cutTop, cutLeft, cutWidth,
                catHeight);
        int width = srcImgBuff.getWidth();
        int height = srcImgBuff.getHeight();
        if (width <= boxWidth && height <= boxHeight) {
            writeFile(srcImgBuff, destFile);
            return;
        }
        int zoomWidth;
        int zoomHeight;
        if ((float) width / height > (float) boxWidth / boxHeight) {
            zoomWidth = boxWidth;
            zoomHeight = Math.round((float) boxWidth * height / width);
        } else {
            zoomWidth = Math.round((float) boxHeight * width / height);
            zoomHeight = boxHeight;
        }
        BufferedImage imgBuff = scaleImage(srcImgBuff, width, height,
                zoomWidth, zoomHeight);
        writeFile(imgBuff, destFile);
    }

    public static void writeFile(BufferedImage imgBuf, File destFile)
            throws IOException {
        File parent = destFile.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        ImageIO.write(imgBuf, "jpeg", destFile);
    }

    /**
     * 
     * @param srcFile
     * @param destFile
     * @param minWidth
     * @param minHeight
     * @param pos
     * @param offsetX
     * @param offsetY
     * @param text
     * @param color
     * @param size
     * @param alpha
     * @throws IOException
     */
    public static void imageMark(File srcFile, File destFile, int minWidth,
            int minHeight, int pos, int offsetX, int offsetY, String text,
            Color color, int size, int alpha) throws IOException {
        BufferedImage imgBuff = ImageIO.read(srcFile);
        int width = imgBuff.getWidth();
        int height = imgBuff.getHeight();
        if (width <= minWidth || height <= minHeight) {
            imgBuff = null;
            if (!srcFile.equals(destFile)) {
                FileUtils.copyFile(srcFile, destFile);
            }
        } else {
            imageMark(imgBuff, width, height, pos, offsetX, offsetY, text,
                    color, size, alpha);
            writeFile(imgBuff, destFile);
            imgBuff = null;
        }
    }

    /**
     * 
     * @param srcFile
     * @param destFile
     * @param minWidth
     * @param minHeight
     * @param pos
     * @param offsetX
     * @param offsetY
     * @param markFile
     * @throws IOException
     */
    public static void imageMark(File srcFile, File destFile, int minWidth,
            int minHeight, int pos, int offsetX, int offsetY, File markFile)
            throws IOException {
        BufferedImage imgBuff = ImageIO.read(srcFile);
        int width = imgBuff.getWidth();
        int height = imgBuff.getHeight();
        if (width <= minWidth || height <= minHeight) {
            imgBuff = null;
            if (!srcFile.equals(destFile)) {
                FileUtils.copyFile(srcFile, destFile);
            }
        } else {
            imageMark(imgBuff, width, height, pos, offsetX, offsetY, markFile);
            writeFile(imgBuff, destFile);
            imgBuff = null;
        }

    }

    /**
     * 
     * @param imgBuff
     * @param width
     * @param height
     * @param pos
     * @param offsetX
     * @param offsetY
     * @param text
     * @param color
     * @param size
     * @param alpha
     * @throws IOException
     */
    private static void imageMark(BufferedImage imgBuff, int width, int height,
            int pos, int offsetX, int offsetY, String text, Color color,
            int size, int alpha) throws IOException {
        Position p = ImageUtils.markPosition(width, height, pos, offsetX,
                offsetY);
        Graphics2D g = imgBuff.createGraphics();
        g.setColor(color);
        g.setFont(new Font(null, Font.PLAIN, size));
        AlphaComposite a = AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                (float) alpha / 100);
        g.setComposite(a);
        g.drawString(text, p.getX(), p.getY());
        g.dispose();
    }

    private static void imageMark(BufferedImage imgBuff, int width, int height,
            int pos, int offsetX, int offsetY, File markFile)
            throws IOException {
        Position p = ImageUtils.markPosition(width, height, pos, offsetX,
                offsetY);
        Graphics2D g = imgBuff.createGraphics();
        AlphaComposite a = AlphaComposite.getInstance(AlphaComposite.SRC_ATOP);
        g.setComposite(a);
        g.drawImage(ImageIO.read(markFile), p.getX(), p.getY(), null);
        g.dispose();
    }

    private static BufferedImage scaleImage(BufferedImage srcImgBuff,
            int width, int height, int zoomWidth, int zoomHeight) {
        int[] colorArray = srcImgBuff.getRGB(0, 0, width, height, null, 0,
                width);
        BufferedImage outBuff = new BufferedImage(zoomWidth, zoomHeight,
                BufferedImage.TYPE_INT_RGB);
        float wScale = (float) width / zoomWidth;
        int wScaleInt = (int) (wScale + 0.5);
        float hScale = (float) height / zoomHeight;
        int hScaleInt = (int) (hScale + 0.5);
        int area = wScaleInt * hScaleInt;
        int x0, x1, y0, y1;
        int color;
        long red, green, blue;
        int x, y, i, j;
        for (y = 0; y < zoomHeight; y++) {
            y0 = (int) (y * hScale);
            y1 = y0 + hScaleInt;
            for (x = 0; x < zoomWidth; x++) {
                x0 = (int) (x * wScale);
                x1 = x0 + wScaleInt;
                red = green = blue = 0;
                for (i = x0; i < x1; i++) {
                    for (j = y0; j < y1; j++) {
                        color = colorArray[width * j + i];
                        red += getRedValue(color);
                        green += getGreenValue(color);
                        blue += getBlueValue(color);
                    }
                }
                outBuff.setRGB(x, y, comRGB((int) (red / area),
                        (int) (green / area), (int) (blue / area)));
            }
        }
        return outBuff;
    }

    private static int getRedValue(int rgbValue) {
        return (rgbValue & 0x00ff0000) >> 16;
    }

    private static int getGreenValue(int rgbValue) {
        return (rgbValue & 0x0000ff00) >> 8;
    }

    private static int getBlueValue(int rgbValue) {
        return rgbValue & 0x000000ff;
    }

    private static int comRGB(int redValue, int greenValue, int blueValue) {
        return (redValue << 16) + (greenValue << 8) + blueValue;
    }

}