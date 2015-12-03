Bootstrap + Angular JS + Spring MVC + MongoDB

Open:
Open Intellij
Import, select pom.xml
Run it on tomcat

AccountInfo {
    String id
    String email
}

Food {
    String id;
    String name;
    long expiredDate;
    String discount;
}

Rule {
    int daysBefore; // days before expiration
    String action;
}

Notification {
    Food food;
    Rule rule;
}




Registration
"/register", method = RequestMethod.POST
http://localhost:8080/register?name=user1&password=user1
	return user's accountInfo

User Deregister
         /user/deregister", method = RequestMethod.DELETE
	when log in, user can directly delete his account from database
	void

Admin Deregister
"/admin/deregister/{name}", method = RequestMethod.DELETE
http://localhost:8080/admin/deregister/user1
void

Food List
"/food/", method = RequestMethod.GET

"/food/expired", method = RequestMethod.GET

"/food/expired/{days}", method = RequestMethod.GET

