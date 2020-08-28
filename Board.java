/*
 * Authors: Harold Pham and Kevin Xu
 * Creation Date: 8/6/2020
 * File Details: Will be the Board class that constructs every new game and holds game data.
*/

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Board extends JPanel
{
//VARIABLES
	private int currentPlayer; //0 == BLACK/P1   1 = RED/P2
	private int currentTurn;
	private DrawingPanel p;
	private Graphics g;
	private Image p1B;
//CONSTRUCTORS
	public Board() //Default construction
	{
		currentPlayer = 0;
		currentTurn = 1;
		
		//Create the Window Objects
		p = new DrawingPanel(700,500);
		g = p.getGraphics();
		p1B = p.loadImage(new File("CheckerBoard.jpg")); 
		
		p.setAlwaysOnTop(true);
		
		//Set the Colors
		p.setBackground(Color.gray);
		g.setColor(Color.BLACK);
		
		g.drawImage(p1B,100,0,p); //Makes the checker Board
		
		//Set the Player Turn Display
		g.drawRect(1, 18, 96, 35);
		displayPlayer(1,15);
		
		//Set the Current Turn Display
		g.drawRect(601, 13, 97, 40);
		g.drawString("Turn: " + currentTurn, 605, 38);
		
		//Red piece objects
		Pieces r1 = new Pieces(g);
		Pieces r2 = new Pieces(g);
		Pieces r3 = new Pieces(g);
		Pieces r4 = new Pieces(g);
		Pieces r5 = new Pieces(g);
		Pieces r6 = new Pieces(g);
		Pieces r7 = new Pieces(g);
		Pieces r8 = new Pieces(g);
		Pieces r9 = new Pieces(g);
		Pieces r10 = new Pieces(g);
		Pieces r11 = new Pieces(g);
		Pieces r12 = new Pieces(g);

		//White piece objects
		Pieces w1 = new Pieces(g);
		Pieces w2 = new Pieces(g);
		Pieces w3 = new Pieces(g);
		Pieces w4 = new Pieces(g);
		Pieces w5 = new Pieces(g);
		Pieces w6 = new Pieces(g);
		Pieces w7 = new Pieces(g);
		Pieces w8 = new Pieces(g);
		Pieces w9 = new Pieces(g);
		Pieces w10 = new Pieces(g);
		Pieces w11 = new Pieces(g);
		Pieces w12 = new Pieces(g);
		
		board = new Pieces[24][24];
		
		//Red positions
		board[0][1] = r1;
		board[0][3] = r2;
		board[0][5] = r3;
		board[0][7] = r4;
		board[1][0] = r5;
		board[1][2] = r6;
		board[1][4] = r7;
		board[1][6] = r8;
		board[2][1] = r1;
		board[2][3] = r2;
		board[2][5] = r3;
		board[2][7] = r4;
		
		//White positions
		board[5][1] = r1;
		board[5][3] = r2;
		board[5][5] = r3;
		board[5][7] = r4;
		board[6][0] = r5;
		board[6][2] = r6;
		board[6][4] = r7;
		board[6][6] = r8;
		board[7][1] = r1;
		board[7][3] = r2;
		board[7][5] = r3;
		board[7][7] = r4;
		
		boolean b = false;
		
		while(b == false)
		{
			p.setSize(700,500);
		}
		
		/*
		JButton button1 = new JButton("Button 1");
	    JButton button2 = new JButton("Button 2");
	    JButton button3 = new JButton("Button 3");
	    JButton button4 = new JButton("Button 4");
	    setLayout(new GridLayout(3, 3));
        setSize(512, 512);
        setOpaque(false);
        add(button1);
        add(new JLabel());
        add(button2);
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        add(button3);
        add(new JLabel());
        add(button4);
		*/
		
	}
	
//METHODS
	
//Accessor Methods
	public int turn()
	{
		return currentTurn;
	}
	
	public int player()
	{
		return currentPlayer;
	}
	
	public Graphics getG()
	{
		return g;
	}
	
	public DrawingPanel getP()
	{
		return p;
	}
	
//Mutator Methods
	public void nextPlayer()
	{
		if(currentPlayer == 0) //set to RED Player
			currentPlayer = 1;
		else
			currentPlayer = 0; //Set to BLACK Player
	}
	
	public void nextTurn()
	{
		currentTurn++;
	}
	
	public void nextRound()
	{
		p.clear();//Clear the board
		
		//Change turns and players
		nextTurn(); 
		nextPlayer();
		
		//Refresh everything
		g.drawImage(p1B,100,0,p); //Makes the checker Board
		
		//Set the Player Turn Display
		g.drawRect(1, 18, 96, 35);
		displayPlayer(1,15);
		
		//Set the Current Turn Display
		g.drawRect(601, 13, 97, 40);
		g.drawString("Turn: " + currentTurn, 605, 38);
		
	}
	
//Misc. Methods
	//Converts our binary player variable into a String at a given spot on the window.
	public void displayPlayer(int x, int y)
	{
		g.setFont(new Font("Monospaced", Font.BOLD,18));//Set text size/font
		
		g.drawString("Your turn", x, y); //Note: It was easier to just use two separate msgs.
		
		if(currentPlayer == 0)
		{
			g.setColor(Color.white);
			g.drawString("WHITE",x+23,y+26);
			g.setColor(Color.black);
		}
		else
		{
			g.setColor(Color.RED);
			g.drawString("RED",x+33,y+27);
			g.setColor(Color.black);
		}
		
	}
	
	public void setSize(int x,int y)
	{
		p.setSize(x,y);
	}
	
}
