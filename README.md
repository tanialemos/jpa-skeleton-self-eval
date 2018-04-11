# Switchfully

www.switchfully.com

**A JPA / Hibernate example with Spring using minimal configuration!**

## Usage
- Inspect the code and dependencies, it's a minimal setup for hooking up your code with a database (using Hibernate)
- There's an integration test with proper (JUnit4) configuration to test the integration between the 
repository and the database.

# application.properties
- Contains almost all the configuration based on setting the required values for a set of properties.
- No manual `@Bean` creation of the datasource or entityManager is required.

# schema.sql and data.sql
- Are executed every time the application is launched.

# Ojdbc
- Because of license issues, oracle ojdbc is not publicly available on mvncentral. 
Therefore, it's included in the GitHub repository and added in a special way in Maven as a dependency.

# Used resources
- http://www.baeldung.com/spring-boot-data-sql-and-schema-sql
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
- A lot of Googlin'