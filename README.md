# Pet-store
The needed infrastructural dependencies to run the application:
-   Java 17
-   Maven 3.6 +

To start the application first we need to build it with the following command:
-   mvn clean install on the root maven module (to build the java backend)

When the application is built you can start it with the run configuration PetShopApplication to run the backend.

When the backend is started you can send requests using Postman or a similar tool.</br>
The following requests are available in the application:
- POST http://localhost:8080/user - to create up to 10 users with random properties, the number of users created is also chosen randomly.
- POST http://localhost:8080/pet - to create up to 20 pets with random properties of different types, the number of pets created and the type is also chosen randomly.
- GET http://localhost:8080/user - to display all the users stored in the db.
- GET http://localhost:8080/pet - to display all the pets stored in the db.
- POST http://localhost:8080/user/buy - to try and buy a pet for all the users in the db.
- GET http://localhost:8080/historyLog - to display the history log off all the buy commands.