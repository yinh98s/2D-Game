
package Data;

// create a custom data type for the bounding box collision object (single bounding with behavior)

public class boundingBox
{
	// fields
	
	private int x1, x2;   //left and right coordinate on the x-axis
	private int y1, y2;   //top and bottom coordinate on the y-axis
	private spriteInfo spriteData; 
	
	
	//constructor of the bounding box class
	public boundingBox(int x1, int x2, int y1, int y2)
	{
		// save the constructor parameters into class fields
		
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		
	}
	
	// overload the constructor when using sprite 
	public boundingBox(spriteInfo mySprite)
	{
		this.spriteData = mySprite;
		x1 = spriteData.getCoords().getX();
		y1 = spriteData.getCoords().getY();
		x2 = spriteData.getCoords().getX() + 128;
		y2 = spriteData.getCoords().getY() + 128;	
	}
	
	/* overload the sprite constructor with adjustment 
	   "adj" stands for adjustment for each boundary */
	public boundingBox(spriteInfo mySprite, int adjX1, int adjY1, int adjX2, int adjY2)
	{
		this.spriteData = mySprite; 
		x1 = spriteData.getCoords().getX() + adjX1;
		y1 = spriteData.getCoords().getY() + adjY1;
		x2 = spriteData.getCoords().getX() + adjX2;
		y2 = spriteData.getCoords().getY() + adjY2;
	}
	
	//below are getter and setter methods
	
	public int getX1()
	{
		return x1;
	}
	
	public void setX1(int val)
	{
		this.x1 = val;
	}
	
	public int getX2()
	{
		return x2;
	}
	
	public void setX2(int val)
	{
		this.x2 = val;
	}
	
	public int getY1()
	{
		return y1;
	}
	
	public void setY1(int val)
	{
		this.y1 = val;
	}
	
	public int getY2()
	{
		return y2;
	}
	
	public void setY2(int val)
	{
		this.y2 = val;
	}
	
	//@toString method representing x,y coordinate of the collision bounding box
	public String toString()
	{
		return  " x1 : " + x1 +
				" y1 : " + y1 +
				" x2 : " + x2 +
				" y2 : " + y2;
	}

}
