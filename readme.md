# Servicio restful básico en JAVA
## Autor: Jonathan Martín Valera
### Repositorio creado para la asignatura de *Desarrollo basado en componentes y servicios* en el máster de ingeniería informática en Granada
#### Fecha de realización: Diciembre 2018

---

# Tabla de contenidos

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Descripción](#Descripción)
- [Herramientas utilizadas](#herramientas-utilizadas)
- [Desarrollo e implementación](#desarrollo-e-implementaci%C3%B3n)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

---

# Descripción

Este proyecto consta de un servicio restful básico en Java utilizando el framework Jersey. Consta de un recurso, el modelo, un contenedor DAO y un tester que es un main donde se realizan las peticiones al servicio y se comprueba que funciona.

Para más información acerca de su funcionamiento, se puede consultar **[enlace a vídeo youtube](https://youtu.be/Vkmn2Mr6zsk)**.

---

# Herramientas utilizadas

- IDE: Eclipse Java EE IDE for Web Developers. Version: Neon.3 Release (4.6.3)
- Java: 1.8.
- Server: Apache Tomcat 9.0

---

# Desarrollo e implementación
Para documentar esta práctica, he decidido grabar un vídeo y subirlo a youtube donde
muestro como he diseñado la práctica y cuál es el resultado de su implementación.
Enlace a vídeo donde se explica el desarrollo de la práctica 2: https://youtu.be/Vkmn2Mr6zsk
En primer lugar se debe de importar el proyecto en eclipse. Posteriormente se debe de
ejecutar el proyecto en el servidor tomcat, y podemos realizar lo siguiente:

- Se puede ejecutar el main Tester (como aplicación JAVA) y observar la información que
se muestra por pantalla, donde se comprueba que el servicio funciona correctamente.

- Se puede realizar peticiones PUT (para añadir un nuevo artículo), POST (para modificar
un artículo), GET (para obtener los datos de un artículo) y DELETE (para modificar un
artículo).

- Se puede lanzar la aplicación ver la información HTML en un navegador a través del
enlace http://localhost:8080/DSS_P2/webapi/articles y ver la información html.
También se puede acceder al contenido de un artículo accediendo al enlace
http://localhost:8080/DSS_P2/webapi/articles/{idArticulo}. Para más información
consultar el vídeo donde se demuestra todo.
