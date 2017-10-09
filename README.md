This is a sample HelloWorld project for Google App Engine Standard 
environment using Java8, Servlet API v3, Gradle, Lombok  

If you don't have gradle installed, or your gradle version is too old, 
use `gradlew.bat` (Windows) or `./gradlew` (MacOS\Linux) instead of "gradle" in commands below

Pre-requirements for deployment to Appengine:  
* Have Google Cloud SDK installed  
* Have at least one project created in your cloud account  
* Have configured project with `gcloud init`  

Run locally:  
`gradle appengineRun`

Run tests:  
`gradle test`

Deploy:  
`gradle appengineDeploy`

