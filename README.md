#Food Management and Strategy Platform#

##Abstract##

The food management and strategy platform is a business level platform. Shopping mall such as Safeway uses this platform to track products expiration date and query products at any time so they can make options to deal with these products. It's an efficient way to avoid food wasting at the same time helping shopping mall gain a good reputation.

##Project Environment and Run##

Bootstrap + jQuery + Ajax + Spring MVC + MongoDB

Run:

Open Intellij

Import, select pom.xml

Run it on tomcat


##Database Design##

>AccountInfo {

    String id
    String email
    
}

>Food {

    private int rowID;
    private String productName;
    private String expirationDate;
    private double discount;
}

>Rule {

    int daysBefore; // days before expiration
    String action;
}

>Notification {

    Food food;
    Rule rule;
}

>Registration {

    "/register", method = RequestMethod.POST;
    http://localhost:8080/register?name=user1&password=user1;
    return	return user's accountInfo;

}

>Food List {

    "/food/", method = RequestMethod.GET
    get all the food

    "/food/expired", method = RequestMethod.GET
    get all the food that will expire within 3 weeks

    "/food/expired/{days}", method = RequestMethod.GET
    days: 21, 14, 7
    21: get all the food that will expire from 2 weeks later to 3 weeks later
    14: get all the food that will expire from 1 week later to 2 weeks later
    7: get all the food that will expire within 1 week
    
}

>Set strategy {

    "/food/expired/{days}/{discount}", method = RequestMethod.POST
    days: 21, 14, 7
    21: get all the food that will expire from 2 weeks later to 3 weeks later
    14: get all the food that will expire from 1 week later to 2 weeks later
    7: get all the food that will expire within 1 week
    discount: 9: 90 % OFF,  1: 10 % OFF, -1: Donated
    return "SUCCESS", "FAIL"

    "/food/analysis/donation", method = RequestMethod.GET
    {
    "years": [
    "2015",
    "2016",
    "2017",
    "2018",
    "2019"
   ],
    "numbers": [
    1838,
    1749,
    1846,
    0,
    0
    ]
    }

    "/food/analysis/discount/top", method = RequestMethod.GET
    [
    {
    "disCountMsg": "1 % OFF",
    "count": 800
    },
    {
    "disCountMsg": "5 % OFF",
    "count": 782
    },
    {
    "disCountMsg": "3 % OFF",
    "count": 774
    },
    {
    "disCountMsg": "9 % OFF",
    "count": 774
    },
    {
    "disCountMsg": "4 % OFF",
    "count": 766
    }
    ]

    "/food/analysis/discountstat", method = RequestMethod.GET
    [
    {
    "year": "2015",
    "off10": 155,
    "off50": 0,
    "donation": 0
    },
    {
    "year": "2016",
    "off10": 166,
    "off50": 0,
    "donation": 0
    },
    {
    "year": "2017",
    "off10": 172,
    "off50": 0,
    "donation": 0
    },
    {
    "year": "2018",
    "off10": 0,
    "off50": 0,
    "donation": 0
    },
    {
    "year": "2019",
    "off10": 0,
    "off50": 0,
    "donation": 0
    
    }
    ]
