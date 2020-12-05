# avi-contact-repository-api
Avi contact repository is a spring boot rest api build for maintaining the contact repository,
 in which user can add, delete, edit, inactive, get the contacts.
 
These are few functionality of this API and their respective end points :
- Get Contact by ID : <host>:<port>/contacts/<ID>
- Get List of contacts : <host>:<port>/contacts
- Put a contact : <host>:<port>/contacts/put/<ID> {Request contains a json of contact object to be added}
- Edit existing contact : <host>:<port>/contacts/put/<ID> {Request contains a json of contact object to be edit}
- Delete a contact : <host>:<port>/contacts/delete/<ID>
- Inactive a contact : <host>:<port>/contacts/inactive/<ID>

Sample JSON request : 

	{
        "id": 12,
        "fName": "Avinash",
        "lName": "Jain",
        "email": "avi@gmail.com",
        "phone": "1234567890",
        "status": "Active"
    }


Technology stack : Spring boot, Hibernate, JPA, JAVA 8, Maven, Postman (To run the API), Eclipse IDE, GIT

Folder structure : src/main/java
						com.avi
							controller -> front rest controller class
							model -> JPA entity pojo class
							repository -> Crud repository class
					src/main/resources
						Application.properties -> port no
					Pom.xml -> contains artifact id, dependencies and plugin
					
Instructions to run the application :
			Git clone application
			Import in to Eclipse (or whatever you like)
			Convert to maven project
			Right click project -> Maven -> update project
			clean
			install
			build
			Go to AviApplication
			Right click on main method
			Run as JAVA application (or spring boot app)
			Use above instructed endpoints to access different services of the API
			Happy coding :)
			
			

