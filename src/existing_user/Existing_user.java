package existing_user;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Existing_user extends Frame implements ActionListener
{
	Label e_mail;            TextField tf_e_mail ;
	Label password ;         TextField tf_password ;
	
	Button login;
	Button forget_password;
	
	Connection conn ;
	Statement stmt;
	ResultSet rs;
	
	public Existing_user()
	{
		
		setVisible(true);
		setBounds(100,100,500,350);
		setLayout(null);

// components (Label)
		e_mail   = new Label("Enter E_mail");
		password    = new Label("Enter Password");
	
//components (TextField)		
		tf_e_mail    = new TextField(20);
		tf_password      = new TextField(20);
		
//component (Button)
		 login = new Button("Login");  
	    forget_password = new Button("Forget Password");
		 
// provided custom location and size
		 e_mail.setBounds(50,50,170,30);            tf_e_mail.setBounds(240,50,200,30);
		 password.setBounds(50,110,170,30);         tf_password.setBounds(240,110,200,30);
		 
		forget_password.setBounds(80,200,170,50);  login.setBounds(300,200,100,50);
		 
// adding components in frame
		   add(password);             add(tf_password);       add(login);
	       add(e_mail);               add(tf_e_mail);         add(forget_password);
	      
// use font class object to provide custom font
	       Font f = new Font("Arial", Font.BOLD , 18);
	       
	       e_mail.setFont(f);                tf_e_mail.setFont(f);
	       password.setFont(f);              tf_password.setFont(f);
	       login.setFont(f);                 forget_password.setFont(f);
	   
//to hide our password
	       tf_password.setEchoChar('*');
	       
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
	       login.addActionListener(this);
	       forget_password.addActionListener(this);    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		
		if(e.getSource() == login)
		{
			String user_mail = tf_e_mail.getText();  // it store the text from the TextField to variable user_mail 
			String password = tf_password.getText(); //     it also store TextField data into variable
			
			try
			{
		       String query = "select * from Student where email = '"+user_mail+"'";	
		      rs = stmt.executeQuery(query);
		      /*the above both instruction are used to retrieve data from the 
		       * database whose email is provided by user_mail variable*/
		      
		      boolean check = rs.next();
		      /*if check is true it means rs(resultset object) have the desire
		       * data and if it is false it means in our database that email address 
		       * is not found*/
		      
		      if(check)
		      {
		    	  String db_password =  rs.getString(5);
		    	  
		    	  if(password.equals(db_password.trim()))
		    	  {
		               // now if password is correct we show user its profile 
		    		  new Profile(rs.getString(1) , rs.getString(2) , rs.getLong(3) ,rs.getString(4));
		    	  }
		    	  else
		    	  {
		    		  tf_password.setText("Wrong Password");
		    	  }
		      }
		      else
		      {
		    	  tf_e_mail.setText("Wrong Email");
		      }
		     
		      
			}catch(Exception ee)
			{
				ee.printStackTrace();
			}
					
			
			
		}
		else if(e.getSource() == forget_password)
		{
			new To_change_Password();
		}
		
	}

}
