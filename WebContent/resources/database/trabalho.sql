create database trabalho;
use trabalho;
show tables;
select * from Categoria;
select * from Curso;
select * from Modalidade;

insert into Curso values (3,"Tspi"),(4,"LC"),(5,"Logistica");

insert into Modalidade values (1,"Atividades de ensino",1),(2,"Atividades de pesquisa",1),(3,"Atividades de extensao",2),
(4,"Atividades artistico cultural",2),(5,"Atividades esportivas",3);

insert into Categoria values
(1,"Particiapacao em monitoria","Monitoria",50.0,100.0,"aprovado pelos orgaos superiores competentes",1),
(2,"Disciplinas cursadas outros cursos","Disciplina extracurricular",54.0,100.0,"Uma atividade por semestre",1),
(3,"Particiapacao em colegiados","Colegiado",10.0,100.0,"uma atividade por semestre",2),
(4,"Grupos criados dentro da instituiçao","Grupo de estudo",20.0,100.0,"aprovado pelo campus",2),
(5,"Ingles , Frances e Espanhol","Idiomas",20.0,100.0,"duas atividades por semestre sendo 50% de cada atividade",3),
(6,"Teste 123","Nome 123",50.0,100.0,"aprovado pelos orgaos superiores competentes",3),
(7,"Teste 456","Nome 456",50.0,100.0,"aprovado pelos orgaos superiores competentes",4),
(8,"Teste 789","Nome 789",50.0,100.0,"aprovado pelos orgaos superiores competentes",5);