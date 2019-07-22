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

1. Get the code from my public GIT hub repository >> 
2. To get the war do “mvn clean install”
3. Deploy the generated war to tomacat container
4. Start the tomcat server
5. Access the above mentioned endpoints or you can access the endpoint from index page "http://server_host:port/bank-transaction-service"
6. Provide the user as ”rrj” and password as “rrj!nd1a”


## Swagger 

Provided the YAML file for swagger documnetation i.e. bank-transaction-services-swagger.yaml

