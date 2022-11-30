import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent 
{
	private BufferedImage picture;

	public JImageDisplay(int width, int height) 
	{
		picture = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Dimension dimension = new Dimension(width, height);
		super.setPreferredSize(dimension);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(picture, 0, 0, picture.getWidth(), picture.getHeight(), null);
	}
	
	public void clearImage()
	{
		for (int i = 0; i < picture.getWidth(); i++)
		{
			for (int j = 0; j < picture.getHeight(); j++)
			{
				drawPixel(i, j, 0);
			}
		}
	}
	
	public void drawPixel(int x, int y, int rgbColor)
	{
		picture.setRGB(x, y, rgbColor);
	}
	
	public BufferedImage getPicture() 
	{
        return picture;
    }
}