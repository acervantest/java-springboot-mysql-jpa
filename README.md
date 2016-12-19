## Rest service using Spring Boot, MySQL, and Hibernate
Basic CRUD template interacting with the db using JP

### Build and run
#### Configurations

Open the `application.properties` file and set your own configurations for the
database connection.

#### Prerequisites

- Java 7
- Maven 3

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.

### Run

- Run the application and go on http://localhost:8080/
- Use the following urls to invoke controllers methods and see the interactions
  with the database:
   
     * `http://localhost:8080/person/all`:  get a list of people.
    
     * `http://localhost:8080/person/[id]`: find a person by id.
     
     * `http://localhost:8080/person/findAge/[age]`: find a person by age.
     
     * `http://localhost:8080/person/find/[name]`: find a person by name (query implementation as a native query).
    
     * `http://localhost:8080/person/update`: update a person(sending a POST request).
   
     * `http://localhost:8080/person/create/?name=[name]&lastname=[lastname]&age=[age]&profession=[profession]`: create a new         person.
     
     * `http://localhost:8080/person/delete/?id=[id]`: delete a person.
    
   
    
