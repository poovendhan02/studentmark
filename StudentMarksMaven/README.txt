STUDENT MARKS CALCULATOR - MAVEN WEB PROJECT

Import:
1. Extract StudentMarksMaven.zip.
2. Eclipse > File > Import > Maven > Existing Maven Projects > Next.
3. Browse to the extracted StudentMarksMaven folder. It contains pom.xml.
4. Select project > Finish. Wait for Maven dependencies to download.
5. Configure Apache Tomcat 10.1.
6. Run database.sql in your database SQL console.
7. Set STUDENT_DB_PASSWORD in Tomcat Run Configurations > Environment.
8. Right-click project > Run As > Run on Server.
9. Browse to http://localhost:8080/StudentMarksMaven/

Needs Java 11+, Eclipse Enterprise Java/Web tools, Tomcat 10.1, internet access for Maven dependencies.
Database host db01.dbhost.dev, port 5051, database db_457d83t66, username user_457d83t66.
Set the password as environment variable STUDENT_DB_PASSWORD; do not commit credentials to source.
Uses Jakarta Servlet 6.0, so use Tomcat 10.1 rather than Tomcat 9.
