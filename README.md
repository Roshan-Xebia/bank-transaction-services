# Backbase Assignment - bank-transaction-services

This application provide a RESTful API that retrieve transactions from OpenBank sandbox and transforms the data using follwoing API.

This application expose three endpoints:
#### Transactions list:  Get all transaction of account, Acccount id can be provided.

<http://localhost:8080/bank-transaction-services/rs/v1/current-accounts/transactions?accountId=savings-kids-john>

#### Transaction filter based on transaction type:  Get all transaction of account by specific transaction type, Acccount id and transaction type can be provided.

<http://localhost:8080/bank-transaction-services/rs/v1/current-accounts/transactionsbytype?transType=SANDBOX_TAN&accountId=savings-kids-john>
 
#### Total amount for transaction type: Get total amount of specefic transaction type of account, Acccount id and transaction type can be provided.

<http://localhost:8080/bank-transaction-services/rs/v1/current-accounts/transaction/total-amount?transType=SANDBOX_TAN&accountId=savings-kids-john>



## Tools and Skills

Java, Spring, Apache Camel, Junit, Maven


## Build

mvn clean install


## Run

You can run this app on any container, once its up you will visit index page,

<http://localhost:8080/bank-transaction-service>

Where you will get the API details, also you can access this api's from this page and verify using custom form to provide parameter values account id and transaction type.


## Swagger 

Provided the YAML file for swagger documnetation i.e. bank-transaction-services-swagger.yaml
