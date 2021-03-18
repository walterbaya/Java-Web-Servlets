use cafe;
drop table comentario;
drop table comentario2;
drop table curso;
drop table curso2;
drop table persona;

create table productos(
id bigint not null auto_increment,
precio double not null default 0.0,
descripcion varchar(255),
primary key(id)
);