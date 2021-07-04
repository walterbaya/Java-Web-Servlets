use test;
CREATE TABLE persona(
	id_persona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45),
    apellido VARCHAR(45),
    email VARCHAR(45),
    telefono VARCHAR(45)
) engine=InnoDB