This application provides all Customers Information

Pre Requisites : Java 19 and Gradle 7.6

Installation:

docker run --name postgresql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=123456789 -p 5432:5432 -d postgres
docker run --name pgadmin -e PGADMIN_DEFAULT_EMAIL=XXXX@gmail.com -e PGADMIN_DEFAULT_PASSWORD=123456789 -p 5050:5050 -d dpage/pgadmin4

Used topics:
1.Http all Requests
2.Form Validations
3.PathVariable Validations
4.H2 db by setting up all required info in application.yml variables
5.Used Global Exception handler
6.docker images

------------------------------------------------------------------------------------------------------------------------------------------
Docker build:
step 1: goto below url and run './gradlew clean build'
D:\MyWork\Intellij-projects\spring-boot-docker-kubernetes
step 2: run the command 'docker build -f ./docker-images/Dockerfile -t spring-boot-docker-kubernetes:latest .'
step 3: execute the command 'kubectl apply -f ./kubernetes/deployment.yaml'
step 4: execute the command 'kubectl apply -f ./kubernetes/service.yaml'

some of docker commands:
-> docker -–version
-> docker images
-> docker run [image id]
-> docker ps
-> docker stop [container id]
-> docker kill [container id]
-> docker rm [container id]
-> docker login
-> docker push
-> docker build -f [folder path where we have docker file] -t [name for repository:tag] 


------------------------------------------------------------------------------------------------------------------------------------------
All Services Request URLS & Body

Post:
URL:- http://localhost:1001/customer-register/customer/addCustomer
Body:-
{
	"customerId": "12345678",
	"customerName": "SonuNigum",
	"customerDOB": "2015-01-09",
	"phoneNumber": 1234567899,
	"email": "s.s@gmail.com",
	"password": "12345678",
	"addresses": [
		{
			"addressType": "Permanent",
			"flatNumber": "101",
			"plotNumber": "102",
			"buildingName": "31",
			"roadNumber": 124578,
			"street": "ss",
			"city": "Telangana",
			"country": "India",
			"pinCode": 500036
		}    ]
}

Get:
URL:- http://localhost:1001/customer-register/customer/getCustomer/12345678

Get All:
URL:- http://localhost:1001/customer-register/customer/getAllCustomers

Put:
URL:- http://localhost:1001/customer-register/customer/updateCustomer
Body:-
{
	"customerId": "12345678",
	"customerName": "Sonu Nigum",
	"customerDOB": "2015-01-09",
	"phoneNumber": 1234567899,
	"email": "s.s@gmail.com",
	"password": "87951",
	"addresses": [
		{
			"addressType": "Permanent",
			"flatNumber": "101",
			"plotNumber": "102",
			"buildingName": "31",
			"roadNumber": 124578,
			"street": "ss",
			"city": "Telangana",
			"country": "India",
			"pinCode": 500036
		}    ]
}

Delete:
URL:- http://localhost:1001/customer-register/customer/deleteCustomer/12345678

h2 Database Console:
URL:- http://localhost:1001/customer-register/h2-console

------------------------------------------------------------------------------------------------------------------------------------------