package com;


import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class Test2 {

    public static void main(String... args) throws IOException {

        File input = new File("/Users/umapadamanna/Desktop/temp/BIG_SFC_Oceanix-City_Image-by-BIG-Bjarke-Ingels-Group_49-greenhouse.jpg");
        BufferedImage image = ImageIO.read(input);

        File output = new File("/Users/umapadamanna/Desktop/temp/BIG_SFC_Oceanix-City_Image-by-BIG-Bjarke-Ingels-Group_49-greenhouse-compress-2.jpg");
        OutputStream out = new FileOutputStream(output);

        ImageWriter writer =  ImageIO.getImageWritersByFormatName("jpg").next();
        ImageOutputStream ios = ImageIO.createImageOutputStream(out);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();
        if (param.canWriteCompressed()){
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(0.2f);
        }

        writer.write(null, new IIOImage(image, null, null), param);

        out.close();
        ios.close();
        writer.dispose();

    }

}



