This project has the testing framework for our fund transfer service.
The framework runs 2 threads-

__AccountRegistration__
This thread continuously registers an account with a random accountId.

__Funds Transfer__
This thread tries to transfer a random amount between 2 random account ids.

How to run the tests -  
1. First start the Fund Transfer Server, [link here](https://github.com/kvermun/FundTransferAPI) , in a seperate terminal or via Intellij.
2. Clone this git repository in a folder
3. Navigate to the directory FundTransferAPITests/src/main/java
4. Using Command line 
	* javac SimpleClient.java
 	* java SimpleClient
5. Using Intellij, you can open the project in Intellij and run the main method as well.
