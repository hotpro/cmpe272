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
    private int rowID;

    private String productName;

    private String expirationDate;

    private double discount;
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

Food List
"/food/", method = RequestMethod.GET
get all the food

"/food/expired", method = RequestMethod.GET
get all the food that will expire within 3 weeks

"/food/expired/{days}", method = RequestMethod.GET
days: 21, 14, 7
21: get all the food that will expire from 2 weeks later to 3 weeks later
14: get all the food that will expire from 1 week later to 2 weeks later
7: get all the food that will expire within 1 week


Set strategy
"/food/expired/{days}/{discount}", method = RequestMethod.POST
days: 21, 14, 7
21: get all the food that will expire from 2 weeks later to 3 weeks later
14: get all the food that will expire from 1 week later to 2 weeks later
7: get all the food that will expire within 1 week
discount: 9: 90 % OFF,  1: 10 % OFF, -1: Donated

return "SUCCESS", "FAIL"

"/food/analysis/donation"
{
    years:["2015", "2016", "2017", "2018", "2019"],
    numbers:[1000, 800, 900, 700, 500]
}

"/food/analysis/discount/top"
{
    top5discount:["90 % OFF", "20 % OFF", "70 % OFF", "40 % OFF", "50 % OFF", ],
    numbers:[1000, 900, 800, 700, 500]
}

"/food/analysis/discount/history"
// Area Chart
    Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2015',
            iphone: 2666,
            ipad: null,
            itouch: 2647
        }, {
            period: '2010 Q2',
            iphone: 2778,
            ipad: 2294,
            itouch: 2441
        }, {
            period: '2010 Q3',
            iphone: 4912,
            ipad: 1969,
            itouch: 2501
        }, {
            period: '2010 Q4',
            iphone: 3767,
            ipad: 3597,
            itouch: 5689
        }, {
            period: '2011 Q1',
            iphone: 6810,
            ipad: 1914,
            itouch: 2293
        }, {
            period: '2011 Q2',
            iphone: 5670,
            ipad: 4293,
            itouch: 1881
        }, {
            period: '2011 Q3',
            iphone: 4820,
            ipad: 3795,
            itouch: 1588
        }, {
            period: '2011 Q4',
            iphone: 15073,
            ipad: 5967,
            itouch: 5175
        }, {
            period: '2012 Q1',
            iphone: 10687,
            ipad: 4460,
            itouch: 2028
        }, {
            period: '2012 Q2',
            iphone: 8432,
            ipad: 5713,
            itouch: 1791
        }],

