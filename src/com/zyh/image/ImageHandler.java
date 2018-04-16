package com.zyh.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class ImageHandler {

    public static void main(String[] args) throws IOException {
        String path = "/Users/admin/Desktop/san.jpeg";
        BufferedImage bufferedImage = ImageIO.read(new File(path));

        Raster raster = bufferedImage.getData();
        int [] temp = new int[raster.getWidth()*raster.getHeight()*raster.getNumBands()];
        //方式二：通过getPixels()方式获得像素矩阵
        //此方式为沿Width方向扫描
        int [] pixels  = raster.getPixels(0,0,raster.getWidth(),raster.getHeight(),temp);
    }
}
