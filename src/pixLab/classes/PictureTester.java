package pixLab.classes;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Nicholas White
 */
public class PictureTester
{
	/** Method to test zeroBlue */
	public static void testZeroBlue()
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}
	
	public static void testKeepOnlyBlue()
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.keepOnlyBlue();
		beach.explore();
	}
	
	public static void testNegate()
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.negate();
		beach.explore();
	}
	
	public static void testGrayscale()
	{
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.grayscale();
		beach.explore();
	}
	
	public static void testFixUnderwater()
	{
		Picture water = new Picture("water.jpg");
		water.explore();
		water.fixUnderwater();
		water.explore();
	}

	/** Method to test mirrorVertical */
	public static void testMirrorVertical()
	{
		Picture koala = new Picture("koala.jpg");
		koala.explore();
		koala.mirrorVertical();
		koala.explore();
	}

	public static void testMirrorVerticleRightToLeft()
	{
		Picture koala = new Picture("koala.jpg");
		koala.explore();
		koala.mirrorVerticleRightToLeft();
		koala.zeroBlue();
		koala.explore();
	}
	
	public static void testmirrorHorizontalBottomToTop()
	{
		Picture koala = new Picture("koala.jpg");
		koala.explore();
		koala.mirrorHorizontalBottomToTop();
		koala.explore();
	}
	
	public static void testMirrorDiagonal()
	{
		Picture koala = new Picture("koala.jpg");
		koala.explore();
		koala.mirrorDiagonal();
		koala.explore();
	}
	
	public static void testMirrorDiagonalBottomRightToTopLeft()
	{
		Picture koala = new Picture("koala.jpg");
		koala.explore();
		koala.mirrorDiagonalBottomRightToTopLeft();
		koala.explore();
	}
	
	/** Method to test mirrorTemple */
	public static void testMirrorTemple()
	{
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		temple.mirrorTemple();
		temple.explore();
	}
	
	public static void testMirrorGull()
	{
		Picture seagull = new Picture("seagull.jpg");
		seagull.mirrorGull();
		seagull.explore();
	}
	
	public static void testMirrorArms()
	{
		Picture snowman = new Picture("snowman.jpg");
		snowman.explore();
		snowman.mirrorArms();
		snowman.explore();
	}

	/** Method to test the collage method */
	public static void testCollage()
	{
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();
		canvas.explore();
	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection()
	{
		Picture swan = new Picture("swan.jpg");
		swan.edgeDetection(10);
		swan.explore();
	}
	
	public static void testEdgeDetection2()
	{
		Picture swan = new Picture("koala.jpg");
		swan.edgeDetection2(10);
		swan.explore();
	}
	
	public static void allTheThings()
	{
		Picture koala = new Picture ("koala.jpg");
		koala.mirrorHorizontalBottomToTop();
		koala.explore();
		koala.mirrorDiagonal();
		koala.explore();
		koala.mirrorVerticleRightToLeft();
		koala.explore();
		Picture cycle = new Picture ("blueMotorcycle.jpg");
		cycle.mirrorHorizontalBottomToTop();
		cycle.explore();
		cycle.mirrorDiagonal();
		cycle.explore();
		cycle.mirrorVerticleRightToLeft();
		cycle.explore();
		Picture swan = new Picture ("swan.jpg");
		swan.mirrorHorizontalBottomToTop();
		swan.explore();
		swan.mirrorDiagonal();
		swan.explore();
		swan.mirrorVerticleRightToLeft();
		swan.explore();
		Picture beach = new Picture ("beach.jpg");
		beach.mirrorHorizontalBottomToTop();
		beach.explore();
		beach.mirrorDiagonal();
		beach.explore();
		beach.mirrorVerticleRightToLeft();
		beach.explore();
		//koala.write("allTheThings.jpg");
	}
	
	public static void preview()
	{
		//Picture preview1 = new Picture("blueMotorcycle.jpg");
		Picture preview2 = new Picture("koalaMinnie.jpg");
		//preview1.explore();
		preview2.explore();
	}
	
	public static void testCopy()
	{
		Picture koala = new Picture("koalaMinnie.jpg");
		Picture bike = new Picture("blueMotorcycle.jpg");
		bike.explore();
		bike.copy2(koala, 0, 230, 300, 366);
		bike.explore();
	}
	
	public static void testPersonalCollage()
	{
		Picture canvas = new Picture("1000x700.jpg");
		canvas.createPersonalCollage();
		canvas.explore();
	}
	
	//public static testFullRandom()
	//{
	//	Picture random = Picture
	//}

	/**
	 * Main method for testing. Every class can have a main method in Java
	 */
	public static void main(String[] args)
	{
		// uncomment a call here to run a test
		// and comment out the ones you don't want
		// to run
		//testZeroBlue();
		// testKeepOnlyBlue();
		// testKeepOnlyRed();
		// testKeepOnlyGreen();
		// testNegate();
		// testGrayscale();
		// testFixUnderwater();
		//testMirrorVertical();
		//testMirrorVerticleRightToLeft();
		//testmirrorHorizontalBottomToTop();
		 //testMirrorTemple();
		// testMirrorArms();
		// testMirrorGull();
		// testMirrorDiagonal();
		// testCollage();
			testPersonalCollage();
		// testCopy();
		
		// testEdgeDetection();
		// testEdgeDetection2();
		// testChromakey();
		// testEncodeAndDecode();
		// testGetCountRedOverValue(250);
		// testSetRedToHalfValueInTopHalf();
		// testClearBlueOverValue(200);
		// testGetAverageForColumn(0);
		//testFixUnderwater();
		//testKeepOnlyBlue();
		//testNegate();
		//testGrayscale();
		//testMirrorDiagonal();
		//testMirrorDiagonalBottomRightToTopLeft();
		//allTheThings();
		//preview();
		//testMirrorGull();
		//testFullRandom();
		//testMirrorArms();
	}
}