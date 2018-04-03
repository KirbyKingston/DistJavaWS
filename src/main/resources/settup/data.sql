drop table product;

create table product (
	id varchar(15) primary key,
	description varchar(100),
	unitcost decimal(10,2)
);

insert into product (id, description, unitCost)
    values ('100', 'SupperJet', 120000.00);
insert into product (id, description, unitCost)
    values ('101', 'SortaSuperJet', 100000.00);
insert into product (id, description, unitCost)
    values ('102', 'MidJet', 80000.00);
insert into product (id, description, unitCost)
    values ('103', 'MehJet', 65000.00);
insert into product (id, description, unitCost)
    values ('104', 'OkJet', 45000.00);
insert into product (id, description, unitCost)
    values ('105', 'BrokeJet', 2000.00);



