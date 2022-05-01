# DisneyAPI Challenge Alkemy
## Nicolas Uema Capdevila
### Spring Boot Rest API

Las funcionalidades del siguiente proyecto se pueden dividir en:
1. Personajes:
    1. Poseen atributos:
        1. Nombre.
        2. Imagen.
        2. Edad.
        3. Peso.
        4. Historia.
        5. Peliculas en la que participa.
    2. CRUD
        1.  Creacion de personajes.
        2.  Lectura de los personajes.
        3.  Actualizacion de los personajes.
        4.  Eliminacion de los personajes.
            - Cuando un personaje es eliminado, previamente es removido de todas las peliculas a las que se asocia. La lógica la programe yo para garantizar el correcto funcionamiento y permitir posibles modificaciones futuras.
    3. Busqueda filtrada por:
        1. Nombre.
        2. Edad.
        3. Peso.
        4. Pelicula en la que aparecen.
2. Peliculas
    1. Poseen atributos:
        1. Titulo.
        2. Imagen.
        3. Fecha de creacion.
            - Esta fecha se registra automaticamente al momento de crear una nueva entidad, el formato de fecha es "dd-MM-yyyy HH:mm:ss".
        4. Calificacion.
            - La cual se valida que este en un intervalo del 1 al 5.
        5. Personajes asociados:
            - Se pueden asociar personajes a la pelicula por medio del id. Se valida que exista un personaje con el id ingresado, y que no se encuentre en la pelicula.
            - Se pueden eliminar personajes de la pelicula por medio del id. Se valida que exista un personaje con ese id.
        6. Genero:
            - Se puede asociar un genero a varias peliculas. Se valida que exista un genero con ese id y que no se encuentre ya asociado a dicha pelicula.
    2. CRUD
        1. Creacion de peliculas.
        2. Lectura de peliculas: se consulta con un GET y se muestran sus atributos.
        3. Actualizacion de las peliculas.
        4. Eliminacion de las peliculas.
    3. Busqueda filtrada por:
        1. Nombre.
        2. Genero.
        3. Ordenada ascendentemente o descendentemente por la fecha de creacion.

## Desarrollo
Es la primera vez que hago un proyecto utilizando Spring Boot, por ende, a lo largo de todo el desarrollo fui consultando distintas fuentes. Tratando de aprender con profundidad el funcionamiento y entenderlo en su ejecucion. Estas fuentes son:


##### SPRING BOOT
- [Spring Boot Architecture](https://www.javatpoint.com/spring-boot-architecture)
- [Rest](https://spring.io/guides/tutorials/rest/)
- [Spring Data Rest Relationship](https://www.baeldung.com/spring-data-rest-relationships)
##### SPRING SECURITY
- [Spring Boot Security Web](https://spring.io/guides/gs/securing-web/)
- [Spring Security Architecture / Web Security](https://spring.io/guides/topicals/spring-security-architecture#web-security)

## Pendiente
- La autenticacion y registro del usuario no pudieron ser finalizadas, aun asi seguiré con el desarrollo del proyecto para aprender a desarrollarlo.
- El envio de email no fue desarrollado.

## Base de Datos
- Nombre: disneyAPI
- Puerto: 8080
- Dialect: SQLServer2016
- Tablas:
  1. movies
  2. characters
  3. genders
  4. movies_characters: tabla de muchas peliculas a muchos personajes.
  5. roles
  6. users
  7. users_roles: tabla de muchos usuarios a muchos roles