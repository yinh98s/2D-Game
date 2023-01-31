
// Yingying Sroy 
// CSC 130 (hybrid course)
// Final Project 
// 04.13.2022


package Main;

import Data.Vector2D;
import Data.boundingBox;
import Data.spriteInfo;
import java.util.ArrayList;

import java.awt.Color;
import logic.Control;


public class Main
{
	// Fields (Static) below...
	
	public static Color c = new Color(255,255,0);
	
	//Using ArrayList for my boxes and sprite player
	public static ArrayList<boundingBox> myBoxes = new ArrayList<>(); 	
	public static ArrayList<spriteInfo> sprites = new ArrayList<>(); 
	
	//define a frame counter that started from 0
	public static int counter = 0; 
	
	//define a mouse trigger when my sprite hit the items
	public static String trigger = "";
	public static String textTrigger = "Empty";
	
	//define coordinate of my sprite player 
	public static Vector2D currentVector = new Vector2D(200,200); 	
	public static Vector2D lastVector = new Vector2D(0, 0); 			
	
	//define my play bounding box 
	public static boundingBox playerBox;
	
	//define the coordinates of my bounding boxes for my 2 items 
	public static boundingBox item1 = new boundingBox(230, 430, 560, 700);
	public static boundingBox item2 = new boundingBox(518, 663, 126, 420);
	
	//define my sprite direction that start from the right direction 
	public static spriteInfo mySprite = new spriteInfo(currentVector, "walkR"+ counter);
	public static spriteInfo dialogBox = new spriteInfo(new Vector2D(611,512), textTrigger);
	public static spriteInfo lastPosition = new spriteInfo (lastVector, mySprite.getTag()); 
		
	// End Static fields...

	
	public static void main(String[] args) 
	{
		Control ctrl = new Control();				/* Do NOT remove! */
		ctrl.gameLoop();							/* Do NOT remove! */
	}
	
	
	
	public static void start() 
	{
		//alter my background image into the game engine 
		sprites.add(new spriteInfo(new Vector2D(0, 0), "Background")); 
	
		//define all the bounding boxes to make sure that my sprite wont go out of the wall
		myBoxes.add(new boundingBox(-128, 1400, -128, 140));		//Top boundary
		myBoxes.add(new boundingBox(-128, 120, 0, 720));			//Left boundary
		myBoxes.add(new boundingBox(-128, 1400, 720, 848));			//Bottom boundary
		myBoxes.add(new boundingBox(1170, 1400, -128, 848));		//Right boundary
		
		//define the bounding boxes of the 2 items that is on the background 
		myBoxes.add(new boundingBox(245, 400, 587, 700));			//First box boundary
		myBoxes.add(new boundingBox(538, 648, 126, 389));			//Second box boundary
		
		//add my sprite into the game
		sprites.add(mySprite);
		//also add the text dialog into the game 
		sprites.add(dialogBox);
	}
		
	
	/* THE GAME LOOP */
	public static void update(Control ctrl) 
	{
		//define the bounding box for the player 
		playerBox = 	new boundingBox(mySprite, 21, 106, 106, 122);
		
		//use for loop for sprite walking in the game 
		for (int i = 0; i < sprites.size(); i++)
		{
			ctrl.addSpriteToFrontBuffer(sprites.get(i).getCoords().getX(), sprites.get(i).getCoords().getY(), sprites.get(i).getTag());
		}
		
		for (int i = 0; i < myBoxes.size(); i++)
		{
			if (checkCollision(playerBox, myBoxes.get(i)))
				bouncePlayer();
		}
		
	
	}
	/*END OF THE GAME LOOP*/
	
	
	// Additional Static methods below...(if needed)
	
	
	//create a method that will get the play to the current position when collide with each other 
	public static void bouncePlayer()
	{
		
		if ((mySprite.getCoords().getY() - lastPosition.getCoords().getY()) != 0)
		{
			if ((mySprite.getCoords().getY() - lastPosition.getCoords().getY()) > 0)		
				mySprite.getCoords().adjustY(-12);
			if ((mySprite.getCoords().getY() - lastPosition.getCoords().getY()) < 0)		
				mySprite.getCoords().adjustY(+12);
		}
		
		if ((mySprite.getCoords().getX() - lastPosition.getCoords().getX()) != 0)
		{
			if ((mySprite.getCoords().getX() - lastPosition.getCoords().getX()) > 0)
					mySprite.getCoords().adjustX(-12);
			if ((mySprite.getCoords().getX() - lastPosition.getCoords().getX()) <0) 	
				mySprite.getCoords().adjustX(+12);
		}
		
	}
	
	//check collision between two boxes 
	public static boolean checkCollision(boundingBox box1, boundingBox box2)
	{
		if (((box1.getX1()   > box2.getX2()) 
			|| (box1.getX2() < box2.getX1()) 
			|| (box1.getY1() > box2.getY2()) 
			|| (box1.getY2() < box2.getY1())))
			return false;
		else 
			return true;
		}

	

	
}