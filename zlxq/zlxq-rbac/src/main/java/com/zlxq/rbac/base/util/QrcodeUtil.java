/**
 * 
 */
package com.zlxq.rbac.base.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * @TODO
 * @author zhangl
 *
 * @createtime 2019年5月31日
 * @version V1.0
 */
public class QrcodeUtil {

	public static void createQrcode(String content, String targetPath) {
		try {
			Qrcode logoQrCode = new Qrcode();
			logoQrCode.setQrcodeErrorCorrect('M');
			logoQrCode.setQrcodeEncodeMode('B');
			logoQrCode.setQrcodeVersion(7);

			BufferedImage bufferedImage = new BufferedImage(139, 139, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufferedImage.createGraphics();
			gs.setBackground(Color.WHITE);
			gs.setColor(Color.black);
			gs.clearRect(0, 0, 139, 139);

			byte[] contents = content.getBytes("utf-8");

			int opx = 2;
			if (contents.length > 0 && contents.length < 130) {
				boolean[][] codeOut = logoQrCode.calQrcode(contents);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + opx, i * 3 + opx, 3, 3);
						}
					}
				}
			} else {
				System.err.println("QRCode content bytes length = " + contents.length + " not in [ 0,130 ]. ");
				return;
			}

			gs.dispose();
			bufferedImage.flush();
			// 生成二维码QRCode图片
			
			File imgFile = new File(targetPath);
			
			if(!imgFile.exists()){  
				imgFile.getParentFile().mkdirs();
			    try {
			    	imgFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
			
			// 生成的图片在D盘下，名为 qrCode.png
			ImageIO.write(bufferedImage, "png", imgFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createLogoQrcode(String content, String logoPath) {
		try {

			Qrcode logoQrCode = new Qrcode();
			logoQrCode.setQrcodeErrorCorrect('M');
			logoQrCode.setQrcodeEncodeMode('B');
			logoQrCode.setQrcodeVersion(7);

			BufferedImage bufferedImage = new BufferedImage(139, 139, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufferedImage.createGraphics();
			gs.setBackground(Color.WHITE);
			gs.setColor(Color.black);
			gs.clearRect(0, 0, 139, 139);

			byte[] contents = content.getBytes("utf-8");

			int opx = 2;
			if (contents.length > 0 && contents.length < 130) {
				boolean[][] codeOut = logoQrCode.calQrcode(contents);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + opx, i * 3 + opx, 3, 3);
						}
					}
				}
			} else {
				System.err.println("QRCode content bytes length = " + contents.length + " not in [ 0,130 ]. ");
				return;
			}

			// logo图片高度
//            Image logo = ImageIO.read(new File(logoPath));
//            int widthLogo = logo.getWidth(null) > bufferedImage.getWidth() * 2 / 10 ? (bufferedImage.getWidth() * 2 / 10) : logo.getWidth(null);
//            int heightLogo = logo.getHeight(null) > bufferedImage.getHeight() * 2 / 10 ? (bufferedImage.getHeight() * 2 / 10) : logo.getWidth(null);

			// 设置logo图片的位置
//            int x = (bufferedImage.getWidth() - widthLogo) / 2;
//            int y = (bufferedImage.getHeight() - heightLogo) / 2;
//
//            gs.drawImage(logo,x,y,widthLogo,heightLogo,null);

			gs.dispose();
			bufferedImage.flush();
			// 生成二维码QRCode图片
			File imgFile = new File("E:/qrcode.png");
			// 生成的图片在D盘下，名为 qrCode.png
			ImageIO.write(bufferedImage, "png", imgFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		QrcodeUtil.createLogoQrcode("liTing_232323", "E:/logo_qrcode.jpg");
		
		QrcodeUtil.createQrcode("123", "E:/qrcode/a.png");
		System.out.println();
		
	}
}
