# Backbase Assignment - bank-transaction-services

This application provide a RESTful API that retrieve transactions from OpenBank sandbox and transforms the data using follwoing API.

Application having below three Rest endpoints:
#### Get All Transactions:  Get all transaction of account, Acccount id can be provided.

<http://localhost:8080/bank-transaction-services/rs/v1/current-accounts/transactions?accountId=savings-kids-john>

#### Get All Transactions for TransType:  Get all transaction of account by specific transaction type, Acccount id and transaction type can be provided.

<http://localhost:8080/bank-transaction-services/rs/v1/current-accounts/transactionsbytype?transType=SANDBOX_TAN&accountId=savings-kids-john>
 
#### Get Total Amount for TransType: Get total amount of specefic transaction type of account, Acccount id and transaction type can be provided.

<http://localhost:8080/bank-transaction-services/rs/v1/current-accounts/transaction/total-amount?transType=SANDBOX_TAN&accountId=savings-kids-john>



## For this assignment I have used following tools and technologies

 Java 1.8
 Spring 4.2.1 RELEASE
 Spring Security 4.0.3.RELEASE
 Apache Camel 2.12.4
 Tomcat 8
 Maven 4
 Swagger2
 Junit 4


## Build, Deployment & Sanity testing Steps:

1. Get the code from my public GIT hub repository >> https://github.com/Roshan-Xebia/bank-transaction-services
2. To get the war do “mvn clean install”  or "mvn tomcat:run" (skip step 3 and 4)
3. Deploy the generated war to tomacat container
4. Start the tomcat server
5. Access the above mentioned endpoints or you can access the endpoint from index page "http://server_host:port/bank-transaction-service"
6. Provide the user details in below mentioned table, I have implemented authentication and authorization to access these endpoints.
   "ROLE_USER" users only able to access all endpoints if other role of user(like ROLE_ADMIN) try to access it will return appropriate      error.
    
    | User Name  | Password  |   User Role            |
    | -----------| --------- | ---------------------  |
    | rrjuser    | rrj!nd1a  | ROLE_USER, ROLE_ADMIN  |
    | rrjadmin   | rrj!nd1a  | ROLE_USER |
    | rrj        | rrj!nd1a  | ROLE_USER |
    
## Assumption 

Acount Id and Transaction Type value will not be "N".

## Limitation

userDetailsService: all user details are defind (hard-code) in contex file and it will be not suitable for production.

## Swagger 

Provided the YAML file for swagger documnetation i.e. bank-transaction-services-swagger.yaml

