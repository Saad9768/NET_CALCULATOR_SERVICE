# NET_CALCULATOR_SERVICE

The Service will return net price of respective country provided with gross amount.

Run the service.
1) Clone the repo.
2) Run mvn clean package to generate jar file
3) java -jar 'path to the jar file'

Have a look at the swagger 
1) UI: http://localhost:8080/swagger-ui.html
2) Docs: http://localhost:8080/v2/api-docs

Details about the calculator service

For example 

1) Gross price : 119
2) Tax on net price for Germany (DE) : 19% (0.19)
3) Net price : 100
4) Formula will be 119/1.19 = 100
