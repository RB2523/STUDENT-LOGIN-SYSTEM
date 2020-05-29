package existing_user;

	import java.awt.*;
	import java.awt.event.*;
	import java.sql.*;

public class Write_New_Password extends Frame implements ActionListener
{
	
		Label confirm_password;            TextField tf_confirm_password ;
		Label password ;                   TextField tf_password ;
		
		Button change;
		
		Connection conn ;
		Statement stmt;
		
		String db_email;
		
		public Write_New_Password(String email)
		{
			db_email = email;
			
			setVisible(true);
			setBounds(100,100,500,350);
			setLayout(null);

// components (Label)
			password          = new Label("Enter Password");
			confirm_password  = new Label("Confirm Password");		
		
//components (TextField)	
			tf_password            = new TextField(20);
			tf_confirm_password    = new TextField(20);	
			
//component (Button)
			change = new Button("Change");  
			 
// provided custom location and size
			 password.setBounds(50,50,170,30);            tf_password.setBounds(240,50,200,30);
			 confirm_password.setBounds(50,110,170,30);   tf_confirm_password.setBounds(240,110,200,30);
			 
			 change.setBounds(300,200,100,50);
			 
// adding components in frame
			   add(password);             add(tf_password);       add(change);
		       add(confirm_password);     add(tf_confirm_password);      
		      
// use font class object to provide custom font
		       Font f = new Font("Arial", Font.BOLD , 18);
		       
		      confirm_password.setFont(f);       tf_confirm_password.setFont(f);
		      password.setFont(f);              tf_password.setFont(f);
		      change.setFont(f);                
		   
//to hide our password
		       tf_password.setEchoChar('*');
		       tf_confirm_password.setEchoChar('*');
		       
		       try
		       {
		      	 Class.forName( "oracle.jdbc.driver.OracleDriver"); // explicit loading of class
		      
		      	/* connection class is used to maintain connection between 
			       * java program and database software
			       * */
		      conn   = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345" );
		      
		      
		      stmt = conn.createStatement();  // statement object is created to execute and update query 	       
		      	 
		       }catch(Exception e)
		       {
		      	e.printStackTrace();
		      	  
		       }
		       
 // pairing the button with action listener which responds to action events       
		       change.addActionListener(this);
		      
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == change)
			{
				String password = tf_password.getText().trim();  // it store the text from the TextField to variable user_mail 
				String confirm_password = tf_confirm_password.getText().trim(); //     it also store TextField data into variable
				
				
				if(  password.equals(confirm_password)  )
				{
					
					try
					{
	       String update = "update Student Set password = '"+password+"' where email = '"+db_email+"'";	
			
				      
				   stmt.executeQuery(update);      
				    
				     this.dispose();
				     new Existing_user();
				      
					}catch(Exception ee)
					{
						ee.printStackTrace();
					}
				}
				else
				{
					tf_password.setText("Password do not match");
				}
				
				
			}
			
		}

	}
