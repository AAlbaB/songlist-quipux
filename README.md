# Proyecto Lista de Canciones - Prueba Técnica

Este proyecto es una aplicación básica desarrollada en Spring Boot para gestionar listas de canciones, con autenticación JWT

## Estructura del Proyecto

La estructura de carpetas del proyecto es la siguiente:

- **src/**: Código fuente del proyecto.
    - **main/**: Código principal de la aplicación.
        - **java/**: Código Java de la aplicación.
            - **com/spring/songlist/configuration/**: Configuraciones y Beans del proyecto.
            - **com/spring/songlist/controller/**: Controladores que manejan las solicitudes HTTP.
            - **com/spring/songlist/exception/**: Excepciones personalizadas para el manejo de errores.
            - **com/spring/songlist/model/**: Clases que representan las entidades del dominio.
            - **com/spring/songlist/repository/**: Interfaces para la interacción con la base de datos.
            - **com/spring/songlist/service/**: Lógica de negocio de la aplicación.
            - **com/spring/songlist/util/**: Clases utiles para la construcción del proyecto
        - **resources/**: Archivos de configuración y datos.
            - **application.properties**: Configuración de la aplicación.
            - **data.sql**: Inserciones iniciales en la base de datos
- **.gitignore**: Especifica los archivos y directorios que Git debe ignorar.
- **docker-compose.yml**: Define y configura los servicios de Docker para la aplicación.
- **Dockerfile**: Dockerfile para la configuración del contenedor de la aplicación.
- **pom.xml**: Archivo de configuración de Maven que gestiona las dependencias y plugins del proyecto.

## Tecnologías Utilizadas

El proyecto utiliza las siguientes tecnologías:

- **Java 17**: Lenguaje de programación principal.
- **Spring Boot 3.2.3**: Framework para el desarrollo de aplicaciones Java.
- **H2**: Sistema de gestión de bases de datos relacional.
- **Docker**: Plataforma para desarrollar, enviar y ejecutar aplicaciones en contenedores.
- **Docker Compose**: Herramienta para definir y gestionar aplicaciones Docker multi-contenedor.
- **Maven**: Herramienta de gestión y construcción de proyectos Java.

## Ejecución del Proyecto con Docker Compose

Para ejecutar el proyecto utilizando Docker Compose, sigue estos pasos:

1. **Clonar el repositorio**:

```bash
   git clone https://github.com/AAlbaB/songlist-quipux.git
```

2. **Navegar al directorio del proyecto**:

```bash
   cd songlist-quipux
```

3. **Construir y ejecutar los contenedores**:

```bash
   docker-compose up --build -d
```

## Acceder a la aplicación

- Una vez que el contenedor esté en funcionamiento, la aplicación estará disponible en `http://localhost:8080/WsSongList`


- Se puede acceder a la consola de H2 en la ruta: `http://localhost:8080/WsSongList/h2-console/` y como **JDBC URL =** `jdbc:h2:mem:songlist` 


- Se pueden verificar el funcionamiento con la colección adjunta y enviroment adjunto en: `collections/..` o en: [Colección publicada](https://documenter.getpostman.com/view/45694327/2sB3Hew52p)

## Detener la aplicación
Para detener y eliminar los contenedores en ejecución, puedes utilizar el siguiente comando (Quitar -v para dejar los volúmenes creados):

```bash
   docker-compose down
```

