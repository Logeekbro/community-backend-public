package com.db.community.utils;

import cn.hutool.core.io.FileTypeUtil;
import com.db.community.common.GlobalVars;
import com.db.community.exception.ApiAsserts;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageUtil {

    private static final Font DEFAULT_FONT = new Font("微软雅黑", Font.PLAIN, 24);
    private static final Integer WIDTH = 400;
    private static final Integer HEIGHT = 120;

    public static BufferedImage strToImage(String... str) {
        // 创建图片
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();
        g.setClip(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);// 先用黑色填充整张图片,也就是背景
        g.setColor(Color.black);// 在换成黑色
        g.setFont(DEFAULT_FONT);// 设置画笔字体
        /** 用于获得垂直居中y */
        Rectangle clip = g.getClipBounds();
        FontMetrics fm = g.getFontMetrics(DEFAULT_FONT);
        int ascent = fm.getAscent();
        int descent = fm.getDescent();
        int y = (clip.height - (ascent + descent)) / 2 + ascent;
        for (int i = 0; i < 6; i++) {// 256 340 0 680
            // 画出字符串
            // 第一行
            g.drawString(str[0], i * 680, y - 34);
            // 第二行
            g.drawString(str[1], i * 680, y);
            // 第三行
            g.drawString(str[2], i * 680, y + 35);
//            g.drawString(str[3], i * 680, y + 40);
        }
        g.dispose();
//        ImageIO.write(image, "png", new File("d:/a.png"));
        return image;
    }

    public static void strToResponseImage(HttpServletResponse response, String... str) throws IOException {
        //设置编码格式
        response.setCharacterEncoding("UTF-8");

        // 设置不缓存图片
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);

        // 指定生成的响应图片,一定不能缺少这句话,否则错误.
        response.setContentType("image/jpeg");
        BufferedImage bufferedImage = strToImage(str);
        ImageIO.write(bufferedImage, "png", response.getOutputStream());
    }

    public static String getImgType(MultipartFile file) {
        try {
            String type = FileTypeUtil.getType(file.getInputStream());
            if(!GlobalVars.ACCEPT_IMG_TYPE.contains(type)){
                ApiAsserts.fail("不支持的文件类型");
                System.out.println("不支持的文件类型：" + type);
            }
            else {
                return type;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ApiAsserts.fail("读取图片时出现异常");
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        strToImage("a=在 b=人 c=嗄","a=给 b=锕 c=发","a=去 b=就 c=怕","a=吧 b=下 c=这");
    }
}
