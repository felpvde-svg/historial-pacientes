CREATE DATABASE IF NOT EXISTS historial_pacientes;
USE historial_pacientes;

CREATE TABLE IF NOT EXISTS paciente (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    documento VARCHAR(20) NOT NULL UNIQUE,
    fecha_nacimiento DATE NOT NULL,
    tratamiento TEXT
    );

-- ==========================================================
-- Datos de ejemplo (opcionales)
-- ==========================================================
INSERT INTO paciente (nombre, apellido, documento, fecha_nacimiento, tratamiento) VALUES
                                                                                      ('Laura', 'Gonzalez', '1009234567', '1995-02-10', 'Control general y vacunas'),
                                                                                      ('Andres', 'Martinez', '1098442211', '1988-11-23', 'Tratamiento para diabetes tipo II, controles y medicación'),
                                                                                      ('Maria', 'Lopez', '1095007890', '2002-07-14', 'Ortodoncia, limpieza dental y seguimiento'),
                                                                                      ('Santiago', 'Ramirez', '1012345678', '1990-03-02', 'Rehabilitación fisioterapéutica por lesión de rodilla'),
                                                                                      ('Camila', 'Torres', '1088996655', '1998-05-29', 'Control ginecológico anual, chequeo


