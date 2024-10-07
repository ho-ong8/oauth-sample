# oauth-sample
> Google, Naver, Kakao OAuth2 Sample.

<br>

## Development Environment
<div style="display: inline-block">
    <img src="https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=flat-square&logo=IntelliJIDEA&logoColor=white" />
    <img src="https://img.shields.io/badge/HTML-e34f26?style=flat-square&logo=HTML5&logoColor=white" />
    <img src="https://img.shields.io/badge/CSS-1572b6?style=flat-square&logo=CSS3&logoColor=white" />
    <img src="https://img.shields.io/badge/Java-3a75b0?style=flat-square&logo=coffeescript&logoColor=white" />
    <img src="https://img.shields.io/badge/Spring%20Boot-6db33f?style=flat-square&logo=SpringBoot&logoColor=white" />
    <img src="https://img.shields.io/badge/Gradle-02303a?style=flat-square&logo=Gradle&logoColor=white" />
    <img src="https://img.shields.io/badge/MySQL-4479a1?style=flat-square&logo=MySQL&logoColor=white" />
</div>

<br>

- IDE: IntelliJ IDEA
- Language: HTML5, CSS3, JAVA (JDK 21)
- Framework: Spring Boot
- Build: Gradle
- DBMS: MySQL

<br>

## Main Function
- 회원(User) - Google, Naver, Kakao OAuth2 로그인 연동

<br>

## Create MySQL Database
```SQL
create database oauth;
create user hoong@localhost identified by '8888';
grant all privileges on oauth.* to hoong@localhost;
```

<br>

## MySQL Database Table
```SQL
drop table if exists oauth.user;

create table oauth.user (
    id       bigint primary key not null auto_increment,
    name     varchar(255) null,
    email    varchar(255) null,
    password varchar(255) null,
    role     varchar(255) null,
    provider varchar(255) null
);
```
