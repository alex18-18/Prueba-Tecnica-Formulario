-- =====================================================
-- Fidelización de clientes - Script de estructura (MySQL)
-- =====================================================
-- Se ejecuta automáticamente al iniciar Spring Boot con
-- spring.sql.init.mode=always, o puede ejecutarse de forma
-- manual en MySQL Workbench / consola.
-- =====================================================

CREATE TABLE IF NOT EXISTS tipo_identificacion (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS pais (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS departamento (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  pais_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_departamento_pais FOREIGN KEY (pais_id) REFERENCES pais (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS ciudad (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  departamento_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_ciudad_departamento FOREIGN KEY (departamento_id) REFERENCES departamento (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS marca (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS cliente (
  id BIGINT NOT NULL AUTO_INCREMENT,
  tipo_identificacion_id BIGINT NOT NULL,
  numero_documento VARCHAR(30) NOT NULL,
  nombres VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  direccion VARCHAR(200) NOT NULL,
  pais_id BIGINT NOT NULL,
  departamento_id BIGINT NOT NULL,
  ciudad_id BIGINT NOT NULL,
  marca_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_cliente_tipo_identificacion FOREIGN KEY (tipo_identificacion_id) REFERENCES tipo_identificacion (id),
  CONSTRAINT fk_cliente_pais FOREIGN KEY (pais_id) REFERENCES pais (id),
  CONSTRAINT fk_cliente_departamento FOREIGN KEY (departamento_id) REFERENCES departamento (id),
  CONSTRAINT fk_cliente_ciudad FOREIGN KEY (ciudad_id) REFERENCES ciudad (id),
  CONSTRAINT fk_cliente_marca FOREIGN KEY (marca_id) REFERENCES marca (id)
) ENGINE=InnoDB;