import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 //declare bacteria variables here   
 Bacteria [] dots;

 public void setup()   
 {     
 	size(800,800);
 	dots = new Bacteria[30];
  	for(int i = 0; i < dots.length; i++)
	  {
	    int myX=(int)(Math.random()*801);
	    int myY=(int)(Math.random()*801);
	    dots[i] = new Bacteria(myX,myY);
	  }
}


 public void draw()   
 {    
 	background(0);
 	noStroke();
 	fill(255, 255, 255, 100);
 	for(int i=0; i<dots.length; i++)
 	{
 		dots[i].move();
 		dots[i].show();
 	}
 }  


 class Bacteria    
 {     
 	int x, y, fat, dire;//declaring variables   
 	Bacteria(int bacX, int bacY)
 	{
 		x=bacX;
 		y=bacY;
 		fat=(int)(Math.random()*20+5);
 		
 		// if(dire==1)
 		// 	bacX= bacX + (int)(Math.random()*7 - 3);
 		// else 
 		// 	y= y + (int)(Math.random()*7 - 3);
 	}
 	public void move()
 	{
 		// move randomly
 		// x=x+(int)(Math.random()*5)-2;
 		// y=y+(int)(Math.random()*5)-2;

 		//follow mouse
 		if (mouseX < x)
	 		x = x + (int)(Math.random()*5)-3;
	 	else if(mouseX > x)
	 		x = x + (int)(Math.random()*5);
	 	if (mouseY < y)
	 		y = y + (int)(Math.random()*5)-3;
	 	else if(mouseY > y)
	 		y = y + (int)(Math.random()*5);
 		//new location
 		if(mousePressed == true)
 		{
 			x=(int)(Math.random()*801);
	    	y=(int)(Math.random()*801);
 		}
 	}
 	public void show()
 	{
 		ellipse(x, y, fat, fat);
 	}

 }    


 //int x, int y
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
