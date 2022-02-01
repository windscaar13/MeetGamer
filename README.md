# MeetGamer

How to Run the Project?

1. Import the project file in the STS or any eclipse based IDE. 
2. If test classes are missing library reference for Junit, add the Junit Library manually from the Project properties -> Java Build Path to resolve this issue.
3. Build the project
4. Open the "MeetgamerApplication.java" from the package "com.test.meetgamer" and right click and run as Spring Boot App
5. Open "http://localhost:8080/swagger-ui/index.html" for testing the Rest API exposed using Swagger
6. All the api methods are exposed under namespace "/api/"
7. Open the file "MeetgamerApplicationTests.java" to view the test methods and run them.
8. All the data models can be found under the package "com.test.meetgamer.data.model"

API Details

1. /api/enrollGamer - This API accepts user information in the form of UserInfo Entity object and saves it to the in-memory database(H2). 
2. /api/addUserCredits - This API gets the user credit information as a request param and updates it to the user object using the user id param.
3. /api/searchGamers - This API is supposed to be used for matchmaking gamers. It accepts the name of the game, player skill level and region information and gives                        a list of gamers who matches the criteria.
4. /api/getGamerWithMaxCredit - This API is used for retrieving the Gamer information who has the maximum credit based on the game and skill level
5. /api/videogameinfo - This api will be used as a look up API to get all the game information for the gamers to choose from.

Data Model:

Master Data/Look up Data: 

1. GamerSkill - Entity object which holds the game skill information
2. VideoGameInfo - Entity object which holds the video game information

Transaction Data Models:

1. UserInfo - Entity object which holds the basic User iformation
2. UserGamePref - Entity object which holds the Game information and the skill of the player. 

UserInfo has one-to-many relationship with the UserGamePref object. One User can have multiple Game Preferences. 

Challenges:

One of the major challenge for me was to complete the React Web portion along with the API. I started the Web project but I felt like I needed more time to complere that along with the API portion. I am not uploading the web project since it is incomplete.

