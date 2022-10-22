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

How is the Tax Calculation Done ? Point to remember is that Tax is always calculated on Net price.

1) grossPrice = netprice + Tax% * netPrice;
2) netprice = grossPrice(1 + 0.01 * Tax)

Take an example here
1) Gross price : 119
2) Tax on net price for Germany (DE) : (19% = 0.19)
3) Net price : 100
4) Formula will be grossPrice/ (1 + (19% = 0.19))

