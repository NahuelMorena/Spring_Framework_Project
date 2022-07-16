# Spring_Framework_Project

Pagina web en donde se implementa las acciones CRUD (crear, leer, actualizar, borrar) de usuarios, 
acompañado de la lógica de autenticación, para la realización del login, logout y register dentro de 
la pagina. Ademas incluye un perfil propio del usuario donde visualiza su información.

## Backend de la aplicación

Se trabaja con el lenguaje de programación Java utilizando el JDK-17 (17.0.3) y el framework Sping boot v2.7.1.
Para la persistencia de datos se utiliza Hibernate v5.6.9 y JPA como ORM (Object Relational Mapping).
La aplicación se conecta a una base de datos MySQL.

## Autenticación

Para el apartado de autenticación, se utiliza la dependencia de maven JWT (JASON Web Token) en su versión 0.9.1.

## Otras dependencias

Dependecias de maven utilizadas en el proyecto son: 

*  `argon v2.5`: Utilizado para el hasheado de las contraseñas al ser almacenadas en la base de datos.
*  `lombok v1.18.24`: Utilizado para generar autimaticamente los getters() y setters() y demas funciones rutinarias implementadas en clases
utilizando notaciones.
*  Otras dependencias como: spring-tx, spring-boot-starter-data-jpa y mysql-connector-java v8.0.19.

## Frontend de la aplicación

Se implementa una API utilizando JavaScript para conectar las vistas con las operaciones que realiza la aplicación. 
Para de esta forma, poder utilizar la aplicación de una forma mas visual.
