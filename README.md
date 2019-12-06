# selenium-java-framework
Architecture for using Selenium with Java

### Executing the tests by command line:
* To execute the tests, specifying which browser do you want execute, use the following command:
    > mvn clean install -Dbrowser=chrome
    
(Obs: It's not necessary to use the testng.xml file, after configuring using maven)

* To start the selenium grid, using docker-compose file, execute the following comand:
> docker-compose up -d

* after that you can execute your tests remotely in containers