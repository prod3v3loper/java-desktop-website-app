# JAVA DESKTOP APPLICATION

![APP](https://raw.githubusercontent.com/prod3v3loper/java-desktop-website-app/main/src/main/resources/images/p3-app.PNG?token=GHSAT0AAAAAACSRTP633NYHX44TT5I32DZ2ZSMJNPQ "Application")

A simple application that allows you to log in via the database and get to the dashboard. The data can be accessed from your website database but also from elsewhere.

Download it and open it with NetBeans, then just click Run and it will open. You can develop it further and add whatever your application needs.

```
LoginApp/
├── nbproject/
│   ├── private/
│   ├── ...
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── prod3v3loper/
│   │   │           └── loginapp/
│   │   │               ├── LoginForm.java
│   │   │               ├── DashboardFrame.java
│   │   │               └── DatabaseConnection.java
│   │   ├── resources/
│   │       ├── images/
│   │       │   └── p3.png
│   │       └── application.properties
├── target/
│   ├── ...
├── .gitignore
├── pom.xml
└── README.md
```

## DATABASE

Change your database, if you already have a local environment (developer environment) then you can directly use localhost and work and develop with it.

```java
private static final String URL = "jdbc:mysql://localhost:6606/databasename";
private static final String USER = "root";
private static final String PASSWORD = "test";
```

# JAR to EXE

Use https://launch4j.sourceforge.net/ to create exe file.

# Alternative

This project was created with https://netbeans.apache.org/.

But you can use https://start.spring.io/ to create your startup project if you want.

# Attention

This one should not use in a real environment but unfortunately there is also something in real environments.

# UPDATE

Migrating **Spring Boot** and **Kotlin** example.

`pom.xml`

```
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.prod3v3loper</groupId>
    <artifactId>LoginApp</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <properties>
        <java.version>11</java.version>
        <kotlin.version>1.5.21</kotlin.version>
        <spring-boot.version>2.5.4</spring-boot.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Dependencies -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Kotlin Dependencies -->
        <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-stdlib</artifactId>
        </dependency>
        <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-reflect</artifactId>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.module</groupId>
            <artifactId>jackson-module-kotlin</artifactId>
        </dependency>

        <!-- Spring Boot Test Dependencies -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.jetbrains.kotlin</groupId>
                <artifactId>kotlin-maven-plugin</artifactId>
                <version>${kotlin.version}</version>
                <executions>
                    <execution>
                        <id>compile</id>
                        <goals>
                            <goal>compile</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>test-compile</id>
                        <goals>
                            <goal>test-compile</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

`src/main/kotlin/Application.kt`

```java
package com.prod3v3loper.loginapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
```

`src/main/resources/application.properties`

```java
spring.datasource.url=jdbc:mysql://localhost:6606/databasename
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

`src/main/kotlin/com/prod3v3loper/loginapp/HelloController.kt`

```java
package com.prod3v3loper.loginapp

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/")
    fun hello(): String {
        return "Hello, Spring Boot with Kotlin!"
    }
}
```

# ISSUE

Please use the issue tab to request a:

* Bug
* Feature

Choose template and report a bug or feature you want [issues](https://github.com/prod3v3loper/java-desktop-website-app/issues).

# CONTRIBUTE

Please read the [contributing](https://github.com/prod3v3loper/java-desktop-website-app/blob/main/.github/CONTRIBUTING.md) to contribute.

# VULNERABILITY

Please use the Security section for privately reporting a [vulnerability](https://github.com/prod3v3loper/java-desktop-website-app/blob/main/.github/SECURITY.md).

# Authors

**[prod3v3loper](https://www.prod3v3loper.com)** - _All works_

# License

[MIT](https://github.com/prod3v3loper/java-desktop-website-app/blob/main/LICENSE)
