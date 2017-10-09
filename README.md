This is a sample HelloWorld project for Google App Engine Standard 
environment using Java8, Gradle, Lombok  

If you don't have gradle installed, or your gradle version is too old, 
use `gradlew.bat` (Windows) or `./gradlew` (MacOS\Linux) instead of "gradle" in commands below

Pre-requirements for deployment to Appengine:  
* Have Google Cloud SDK installed  
* Have at least one project created in your cloud account  
* Have configured project with `gcloud init`  
* For verification scripts - Linux\MacOS with curl installed. 

Run locally: `gradle appengineRun` 
Verify local: `./verify_local.sh`

Run tests: `gradle test`

Deploy: `gradle appengineDeploy`  
Verify deployment (note: set your project ID in script before running): `./verify_gae.sh`
