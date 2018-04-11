# Switchfully

www.switchfully.com

**A JPA / Hibernate example with Spring using minimal configuration!**

# application.properties
- Contains almost all the configuration based on setting the required values for a set of properties.
- No manual `@Bean` creation of the datasource or entityManager is required.

# schema.sql and data.sql
- Are executed every time the application is launched.

# Ojdbc
- Because of license issues, oracle ojdbc is not publicly available on mvncentral. 
Therefore, it's included in the GitHub repository and added in a special way in Maven as a dependency.