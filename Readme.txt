Project Details :

    Spring boot Rest API project
    H2 database
    Tomcat Server

Tools & Libraries used:

    Eclipse IDE
    Swagger documentation
    SonarQube for testing
    Postman Client for Request
    ORM technologies like Hibernate is used for mapping object to database table
    Junit 5 for Test cases
    Swagger OpenAPI library used for documentaion


H2 Database Setup : database url: localhost:8080/h2-console/

Credentials 
username :user 
password :pass 
schemaname : powersystemdb

All configuration is in (application.properties) file.

Project API Endpoints : Save Battery Information :-

Http Method : POST Endpoint : http://localhost:8080/api/v1/save

Request Body Data: [

[
    {
        "id":1,
      "name": "Lithium Ion Battery",
      "postcode": 6733,
      "capacity": 5000
    },
    {
        "id":2,
      "name": "Lead Acid Battery",
      "postcode": 2084,
      "capacity": 7500
    },
    {
                "id":3,
     "name": "NiMH Battery",
    "postcode": 6700,
      "capacity": 8500
    },
    {
                "id":4,
      "name": "AGM Battery",
      "postcode": 7800,
      "capacity": 9700
    }
]

API Response :


[
    {
        "id": 1,
        "name": "Lithium Ion Battery",
        "postcode": 6733.0,
        "capacity": 5000.0
    },
    {
        "id": 2,
        "name": "Lead Acid Battery",
        "postcode": 2084.0,
        "capacity": 7500.0
    },
    {
        "id": 3,
        "name": "NiMH Battery",
        "postcode": 6700.0,
        "capacity": 8500.0
    },
    {
        "id": 4,
        "name": "AGM Battery",
        "postcode": 7800.0,
        "capacity": 9700.0
    }
]


Retrieve Battery Information By PostCode Range :

HTTP Method : GET Endpoint Url : http://localhost:8080/api/v1/range/{postcodemin}/{postcodemax}

{postcodemin} ->Minimum postcode range to be selected {postcodemax} -> Maximum postcode range to be selected

API Response : [BatteryInfoDTO(id=1, name=Lithium Ion Battery, postcode=6733.0, capacity=5000.0), BatteryInfoDTO(id=3, name=NiMH Battery, postcode=6700.0, capacity=8500.0)]Total Watt : 13500.0Average Watt :6750.0
Github Repository Link: https://github.com/Amit-Dhakal/VirtualPowerPlant

Swagger Documentation Link : localhost:8080/v1/VirtualPowerSystem

Security Basic Authentication:
username :admin
password :password



SonarQube : Url : http://localhost:9000/

SonarQube credentials : username : admin password : pass

Maven Plugin : clean org.jacoco:jacoco-maven-plugin:prepare-agent install

Token : sonar:sonar -Dsonar.login=squ_51393e43a0582f74dc41621b74bdab608c0cae4e