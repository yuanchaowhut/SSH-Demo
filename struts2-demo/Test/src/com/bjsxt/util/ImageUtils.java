package com.bjsxt.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

/**
 * ͼ�������ࣨ������ȫ����ʹ�ã����Ǹ����Ƽ�ImageMagick +Jmagick������C++ʵ�ֵ�һ����⣬�ṩ��Java��Api���ǳ�ǿ��͸�Ч��
 * ����ҪΪJVM����ϴ�Ķ��ڴ棬�����ڴ����
 * @author 
 */
public class ImageUtils {

	/**
	 * ����ͼƬ
	 * @param src Դ�ļ�
	 * @param dest Ŀ���ļ�
	 * @param ratio ���ű������� 0.1,0.8,1.2,2.4
	 * @throws IOException 
	 */
	public static void zoom(String src,String dest,double ratio) throws IOException{
		//��ȡ�ļ���չ��
		String suffix=src.substring(src.lastIndexOf(".")+1);
		//�����ļ�
		BufferedImage bi=ImageIO.read(new File(src));
		//����Ŀ���ļ����
		int targetWidth=Integer.parseInt(new DecimalFormat("0").format(bi.getWidth()*ratio));
		//����Ŀ���ļ��߶�
		int targetHeight=Integer.parseInt(new DecimalFormat("0").format(bi.getHeight()*ratio));
		//��ȡBufferedImage�����ͼƬ��һ�����ŵİ汾
		Image image=bi.getScaledInstance(targetWidth,targetHeight,Image.SCALE_DEFAULT);
		//����һ�ſհ׵Ļ���ͼƬ
		BufferedImage target=new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		//����һ��2Dͼ��
		Graphics g=target.createGraphics();
		//��BufferedImage�����ͼƬ������һ�������Ķ�����
		g.drawImage(image, 0, 0, null);
		//�ͷ�
		g.dispose();
		//ͼ��д���ļ�
		ImageIO.write(target, suffix, new File(dest));
	}
	
	/**
	 * ��ͼ
	 * @param src Դ�ļ�
	 * @param dest Ŀ���ļ�
	 * @param startX ���x����
	 * @param startY ���y����
	 * @param endX ������x����
	 * @param endY ������y����
	 * @throws IOException
	 */
	public static void cut(String src,String dest,int startX,int startY,int endX,int endY) throws IOException{
		//��ȡ�ļ���չ��
		String suffix=src.substring(src.lastIndexOf(".")+1);
		//�����ļ�
		BufferedImage bi=ImageIO.read(new File(src));
		//������
		int width=Math.abs(startX-endX);
		//����߶�
		int height=Math.abs(startY-endY);
		BufferedImage target= bi.getSubimage(startX, startY, width, height);
		ImageIO.write(target, suffix, new File(dest));
	}
	
	/**
	 * ��תͼƬ
	 * 
	 * @param src Դ�ļ�
	 * @param dest Ŀ���ļ�
	 * @param degree ��ת�Ƕ�
	 * @param bgcolor ����ɫ���ޱ���ɫΪnull
	 * @throws IOException
	 */
	public static void rotate(String src, String dest, int degree, Color bgcolor) throws IOException {
		BufferedImage image = ImageIO.read(new File(src));
		int iw = image.getWidth();// ԭʼͼ��Ŀ��
		int ih = image.getHeight();// ԭʼͼ��ĸ߶�
		int w = 0;
		int h = 0;
		int x = 0;
		int y = 0;
		degree = degree % 360;
		if (degree < 0)
			degree = 360 + degree;// ���Ƕ�ת����0-360��֮��
		double ang = Math.toRadians(degree);// ���Ƕ�תΪ����

		/**
		 * ȷ����ת���ͼ��ĸ߶ȺͿ��
		 */

		if (degree == 180 || degree == 0 || degree == 360) {
			w = iw;
			h = ih;
		} else if (degree == 90 || degree == 270) {
			w = ih;
			h = iw;
		} else {
			double cosVal = Math.abs(Math.cos(ang));
			double sinVal = Math.abs(Math.sin(ang));
			w = (int) (sinVal * ih) + (int) (cosVal * iw);
			h = (int) (sinVal * iw) + (int) (cosVal * ih);
		}

		x = (w / 2) - (iw / 2);// ȷ��ԭ������
		y = (h / 2) - (ih / 2);
		BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
		Graphics2D gs = (Graphics2D) rotatedImage.getGraphics();
		if (bgcolor == null) {
			rotatedImage = gs.getDeviceConfiguration().createCompatibleImage(w,h, Transparency.TRANSLUCENT);
		} else {
			gs.setColor(bgcolor);
			gs.fillRect(0, 0, w, h);// �Ը�����ɫ������ת��ͼƬ�ı���
		}

		AffineTransform at = new AffineTransform();
		at.rotate(ang, w / 2, h / 2);// ��תͼ��
		at.translate(x, y);
		AffineTransformOp op = new AffineTransformOp(at,
				AffineTransformOp.TYPE_BICUBIC);
		op.filter(image, rotatedImage);
		image = rotatedImage;

		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ImageOutputStream iamgeOut = ImageIO.createImageOutputStream(byteOut);

		ImageIO.write(image, "png", iamgeOut);
		InputStream is = new ByteArrayInputStream(byteOut.toByteArray());

		OutputStream os = new FileOutputStream(new File(dest));

		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		os.close();
		is.close();
		byteOut.close();
	}
	
	//���Գ���
	public static void main(String[] args) {
		try {
			zoom("d:/1.jpg","d:/zoom.jpg", 0.5);
			rotate("d:/1.jpg", "d:/rotate.jpg", 45, Color.blue);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
