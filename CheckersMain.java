/*
 * Authors: Kevin Xu and Harold Pham
 * File Creation Date: 8/3/2020
 * File Detail: The main class which will run instances from the other classes to reinact a Checkers game.
*/

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class CheckersMain extends JFrame 
{

	public static void main(String[] args) 
	{
		Board game = new Board();
		
		boolean b = false;
		
		while(b == false)
		{
			game.setSize(700,500);
		}
	}
	


}

