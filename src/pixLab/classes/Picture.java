package pixLab.classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture()
	{
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName)
	{
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width)
	{
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture)
	{
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image)
	{
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */

	public void makeTransparent()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels)
		{
			for (Pixel pixel : row)
			{
				pixel.setAlpha(70);
			}
		}
	}

	public String toString()
	{
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setGreen(0);
				pixelObj.setRed(0);
			}
		}
	}

	public void fixUnderwater()
	{

		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(pixelObj.getBlue() - 50);
				// pixelObj.setRed(25-pixelObj.getRed());
				pixelObj.setGreen(pixelObj.getGreen() - 50);
			}
		}
	}

	public void negate()
	{

		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(255 - pixelObj.getBlue());
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setGreen(255 - pixelObj.getGreen());
			}
		}
	}

	public void grayscale()
	{

		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue((pixelObj.getBlue() + pixelObj.getRed() + pixelObj.getGreen()) / 3);
				pixelObj.setRed((pixelObj.getBlue() + pixelObj.getRed() + pixelObj.getGreen()) / 3);
				pixelObj.setGreen((pixelObj.getBlue() + pixelObj.getRed() + pixelObj.getGreen()) / 3);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width / 2; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorVerticleRightToLeft()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;

		for (int row = pixels.length - 1; row >= 0; row--)
		{
			for (int col = width / 2 - 1; col >= 0; col--)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	public void mirrorHorizontalBottomToTop()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;

		int height = pixels.length;

		for (int col = 0; col < pixels[0].length; col++)
		{
			for (int row = height / 2 - 1; row >= 0; row--)
			{
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - 1 - row][col];
				topPixel.setColor(bottomPixel.getColor());
			}
		}
	}

	public void mirrorDiagonal()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topR = null;
		Pixel bottomL = null;
		int height = pixels.length;

		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < pixels[0].length; col++)
			{
				if (row != col && row < pixels[0].length && col < height)
				{
					topR = pixels[row][col];
					bottomL = pixels[col][row];

					bottomL.setColor(topR.getColor());
				}
			}
		}
	}

	public void mirrorDiagonalBottomRightToTopLeft()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel bottomR = null;
		Pixel topL = null;

		int mirrorPoint = Math.min(pixels.length, pixels[0].length) - 1;

		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < pixels[0].length; col++)
			{
				if (row + col != mirrorPoint && row < pixels[0].length && col < pixels.length)
				{
					topL = pixels[row][col];
					bottomR = pixels[mirrorPoint - col][mirrorPoint - row];

					topL.setColor(bottomR.getColor());
				}
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple()
	{
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++)
		{
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++)
			{

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorGull()
	{

		int mirrorPoint = 350;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 230; row < 325; row++)
		{
			for (int col = 230; col < mirrorPoint; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];

				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorArms()
	{

		int mirrorPoint1 = 195;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 155; row < 195; row++)
		{
			for (int col = 100; col < 175; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[(mirrorPoint1 + 40) - (row - 155)][col];

				rightPixel.setColor(leftPixel.getColor());
			}
		}

		for (int row = 167; row < 200; row++)
		{
			for (int col = 237; col < 297; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[(mirrorPoint1 + 40) - (row - 155)][col];

				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void copy2(Picture fromPic, int startRow, int startCol, int endRow, int endCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 25, toRow = startRow; fromRow < 238 && toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = 75, toCol = startCol; fromCol < 220 && toCol < toPixels[0].length; fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void copy3(Picture fromPic, int startRow, int startCol, int endRow, int endCol, int toRow, int toCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = startRow; fromRow < endRow; fromRow++, toRow++)
		{
			for (int fromCol = startCol, toCol1 = toCol; fromCol < endCol; fromCol++, toCol1++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol1];
				if (fromPixel.getColor().getRGB() == Color.WHITE.getRGB())
				{
				} else
				{
					int avgRed = (fromPixel.getRed() + toPixel.getRed()) / 2;
					int avgGreen = (fromPixel.getGreen() + toPixel.getGreen()) / 2;
					int avgBlue = (fromPixel.getBlue() + toPixel.getBlue()) / 2;
					Color transparentColor = new Color(avgRed, avgGreen, avgBlue);
					toPixel.setColor(transparentColor);
				}
			}
		}
	}

	// this is not good ude henrichsens method of copying from a new instance of
	// the same picture.
	public void overlayAssassin()
	{
		Picture assassin = new Picture("assassinValentines.jpg");
		assassin.copy(assassin, 30, 40);
		assassin.explore();
		

	}

	/** Method to create a collage of several pictures */
	public void createCollage()
	{
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	public void createPersonalCollage()
	{
		Picture koala = new Picture("koalaCropped.jpg");
		Picture captainCanada = new Picture("CaptainCanada.jpg");
		// turn to this.copy2
		this.copy(captainCanada, 100, 0);
		// turn to this.copy2
		this.copy(koala, 200, 0);
		Picture flowerNoBlue = new Picture(captainCanada);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		// turn to this.copy2
		this.copy(koala, 325, 70);
		this.copy(captainCanada, 500, 0);
		this.copy(koala, 600, 0);
		this.mirrorVertical();
		this.write("personalCollage.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist)
	{
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < pixels[0].length - 1; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				rightColor = rightPixel.getColor();
				if (leftPixel.colorDistance(rightColor) > edgeDist)
				{
					leftPixel.setColor(Color.BLACK);
				} else
				{
					leftPixel.setColor(Color.WHITE);
				}
			}
		}
	}

	public void edgeDetection2(int edgeDist)
	{
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		Color bottomColor = null;

		for (int row = 0; row < pixels.length - 1; row++)
		{
			for (int col = 0; col < pixels[0].length - 1; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				bottomPixel = pixels[row + 1][col];
				rightColor = rightPixel.getColor();
				bottomColor = bottomPixel.getColor();

				if (leftPixel.colorDistance(rightColor) > edgeDist)
				{
					leftPixel.setColor(Color.black);
				} else if (leftPixel.colorDistance(bottomColor) > edgeDist)
				{
					leftPixel.setColor(Color.black);
				} else
				{
					leftPixel.setColor(Color.white);
				}
			}
		}
	}

	public void fullRandom()
	{
		Pixel[][] currentPicture = this.getPixels2D();
		for (Pixel[] row : currentPicture)
		{
			for (Pixel currentPixel : row)
			{
				int red = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);

				currentPixel.setColor(new Color(red, green, blue));
			}
		}
	}

	public void fullRandomRed()
	{
		Pixel[][] currentPicture = this.getPixels2D();
		for (Pixel[] row : currentPicture)
		{
			for (Pixel currentPixel : row)
			{
				int red = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);

				currentPixel.setColor(new Color(red, currentPixel.getGreen(), currentPixel.getBlue()));
			}
		}
	}

	public void valentinesPoroMeme()
	{
		explore();
		addMessage("Roses are red"/*
									 * violets are blue, sorry but I won't share
									 * my snacks with you.
									 */, 20, 30);
		addMessage("Violets are blue", 20, 50);
		addMessage("Sorry I won't share my snacks with you", 20, 70);
		explore();
		this.write("poroValentines");

		// this.write("valentinesPoro");
	}

	public void valentinesAssassinMeme()
	{
		this.addBlackMessage("Roses are red"/*
											 * violets are blue, sorry but I
											 * won't share my snacks with you.
											 */, 15, 40);
		this.addBlackMessage("Violets are blue", 15, 80);
		this.addBlackMessage("I promise I won't", 15, 120);
		this.addBlackMessage("assassinate you", 15, 150);
		explore();
		this.write("assassinValentines.jpg");
	}

	public void manyFiltersAssassin()
	{
		this.addBlackMessage("Roses are red"/*
											 * violets are blue, sorry but I
											 * won't share my snacks with you.
											 */, 15, 40);
		this.addBlackMessage("Violets are blue", 15, 80);
		this.addBlackMessage("I promise I won't", 15, 120);
		this.addBlackMessage("assassinate you", 15, 150);
		this.mirrorVertical();
		this.zeroBlue();
		this.mirrorDiagonalBottomRightToTopLeft();
		this.mirrorHorizontalBottomToTop();
		explore();
		this.write("assassinManyFilters.jpg");
	}
	
	public void encode(Picture hiddenPicture)
	{
		Pixel [][] currentPicture = this.getPixels2D();
		Pixel [][] hiddenData = hiddenPicture.getPixels2D();
		
		Pixel hiddenPixel = null;
		Pixel currentPixel = null;
		
		for(int row = 0; row < currentPicture.length; row++)
		{
			for(int col = 0; col < currentPicture[0].length; col ++)
			{
				hiddenPixel = hiddenData[row][col];
				currentPixel = currentPicture[row][col];
				
				if(hiddenPixel.getRed() == 255 && hiddenPixel.getGreen() == 255 && hiddenPixel.getBlue() == 255)
				{
						int currentRed = currentPixel.getRed();
						if(currentRed % 2 == 0)
						{
							currentPixel.setRed(currentRed + 1);
						}
					
				}
				else
				{
					int currentRed = currentPixel.getRed();
					if(currentRed % 2 != 0)
					{
						currentPixel.setRed(currentRed - 1);
					}
				}
			}
			
		}
		this.write("encrypted.png");
		this.explore();
	}
	
	public void decode()
	{
		Pixel [][] decoded = this.getPixels2D();
		Pixel currentPixel = null;
		
		for(int row = 0; row < decoded.length; row++)
		{
			for(int col = 0; col < decoded[0].length; col++)
			{
				currentPixel = decoded[row][col];
				int currentRed = currentPixel.getRed();
				if(currentRed % 2 == 0)
				{
					currentPixel.setColor(new Color(127, 255, 0));
				}
			}
		}
		this.explore();
	}


	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args)
	{
		// Picture beach = new Picture("beach.jpg");
		// beach.explore();
		// beach.zeroBlue();
		// beach.explore();

	}

} // this } is the end of class Picture, put all new methods before this
