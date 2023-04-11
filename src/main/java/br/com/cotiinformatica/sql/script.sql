create table usuario(
	idusuario		serial			primary key,
	nome			varchar(100)	not null,
	email			varchar(50)		not null unique,
	senha			varchar(40)		not null
);

create table contato(
	idcontato		serial			primary key,
	nome			varchar(100)	not null,
	telefone		varchar(20)		not null,
	email			varchar(50)		not null,
	observacoes		varchar(250)	not null,
	idusuario		integer			not null,
	foreign key(idusuario) references usuario(idusuario)
);