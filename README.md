# selenium-java-architecture-setup
Architecture setup for using Selenium with Java

### Executing the tests by command line:
* To execute the tests, specifying which browser do you want execute, use the following command:
` mvn clean install -Dbrowser=chrome `

### Executing the tests using selenium-grid:

* To start the selenium grid, using docker-compose file, execute the following comand:
` docker-compose up -d `

* Afterward you can execute your tests remotely in containers:
` mvn test `

### Test Reporting

This project is configured to create reports with allure reporting. After executing the tests, 
it generates resources in the folder target/allure-results.

You can install Allure with just a few commands. For instructions of how to install 
for your operating system, visit the following [link](https://docs.qameta.io/allure/#_installing_a_commandline)

To generate the visual allure report, execute the following command:

` allure serve target/allure-results `

or 

` allure generate target/allure-results -o target/allure-report `

The serve command generate the report in a temp folder, while the generate command created it permanently into the target/allure-report folder

One of the interesting features of Allure Report is that you can build the report, not only with the last test execution data, but with the historical data from the past execution. By this way, it has some features, like for example, automatically tag as "broken", tests that has failed many times, or tag as "flaky", tests that has failed sometimes and passed sometimes. Also, it can be integrated with pipeline tools, like Jenkins.

To write the environment variables into the report, I used this [library](https://github.com/AutomatedOwl/allure-environment-writer)

