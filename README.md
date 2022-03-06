# Sprint2PB
QUESTÃO 1, 2 E 3 DO SPRINT 2!

COMANDOS UTILIZADOS NO MYSQL PARA A QUESTAO 1:
CREATE DATABASE MERCADORIAS;
USE MERCADORIAS;
CREATE TABLE PRODUTO (id int auto_increment, nome varchar(50), descricao varchar(250), quantidade int, preco float, primary key (id)) Engine = InnoDB;

COMANDOS UTILIZADOS NO MYSQL PARA A QUESTAO 2:
CREATE DATABASE FILMES;
USE FILMES;
CREATE TABLE FILMES_LISTA (id int auto_increment, nome varchar(100) NOT NULL, descricao varchar(255), ano YEAR, primary key (id)) Engine = InnoDB;
