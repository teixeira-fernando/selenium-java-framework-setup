# selenium-java-framework
Architecture for using Selenium with Java

### Executing the tests by command line:
* To execute the tests, specifying which browser do you want execute, use the following command:
    > mvn clean install -Dbrowser=chrome
    
(Obs: It's not necessary to use the testng.xml file, after configuring using maven)

* To start the selenium grid, using docker-compose file, execute the following comand:
> docker-compose up -d

* after that you can execute your tests remotely in containers

This project is configured to create reports with allure reporting. After executing the tests, 
it generates resources in the folder target/allure-results.

You can install Allure with just a few commands. For instructions of how to install 
for your operating system, visit the following link: https://docs.qameta.io/allure/#_installing_a_commandline

To generate the visual allure report, execute the following command:

> allure serve target/allure-results
