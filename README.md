# Formulario de Fidelización de Clientes

Proyecto académico (prueba técnica) que implementa un formulario web de
fidelización de clientes. Los datos se guardan en **MySQL** a través de una API
**Spring Boot**, y el formulario se consume desde un frontend de **React (Vite)**.

## Stack tecnológico

| Capa      | Tecnología                                   |
| --------- | -------------------------------------------- |
| Backend   | Java 8 / Spring Boot 2.7 / Maven             |
| Frontend  | React 18 + Vite (JavaScript)                 |
| Base de datos | MySQL                                      |

## Estructura del proyecto

```
├── src/main/java/com/cesde/fidelizacion/
│   ├── controller/      # Controladores REST (endpoints GET y POST)
│   ├── service/         # Capa de servicios (lógica de negocio)
│   ├── repository/      # Repositorios Spring Data JPA
│   ├── model/           # Entidades JPA
│   └── dto/             # Objeto de transferencia (ClienteDTO)
├── src/main/resources/
│   ├── schema.sql       # Estructura de las tablas
│   ├── data.sql         # Datos de prueba (tablas maestras)
│   └── application.properties  # Configuración de MySQL
└── frontend/            # Aplicación React (Vite)
    └── src/
        └── App.jsx      # Componente principal del formulario
```

## Requerimientos previos

- JDK 8 o superior
- Maven 3.6+
- Node.js 18+ (para el frontend)
- MySQL 5.7 u 8.0 con una base llamada `fidelizacion_clientes`

Crea la base de datos en MySQL:

```sql
CREATE DATABASE fidelizacion_clientes;
```

Las tablas y los datos maestros se crean automáticamente al iniciar el backend
mediante `schema.sql` y `data.sql`.

> Si tu usuario/contraseña de MySQL no son `root`/`root`, edítalos en
> `src/main/resources/application.properties`.

## Endpoints de la API

| Método | URL                          | Descripción                              |
| ------ | ---------------------------- | ---------------------------------------- |
| GET    | `/api/tipos-identificacion`  | Lista los tipos de documento             |
| GET    | `/api/paises`                | Lista los países                         |
| GET    | `/api/departamentos/{paisId}` | Lista departamentos por país            |
| GET    | `/api/ciudades/{depId}`       | Lista ciudades por departamento         |
| GET    | `/api/marcas`                | Lista las marcas                         |
| POST   | `/api/clientes`              | Guarda un cliente (recibe un `ClienteDTO`) |

CORS está habilitado (`@CrossOrigin`) para permitir peticiones desde React.

## Cómo levantar el proyecto

### 1. Backend (Spring Boot)

```bash
mvn spring-boot:run
```

El servidor queda disponible en `http://localhost:8080`.

### 2. Frontend (React)

```bash
cd frontend
npm install
npm run dev
```

La aplicación se abre en `http://localhost:5173`. El frontend consume la API en
`http://localhost:8080/api`.

### 3. Probar el flujo

1. Completa el formulario (los selects de País → Departamento → Ciudad se llenan
   en cascada desde el backend).
2. Pulsa **Registrar cliente**: verás un mensaje de éxito o de error.
3. Puedes verificar el registro en MySQL:

```sql
USE fidelizacion_clientes;
SELECT * FROM cliente;
```