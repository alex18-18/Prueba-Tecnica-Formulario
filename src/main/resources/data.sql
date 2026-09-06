-- =====================================================
-- Fidelización de clientes - Datos de prueba (MySQL)
-- =====================================================
-- Se ejecuta automáticamente al iniciar Spring Boot.
-- Usa INSERT IGNORE con IDs explícitos para que sea
-- seguro reiniciar la aplicación sin duplicar registros.
-- =====================================================

INSERT IGNORE INTO tipo_identificacion (id, nombre) VALUES
(1, 'Cédula de Ciudadanía'),
(2, 'Cédula de Extranjería'),
(3, 'Pasaporte'),
(4, 'Tarjeta de Identidad');

INSERT IGNORE INTO pais (id, nombre) VALUES
(1, 'Colombia'),
(2, 'Estados Unidos'),
(3, 'España'),
(4, 'México');

INSERT IGNORE INTO departamento (id, nombre, pais_id) VALUES
(1, 'Antioquia', 1),
(2, 'Cundinamarca', 1),
(3, 'Valle del Cauca', 1),
(4, 'Atlántico', 1),
(5, 'California', 2),
(6, 'Texas', 2),
(7, 'Florida', 2),
(8, 'Madrid', 3),
(9, 'Cataluña', 3),
(10, 'Andalucía', 3),
(11, 'Jalisco', 4),
(12, 'Nuevo León', 4);

INSERT IGNORE INTO ciudad (id, nombre, departamento_id) VALUES
(1, 'Medellín', 1),
(2, 'Envigado', 1),
(3, 'Bogotá', 2),
(4, 'Soacha', 2),
(5, 'Cali', 3),
(6, 'Buenaventura', 3),
(7, 'Barranquilla', 4),
(8, 'Soledad', 4),
(9, 'Los Ángeles', 5),
(10, 'San Francisco', 5),
(11, 'Houston', 6),
(12, 'Austin', 6),
(13, 'Miami', 7),
(14, 'Orlando', 7),
(15, 'Madrid', 8),
(16, 'Barcelona', 9),
(17, 'Sevilla', 10),
(18, 'Guadalajara', 11),
(19, 'Monterrey', 12);

INSERT IGNORE INTO marca (id, nombre) VALUES
(1, 'Americanino'),
(2, 'American Eagle'),
(3, 'Chevignon'),
(4, 'Esprit'),
(5, 'Naf Naf'),
(6, 'Rifle');