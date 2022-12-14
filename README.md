# NET_CALCULATOR_SERVICE

The Service will return net price of respective country provided with gross amount.

Run the service.
1) Clone the repo.
2) Run mvn clean package to generate jar file
3) java -jar 'path to the jar file'
4) For development purpose if one want to start the application, One can start mvn spring-boot:run

How to use this service ?
Here is an example after you run the jar file
http://localhost:8080/v1/api/calculate/netamount?grossPrice=100.0&countryIso=DE

1) where 100 is the gross price
2) DE is country code
Response will be either success or Error
1) Success will give you the netPrice
2) Error will provide the appropriate Error with status code

Have a look at the swagger 
1) UI: http://localhost:8080/swagger-ui.html
2) Docs: http://localhost:8080/v2/api-docs

Details about the calculator service

How is the Tax Calculation Done ? Point to remember is that Tax is always calculated on Net price.

1) grossPrice = netprice + Tax% * netPrice;
2) netprice = grossPrice/(1 + 0.01 * Tax)

TaxRateProvider Enum will map the country tax with code. Currently only 3 countries are mapped.

Take an example here
1) Gross price : 119
2) Tax on net price for Germany (DE) : (19% = 0.19)
3) Net price : 100
4) Formula will be grossPrice/ (1 + (19% = 0.19))
