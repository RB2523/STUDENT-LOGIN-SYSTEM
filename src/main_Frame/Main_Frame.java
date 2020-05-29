package main_Frame;

import java.awt.*;
import java.awt.event.*;

import existing_user.Existing_user;
import new_user.New_User;

public class Main_Frame extends Frame implements ActionListener
{
	Button btn_new ;
	Button btn_existing ;
	 
	Main_Frame()
	{
		
// component (buttons)
		btn_existing  = new Button("Existing User");
		btn_new = new Button("New User");
		
// setting frame layout to null	
		setLayout(null);
		
// adding components to frame	
		add(btn_new); 
		add(btn_existing);
		
// customize the size of and location of components		
		btn_new.setBounds(100,100,100,50);
		btn_existing.setBounds(100,200,100,50);
	
// setting the size and location of frame		
		setLocation(100,100);
		setSize(300,300);
		
//setting visibility of frame		
		setVisible(true);
		
// pairing the button with action listener which responds to action events
		  btn_new.addActionListener(this);
		  btn_existing.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	// according to button pressed we see different frame	
		if(e.getSource() == btn_new)
		{
			New_User obj = new New_User();
		}
		else
		{
		    new Existing_user();
		}
	}
	
	public static void main(String args[])
	   {
		  Main_Frame obj = new Main_Frame(); 
	   }
}
