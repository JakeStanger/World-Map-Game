package util;

public class CoordinateManager
{	
	public static final int MAX_X = 1920;
	public static final int MAX_Y = 1080;
	
	public static double X_RATIO,Y_RATIO;
	
	/**
	 * Convert coordinates to an actual position
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return an array containing the actual x and y
	 */
	public double[] getActualPostion(double x, double y)
	{
		double[] pos = new double[2];
		
		pos[0] = x * X_RATIO;
		pos[1] = y * Y_RATIO;
		
		return pos;
	}
	
	/**
	 * Convert an actual position to coordinates
	 * @param x the x position
	 * @param y the y position
	 * @return an array containing the coordinate x and y
	 */
	public double[] getCoordinatePosition(int x, int y)
	{
		double[] pos = new double[2];
		
		pos[0] = x / X_RATIO;
		pos[1] = y / Y_RATIO;
		
		return pos;
	}
}
