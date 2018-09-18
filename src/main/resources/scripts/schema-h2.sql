 create table course (
       id bigint not null,
        full_name varchar(255) not null,
        primary key (id)
    );
    
    create table review (
       id bigint not null,
        description varchar(255),
        rating varchar(255),
        course_id bigint,
        primary key (id)
    );
    
    alter table review 
       add constraint FKprox8elgnr8u5wrq1983degk 
       foreign key (course_id) 
       references course