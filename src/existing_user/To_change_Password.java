package existing_user;

	import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class To_change_Password extends Frame implements ActionListener
{
	

		Label e_mail;            TextField tf_e_mail ;
		
		Button submit;
		
		Connection conn ;
		Statement stmt;
		ResultSet rs;
		
		public To_change_Password()
		{
// Frame methods
			setVisible(true);
			setBounds(100,100,500,350);
			setLayout(null);

// components (Label)
			e_mail   = new Label("Enter E_mail");
		
//components (TextField)		
			tf_e_mail    = new TextField(20);
			
			
//component (Button)
			submit = new Button("Submit");  
			
			 
// provided custom location and size
			 e_mail.setBounds(50,50,170,30);            tf_e_mail.setBounds(240,50,200,30);
			  submit.setBounds(200,170,100,50);
			  
			 
 // adding components in frame
			  add(submit);    add(e_mail);               add(tf_e_mail);        
		      
 // use font class object to provide custom font
		       Font f = new Font("Arial", Font.BOLD , 18);
		       
		       e_mail.setFont(f);            tf_e_mail.setFont(f);
		       submit.setFont(f);                 
		       
		       try
		       {
		      	 Class.forName( "oracle.jdbc.driver.OracleDriver"); // explicit loading of class
		      
		      conn   = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345" );
		      /* connection class is used to maintain connection between 
		       * java program and database software
		       * */
		      
		      stmt = conn.createStatement();  
		      // statement object is created to execute and update query 
		       
		      	 
		       }catch(Exception e)
		       {
		      	e.printStackTrace();
		      	  
		       }
		       
// pairing the button with action listener which responds to action events       
		      submit.addActionListener(this);
		       
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == submit)
			{
                String user_mail = tf_e_mail.getText();	
                
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
    		    	  String db_email =  rs.getString(2).trim();
    		    	  System.out.println(db_email);
    		    	  
    		    	  if(db_email.equals(user_mail.trim()))
    		    	  {
    		   
    		    		  new Write_New_Password(db_email);
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
			
			
		}

	}

