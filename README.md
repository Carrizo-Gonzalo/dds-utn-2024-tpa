# MAACVS – Sistema para la Mejora del Acceso Alimentario en Contextos de Vulnerabilidad Socioeconómica

Este proyecto fue desarrollado como parte del **Trabajo Práctico Anual de la materia Diseño de Sistemas (UTN, 2024)**.

El enunciado propone el diseño e implementación de una solución tecnológica que permita a organizaciones y comunidades coordinar y gestionar el acceso a recursos alimentarios en contextos de vulnerabilidad socioeconómica.

La aplicación implementa un sistema web de **cliente liviano** (server-side render), con **persistencia mediante JPA (Hibernate como implementación)** y un backend desarrollado en **Java** utilizando el framework **Javalin**.
La base de datos utilizada es **MySQL**.

---

## 📌 Características principales

* Arquitectura modular con separación clara de capas.
* Framework web: **Javalin**, con renderizado del lado del servidor.
* Persistencia de datos utilizando **JPA (Hibernate ORM)** sobre **MySQL**.
* Carga masiva de entidades desde archivos CSV.
* Gestión de usuarios e **incidentes alimentarios** con fotos adjuntas.
* Manejo de sesiones y validaciones.
* Generación de reportes y consultas para la toma de decisiones.

---

## 🏗 Arquitectura y estructura

```
└── src/
    ├── main/java/
    │   ├── controllers/      ← Controladores (manejo de requests/responses)
    │   ├── models/           ← Entidades del dominio (JPA)
    │   ├── repositories/     ← Repositorios (EntityManager / JPA)
    │   ├── services/         ← Lógica de negocio
    │   └── App.java          ← Punto de entrada de la aplicación
    ├── main/resources/
    │   ├── templates/        ← Vistas HTML para server-side rendering
    │   └── META-INF/
    │       └── persistence.xml ← Configuración de JPA (MySQL)
    └── test/                 ← Tests unitarios
├── uploads/                  ← Carpeta para fotos de incidentes
├── CargaMasivaTest1.csv      ← Ejemplos de carga masiva
├── CargaMasivaTest2.csv
├── CargaMasivaTest3.csv
├── Diagramas.mdj             ← Diagramas UML / de diseño
├── pom.xml                   ← Dependencias (Maven)
└── README.md
```

---

## 🛠 Tecnologías usadas

* **Java 17**
* **Javalin** – Framework web liviano
* **JPA (con Hibernate como implementación)** – Persistencia
* **MySQL** – Base de datos
* **Maven** – Gestión de dependencias
* **JUnit** – Testing
* **Handlebars** - Motor de plantillas

---

## ⚙️ Instalación / Configuración

1. **Clonar el repositorio**

   ```bash
   git clone https://github.com/Sichermatias/dds-utn-2024-tpa.git
   cd dds-utn-2024-tpa
   ```

2. **Instalar dependencias**

   ```bash
   mvn clean install
   ```

3. **Configurar base de datos (MySQL)**
   Editar el archivo `persistence.xml` (en `src/main/resources/META-INF/`) con las credenciales de tu servidor MySQL.

   ```xml
   <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
   <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/dds_db?serverTimezone=UTC"/>
   <property name="javax.persistence.jdbc.user" value="root"/>
   <property name="javax.persistence.jdbc.password" value="tu_password"/>
   <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
   ```

   > Asegurate de crear la base de datos `dds_db` en MySQL antes de ejecutar la aplicación:

   ```sql
   CREATE DATABASE dds_db;
   ```

4. **Ejecutar la aplicación**

   ```bash
   mvn exec:java -Dexec.mainClass="App"
   ```

5. **Abrir en el navegador**
   👉 [http://localhost:8080](http://localhost:8080)

---

## 🚀 Uso

* **Personas vulnerables**: acceden a las heladeras comunitarias mediante una tarjeta registrada en el sistema, lo que permite un control seguro y ordenado del acceso a los recursos alimentarios.
* **Organizaciones y comunidades**: administran las heladeras, supervisan incidentes y gestionan la asistencia alimentaria.
* **Carga masiva**: permite subir archivos CSV para registrar múltiples entidades de forma rápida.
* **Reportes**: el sistema genera información útil sobre accesos, incidentes y recursos disponibles.

---

## 🧪 Tests

Para correr los tests:

```bash
mvn test
```

---

## 🌱 Mejoras futuras

* Paginación y filtros avanzados en listados.
* Documentación de API con Swagger / OpenAPI.
* Tests de integración con cobertura ampliada.
* Despliegue en la nube (Heroku, Railway, etc.).

---

## 📝 Licencia

Este proyecto es de carácter académico.

---

## 👨‍💻 Autores

* **Matías Sicher**
* **Federico Bietti**
* **Gonzalo Carrizo**
* **Lautaro Petronacci**

📍 UTN – Diseño de Sistemas 2024