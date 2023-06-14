create table cliente
(
    id      int auto_increment primary key,
    no_cliente          varchar(100) not null,
    nu_cpf              varchar(11)  not null,
    dt_criado           datetime     not null,
    dt_modificado       datetime     not null,
    co_usuario_cadastro varchar(50)  not null,
    constraint tb_cliente_nu_cpf_uindex
        unique (nu_cpf)
);

create index cliente_tb_usuario_co_seq_usuario_fk
    on cliente (co_usuario_cadastro);

create table email
(
    id int auto_increment,
    ds_email varchar(150) not null,
	cliente_id int not null,
    primary key (id),
    constraint fk_mail_cliente foreign key (cliente_id) references cliente (id)
);
#unique key uk_email_cliente (cliente_id),
  
create table tb_usuario
(
    co_seq_usuario int auto_increment
        primary key,
    nm_usuario     varchar(100)      not null,
    ds_email       varchar(45)       not null,
    ds_senha       varchar(255)      not null,
    st_ativo       tinyint default 1 not null,
    co_perfil      int               not null,
    constraint ds_email_UNIQUE
        unique (ds_email)
);


INSERT INTO systemcomapirest.tb_usuario (co_seq_usuario, nm_usuario, ds_email, ds_senha, st_ativo, co_perfil) VALUES (1, 'administrador', 'administrador@administrador.com', '$2a$10$481C3yi0xVfPz1Q4T4RuqOpnDaE0tr/SjD.gpAobuq/qjR6qNNjwq', 1, 0);
INSERT INTO systemcomapirest.tb_usuario (co_seq_usuario, nm_usuario, ds_email, ds_senha, st_ativo, co_perfil) VALUES (2, 'usuario', 'usuario@usuario.com', '$2a$10$481C3yi0xVfPz1Q4T4RuqOpnDaE0tr/SjD.gpAobuq/qjR6qNNjwq', 1, 1);
