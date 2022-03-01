package com.yj.web.exercise.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;


/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/3/1
 */
public class VerifyCodeUtil {


    public static String generate(OutputStream os) throws IOException {
        //定义验证码图片的大小
        int width = 200;
        int height = 50;
        //创建一个在内存中存放验证码图片的对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //绘制图片
        //画笔对象
        Graphics g = image.getGraphics();
        //先设颜色后画
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        //绘制边框
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        //随机生成下标
        Random random = new Random();

        StringBuilder stringBuilder = new StringBuilder();

        //四位验证码
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            g.setFont(new Font("宋体", Font.BOLD, 30));
            g.drawString(String.valueOf(ch), width / 5 * i + 20, height / 3 + 20);
            stringBuilder.append(ch);
        }

        //todo:绘制干扰线
        g.setColor(Color.BLUE);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }
        g.dispose();

        //验证码输出到页面
        ImageIO.write(image, "JPEG", os);

        return stringBuilder.toString();
    }
}