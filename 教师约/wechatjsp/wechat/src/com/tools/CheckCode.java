package com.tools;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CheckCode extends HttpServlet {
	public CheckCode() {
		super();
	}

	
	public Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r = s + random.nextInt(e - s); 
		int g = s + random.nextInt(e - s); 
		int b = s + random.nextInt(e - s); 
		return new Color(r, g, b);
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		
		response.setContentType("image/jpeg");
		int width = 116; 
		int height = 33; 

		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics(); 
		Random random = new Random(); 
		Font mFont = new Font("宋体", Font.BOLD, 22); 
		g.fillRect(0, 0, width, height); 
		g.setFont(mFont); 
		g.setColor(getRandColor(180, 200)); 
		
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(3) + 1;
			int y1 = random.nextInt(6) + 1;
			g.drawLine(x, y, x + x1, y + y1); 
		}
		
		BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL); 
		Graphics2D g2d = (Graphics2D) g; 
		g2d.setStroke(bs); 
		g.setColor(Color.GRAY); 
		int lineNumber = 4; 
		int[] xPoints = new int[lineNumber]; 
		int[] yPoints = new int[lineNumber]; 
		
		for (int j = 0; j < lineNumber; j++) {
			xPoints[j] = random.nextInt(width - 1);
			yPoints[j] = random.nextInt(height - 1);
		}
		g.drawPolyline(xPoints, yPoints, lineNumber); 
		
		String sRand = "";
		
		for (int i = 0; i < 4; i++) {
			char ctmp = (char) (random.nextInt(26) + 65); 
			sRand += ctmp;
			Color color = new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110));
			g.setColor(color); 
			
			Graphics2D g2d_word = (Graphics2D) g;
			AffineTransform trans = new AffineTransform();
			trans.rotate(random.nextInt(45) * 3.14 / 180, 22 * i + 8, 7);
			
			float scaleSize = random.nextFloat() + 0.8f;
			if (scaleSize > 1f)
				scaleSize = 1f;
			trans.scale(scaleSize, scaleSize); 
			g2d_word.setTransform(trans);
			
			g.drawString(String.valueOf(ctmp), width / 6 * i + 23, height / 2);

		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("randCheckCode", sRand);
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	public void destroy() {
		super.destroy();
	}

	public void init() throws ServletException {
		super.init();
	}
}
