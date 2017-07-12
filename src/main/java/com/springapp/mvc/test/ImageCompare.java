package com.springapp.mvc.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * 图片相似度对比，还没有验证
 * 通过RPG值计算
 *
 * @auther f4o823hv9
 * @since  2017/7/9.
 */
public class ImageCompare {

    private Logger logger = LoggerFactory.getLogger(ImageCompare.class);

    public void compareImage() {
        try {
            BufferedImage bufferedImage1= ImageIO.read(new File("E:/b1.png"));
            BufferedImage bufferedImage2= ImageIO.read(new File("E:/b2.png"));
//获得相似度
            float Similarity = compareImage(bufferedImage1, bufferedImage2);
//在标签上显示
            logger.info("图片相似度:" + Similarity);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error("读取图片出错！");
            e.printStackTrace();
        }
    }

    private static HashMap GetRGBMap(BufferedImage bufferedImage) {
        HashMap map=new HashMap();

        for(int x=0;x<bufferedImage.getWidth();x++)
        {
            for(int y=0;y<bufferedImage.getHeight();y++)
            {
                double RGBValue=bufferedImage.getRGB(x, y);
//如果没有保存该色值,存入
                if(map.get(RGBValue)==null)
                {
                    map.put(RGBValue, 1);
                }
//将该色值出现次数增加一次
                else
                {
                    int Times=(Integer) map.get(RGBValue);
                    Times+=1;
                    map.put(RGBValue, Times);
                }

            }
        }


        return map;
    }

    private static HashMap VectorNormalizing(HashMap RGBMap) {
//求图片特征向量1的模长
        double ModulaLength=0;
        for(Object i:RGBMap.keySet())
        { //先将所有平方相加
            ModulaLength+=Math.pow((double)(Integer)RGBMap.get(i), 2);
        }
//求平方根
        ModulaLength=Math.sqrt(ModulaLength);
//将图片特征向量1标准化
        for(Object i:RGBMap.keySet())
        {
            double a=(double)(Integer) RGBMap.get(i);
            a=a/ModulaLength;
            RGBMap.put(i, a);
        }

        return RGBMap;
    }

    public static float compareImage(BufferedImage bufferedImage1, BufferedImage bufferedImage2) {

        HashMap RGBMap1=GetRGBMap(bufferedImage1);
        HashMap RGBMap2=GetRGBMap(bufferedImage2);
//相似度
        float Similarity=0;

//将两个HashMap视作特征向量进行归一化
        RGBMap1=VectorNormalizing(RGBMap1);
        RGBMap2=VectorNormalizing(RGBMap2);

//向量点积得到相似度
        for(Object i:RGBMap1.keySet())
        { double Value2;
            if(RGBMap2.get(i)==null)
            {Value2=0;}
            else
            {Value2= (Double) RGBMap2.get(i);}
            double Value1=(Double) RGBMap1.get(i);

            Similarity+=Value1*Value2;

        }

        return Similarity*100;
    }

}
