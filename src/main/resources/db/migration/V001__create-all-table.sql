create table Aluno
(
    Ra int primary key not null,
    Nome varchar(150) not null,
    Email varchar(250) not null unique,
    Telefone varchar(50) not null
);

create table Funcionario
(
    Rf int primary key,
    Nome varchar(150) not null,
    Email varchar(250) not null unique,
    Telefone varchar(50) not null,
    Senha varchar(20) not null
);


create table Vaga
(
    id int primary key auto_increment,
    Numero int not null,
    Rua int not null,
    Tipo varchar(20) not null,
    Status int not null
);

create table Ticket
(
    Codigo int primary key auto_increment,
    aluno_ra int not null,
    vaga_id int not null,
    Entrada datetime not null,
    Saida datetime,
    Status varchar(20) not null,

    FOREIGN KEY(aluno_ra) REFERENCES Aluno(Ra),
    FOREIGN KEY(vaga_id) REFERENCES Vaga(id)
);
