DataPoint
{
	String name;
	double timeStamp;
	double temperature;
	double bloodpressure;
	int heartrate;
}
AccountInfo {
	String name
	String password
	int credit
}
Usage {
	int dataCount;
	int credit;
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

User get data
"/user/getdata", method = RequestMethod.GET
return List<DataPoint> sorted by timestamp

User get abnormal data
"/user/getabnormaldata", method = RequestMethod.GET
return List<DataPoint> sorted by timestamp

Admin get data
"/admin/getdata", method = RequestMethod.GET
return Map<String, List<DataPoint>>: key is username, value is user data list

Admin get data
"/admin/getabnormaldata", method = RequestMethod.GET
return Map<String, List<DataPoint>>: key is username, value is user data list

User get usage
"/user/getusage", method = RequestMethod.GET
return Usage: user's usage contains both credit and usage

Admin get usage
"/admin/getusage", method = RequestMethod.GET
return Map<String, Usage>:key is username, value is user's usage

User top up
"/user/topup", method = RequestMethod.POST
return user's usage