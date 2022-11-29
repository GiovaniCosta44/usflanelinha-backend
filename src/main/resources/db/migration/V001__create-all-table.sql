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

INSERT INTO Vaga(Numero, Rua, Tipo, Status) 
VALUES
(23, 2, "MOTORBIKE", 1), 
(24, 2, "CAR", 1), 
(25, 2, "CAR", 1), 
(88, 5, "MOTORBIKE", 1),
(90, 6, "CAR", 1), 
(12, 1, "CAR", 1),
(13, 1, "MOTORBIKE", 1),
(14, 1, "CAR", 1),
(32, 4, "CAR", 1),
(30, 4, "CAR", 1),
(12, 3, "MOTORBIKE", 1),
(13, 3, "CAR", 1);

INSERT INTO `Aluno` (`Ra`, `Nome`, `Email`, `Telefone`)
VALUES
('123456', 'Daniel', 'daniel.petroni25@gmail.com', '11961862329');
