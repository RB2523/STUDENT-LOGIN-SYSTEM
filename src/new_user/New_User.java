package new_user;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class New_User extends Frame implements ActionListener
{
	Label name ;               TextField tf_name ;
	Label e_mail;              TextField tf_e_mail ;
	Label contact_no;          TextField tf_contact_no ;
	Label dob;                 TextField tf_dob ;
	Label password;            TextField tf_password ;
	Label confirm_password;    TextField tf_confirm_password ;
	
	Label status ;
	Button submit;
	
	Connection conn ;
	Statement stmt;
	
	public New_User()
	{
				
		setVisible(true);             // setting visibility of frame
		setBounds(100,100,500,500);  // set custom location of frame
		setLayout(null);            // setting layout of frame
	
//  Label components		
		name              = new Label("Enter Name");
		e_mail            = new Label("Enter E_mail");
		contact_no        = new Label("Enter Contact_no");
		dob               = new Label("Enter D.O.B");
		password          = new Label("Enter Password");
		confirm_password  = new Label("Confirm Password");
		 
		  status  = new Label("Password did not Match",Label.CENTER);
		  
//  TextField components		
		tf_name         = new TextField(20);
		tf_e_mail       = new TextField(20);
		tf_contact_no   = new TextField(20);
		tf_dob          = new TextField(20);
		tf_password     = new TextField(20);
		tf_confirm_password  = new TextField(20);
		
		
// Button component
		submit = new Button("Submit");
		
// adding component to frame		
       add(name);                 add(tf_name);          add(submit);
       add(e_mail);               add(tf_e_mail);        add(status);
       add(contact_no);           add(tf_contact_no);
       add(dob);                  add(tf_dob); 
       add(password);             add(tf_password); 
       add(confirm_password);     add(tf_confirm_password);
      
       
// setting custom size and location of components      
   name.setBounds(50,50,170,30);                tf_name.setBounds(240,50,200,30);
   e_mail.setBounds(50,110,170,30);             tf_e_mail.setBounds(240,110,200,30);
   contact_no.setBounds(50,170,170,30);         tf_contact_no.setBounds(240,170,200,30);
   dob.setBounds(50,230,170,30);                tf_dob.setBounds(240,230,200,30);
   password.setBounds(50,290,170,30);           tf_password.setBounds(240,290,200,30);
   confirm_password.setBounds(50,350,170,30);   tf_confirm_password.setBounds(240,350,200,30);
       
   submit.setBounds(200,410,100,30);
   status.setBounds(20,450,460,30);
   
//to hide the password while typing the password
      tf_password.setEchoChar('*');
      tf_confirm_password.setEchoChar('*');
     
// to provide custom Font to components   
     Font f = new Font("Arial", Font.BOLD , 18);
  
     name.setFont(f);              tf_name.setFont(f);
     e_mail.setFont(f);            tf_e_mail.setFont(f);
     contact_no.setFont(f);        tf_contact_no.setFont(f);
     dob.setFont(f);               tf_dob.setFont(f);
     password.setFont(f);         tf_password.setFont(f);
     confirm_password.setFont(f);      tf_confirm_password.setFont(f);
     
     status.setFont(f);
     submit.setFont(f); 
     submit.addActionListener(this);
     
// it hide the visibility of status label
     status.setVisible(false);
     
     try
     {   
    	 // for explicit loading of class
    	 Class.forName( "oracle.jdbc.driver.OracleDriver");
    	 
    	 // to establish connection between our application and database
    	conn   = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345" );
    	 
    	//to execute query
    	stmt = conn.createStatement();
 
    	 
    /* below statement is run for only one time to create table in database*/	
    	 
     //stmt.executeQuery(" create table Student( name char(20) , email char(20) , contact_no number(10) , dob char(20), password char(15) )");
    	 
    	 
     }catch(Exception e)
     {
    	e.printStackTrace();
    	  
     }
     
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == submit)
		{
			String p = tf_password.getText().trim();
			String p2  = tf_confirm_password.getText().trim();
			
			if(p.equals(p2))
			{
				try
				{
		/*if both password and re_enter password are same the we enter 
		 * the data in the database table
		 * */
					
	//these statement are used to insert data form application to database				
	String insert = "insert into Student values('"+tf_name.getText()+"' ,'"+ tf_e_mail.getText()+"' , "+tf_contact_no.getText()+" , '"+tf_dob.getText()+"', '"+tf_password.getText()+"' )";
	stmt.executeUpdate(insert);
					
					status.setText("Your details have been submitted");
					status.setBackground(Color.yellow); // custom background color
					status.setVisible(true); 
				}catch(Exception ee)
				{
					ee.printStackTrace();
				}
				
				
			}
			else
			{
				//show password incorrect when you entered wrong password
				status.setText("Password did not Match");
				 status.setBackground(Color.red);
				status.setVisible(true);
				 
			}
		}
		
		
		
	}
}
