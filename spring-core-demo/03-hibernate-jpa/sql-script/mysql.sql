
create table questions(
	id int not null auto_increment,
    prashn varchar(80) not null,
    primary key(id)
    );
create table answers(
	id int not null auto_increment,
    ans varchar(100),
    que_id int,
    primary key(id),
    foreign key(que_id) references questions(id)
);