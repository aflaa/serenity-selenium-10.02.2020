Environment setup:

Download and install Java/JDK. http://www.oracle.com/technetwork/java/javase/downloads/index.html
Download and install Intelij Idea, Community version. https://www.jetbrains.com/idea/download/#section=windows
Create new java project with Maven. Project name should have the same name as ArtifactId.
Find and copy selenium maven settings to pom.xml in new tag Dependencies. https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
Download chromedriver.exe and copy it to System32 (or create Path in variables). https://chromedriver.storage.googleapis.com/index.html?path=2.41/
Add Dependancy for Test NG https://mvnrepository.com/artifact/org.testng/testng
Download and install GIT from https://gitforwindows.org/. Check Path variable with GIT.
Port 8080 should be opened (use VPN).
To generate Serenity report manually execute: 'mvn serenity:aggregate'