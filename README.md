## IMDB tests automation

### 1. Description of project
1. Project contains auto tests for https://www.imdb.com/chart/top.

### 2. Running tests
1. WebDrivers for Chrome and FireFox set up automatically by https://github.com/bonigarcia/webdrivermanager
2. Cross-browser testing. Supported browsers: Chrome, FireFox. Browser can be set in *GlobalData.json* file.
3. Link to testing environmen can be set in *GlobalData.json* file.
4. Tests can be run with TestNG by running xml Test file from IDE.
5. Tests can be run with Maven by command: **mvn clean test -PRegression** (All tests from  _IMDbSuiteTest.xml_ to be executed), 
where the default value for Genre is Western, but also can be set from cli as : **mvn clean test -PRegression -Dgenre=Sport** 
