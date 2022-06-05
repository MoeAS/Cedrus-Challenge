# Cedrus-Challenge

# To Run the app

On terminal/cmd:

1) cd to the project folder

```
C:\Users\Mohammed>cd Desktop\springboot\springboot_demo

C:\Users\Mohammed\Desktop\springboot\springboot_demo>
```

2) check pom.xml file to see if java versions are the same, if not then replace with your version at Line 17

```
<properties>
	<java.version>18</java.version>
</properties>
```

3) run 'mvnw spring-boot:run'

```
C:\Users\Mohammed\Desktop\springboot\springboot_demo>mvnw spring-boot:run
```

# If the following error shows up

```
[ERROR] No plugin found for prefix 'springboot' in the current project and in the plugin groups [org.apache.maven.plugins, org.codehaus.mojo] available from the repositories
```

run the following
```
mvnw org.springframework.boot:spring-boot-maven-plugin:run
```

# Things I would fix:

1) Better database design (primary keys, not null, foreign keys, etc...)
2) Had a lot of problems with CORS Error
![image](https://user-images.githubusercontent.com/60234076/172035163-8125b58f-8718-4447-af9a-825e9e452e03.png)
3) Make a better books table including genre, and a boolean if popular or not popular
4) another table for user's books, which includes foreign keys of a user in the DB and books the user inserted
