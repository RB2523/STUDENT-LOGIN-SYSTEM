package existing_user;

import java.awt.*;

public class Profile extends Frame
{
	Label banner;
	
	Label name ;
	Label e_mail ;
	Label contact_no ;
	Label dob ;
	
	public Profile(String nm , String email , Long contact , String dob_)
	{
		setVisible(true);
		setLayout(null);
		setBounds(100,100,500,500);

//component (label)
		name         = new Label();
		e_mail       = new Label();
		contact_no   = new Label();
		dob          = new Label();
	
//customize the size and location of components		
		name.setBounds(20,120,200,40);
	    e_mail.setBounds(20,190,290,40);
	    contact_no.setBounds(20,260,200,40);
        dob.setBounds(20,330,200,40);
        
		banner = new Label("Welcome",Label.CENTER);
		
		banner.setBounds(20,40,460,50);
		
		banner.setBackground(Color.yellow);	
		      
//adding components to frame         
	        add(name);              add(e_mail);     add(banner);     
	  		add(contact_no);        add(dob);
	                  

//inserting the userdata which come from database via constructor in the specified label
	  		name.setText(nm);
	  		e_mail.setText(email);
	  		contact_no.setText(String.valueOf(contact));
	  		dob.setText(dob_);
	  	
//customize the font of the components
			Font f = new Font("Arial" , Font.BOLD,30);
			banner.setFont(f);
	  		name.setFont(f);
	  		contact_no.setFont(f);
	  		e_mail.setFont(f);
	  		dob.setFont(f);
	}

}
