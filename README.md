# STUDENT-LOGIN-SYSTEM
It store student information in Qracle database. We can change a user Password by using its email developed using java window programming and jdbc


  this project contain 3 packages 
  
    1) main_Frame(package) it contain the following class 
	                   -->Main_Frame (class)
				
	2) new_user(packager)
	                   --> New_User(class)
				
    
	3) existing_user(packager)
	                   --> Existing_user(class)
                       --> Profile(class)
	                   --> To_change_Password(class)
	                   -->Write_New_Password(class)
				
				
	our main class is main_Frame class when we run this it ask user if user is a new_user or a
	existing one according to user response our next frame open
	
	if user click on new_user then new_user class will execute and if user click on existing_user
    then existing_user class will be execute.

     Now if new_user frame execute then it ask the user to fill the details like  name
	                                                                              e_mail
	                                                                              contact NO
																				                                        dob
																				                                        password
																				                                        confirm password
																				  
	After providing all the detail if you enter same password and confirm password then your details
	will be saved in the database otherwise you will get an error.
	
	If you are a existing_user then you have two option either you can 
	                                                                 1) login into the system
																	                                 2) can change your password
																	 
	If you login in your system by providing e_mail and password then first of all details
	will be match from the database and if found the your profile section will be opened by executing
	the profile(class) otherwise it will prompt you to enter correct email and password.
	
	if user click to foget password the a new window open To_change_Password(class)
	it ask user to enter its email . if email is found in our database then then a new class execute
	Write_New_Password(class) otherwise we get error "wrong email".
    
	As now in the Write_New_Password(class) user have to write its new password and confirm password
	and it check the both password and confirm password if found same the it change the user password
	and that frame will be destroyed and login page/frame will get opened.
	
     








	 
