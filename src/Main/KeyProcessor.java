

package Main;

import logic.Control;
import timer.stopWatchX;

public class KeyProcessor
{
	// Static Fields					
	private static stopWatchX stoW = new stopWatchX(200); 	
	private static stopWatchX timer = new stopWatchX(90); 	
	private static char last = ' ';	
	private static int i, j, p , q; 								
	
	// Static Method(s)
	public static void processKey(char key)
	{

		switch(key)
		{
		case '%':								// ESC key
			if(key == ' ')				
				return;
			
			if(key == last)
				if(stoW.isTimeUp() == false)			
					return;
			last = key;
			stoW.resetWatch();
			
			System.exit(0);
			
			break;
		
	
		case '$':
			
			if(key == ' ')				return;
			
			if(key == last)
				if(stoW.isTimeUp() == false)			return;
			last = key;
			stoW.resetWatch();
			
			/* Code to open dialog boxes */
			if(Main.checkCollision(Main.playerBox, Main.item1))
			{
				Main.dialogBox.setTag("Text1");
				
			}
			
			if(Main.checkCollision(Main.playerBox, Main.item2))
			{
				Main.dialogBox.setTag("Text2");
			}

			break;
		
		/* Mouse Coordinates */ 
		case 'm':
			
			if(key == ' ')				return;
			
			if(key == last)
				if(stoW.isTimeUp() == false)			return;
			last = key;
			stoW.resetWatch();
			
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
				
			
		// "a" is for the left direction walk
		case 'a':
			Main.trigger = ""; 
			Main.dialogBox.setTag("Empty");
			// Toggles off dialogue background
			if (timer.isTimeUp())
			{									
				Main.lastPosition.setCoords(Main.mySprite.getCoords().getX(), Main.mySprite.getCoords().getY());
				Main.mySprite.getCoords().adjustX(-12);
				q++;
				Main.mySprite.setTag("walkL"+ q);
				System.out.println(Main.mySprite.getTag());
				if (q >= 5)
				{
					q = 0;
				}
				timer.resetWatch();
			}
			break;
			
			
		// "s" is for going front direction 
		case 's':
			Main.trigger = "";
			Main.dialogBox.setTag("Empty");
			if (timer.isTimeUp())
			{
				Main.lastPosition.setCoords(Main.mySprite.getCoords().getX(), Main.mySprite.getCoords().getY());
				Main.mySprite.getCoords().adjustY(12);
				Main.mySprite.setTag("walkD"+j);
				j++;
				if (j >= 6)
				{
					j = 0;
				}
				timer.resetWatch();
			}
			break;
			
		//"w" is for going up direction 
		case 'w':
			Main.trigger = "";
			Main.dialogBox.setTag("Empty");
			if (timer.isTimeUp())
			{
				Main.lastPosition.setCoords(Main.mySprite.getCoords().getX(), Main.mySprite.getCoords().getY());
				Main.mySprite.getCoords().adjustY(-12);
				p++;
				Main.mySprite.setTag("walkU"+p); 
				
				
				if (p >= 6){
					p = 0;
				}
				timer.resetWatch();
			}
			
			break;
		
		//"d" is for the right direction 
		case 'd':
			Main.trigger = "";
			Main.dialogBox.setTag("Empty");
			System.out.println(Main.mySprite.getTag());
			if (timer.isTimeUp()){
				Main.lastPosition.setCoords(Main.mySprite.getCoords().getX(), Main.mySprite.getCoords().getY());
				Main.mySprite.getCoords().adjustX(12);
				i++;
				Main.mySprite.setTag("walkR"+i);
				if (i >= 7){
					i = 0;
				}
				timer.resetWatch();
			}
			break;
		}
	
	}
}