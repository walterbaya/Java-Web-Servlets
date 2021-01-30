create schema demo;
use demo;
create table productos(
id bigint not null auto_increment,
presentacion varchar(255) not null default '',
cantidad int(11) not null default 0,
precio float not null default 0.0,
descripcion varchar(255),
primary key(id)
);

insert into productos(presentacion,cantidad,precio,descripcion) values ('lata durazno', 100, 20.00, 'pack x 10');
insert into productos(presentacion,cantidad,precio,descripcion) values ('aceite', 120, 50.00, 'pack x 10');
insert into productos(presentacion,cantidad,precio,descripcion) values ('fideos', 150, 10.00, 'pack x 5');