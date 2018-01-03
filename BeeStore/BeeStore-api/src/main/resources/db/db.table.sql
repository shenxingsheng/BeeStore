    drop table tbl_dept;
    
    drop table tbl_emp;
    
	create table tbl_dept (
       id varchar2(255 char) not null,
        deptno number(10,0),
        dname varchar2(255 char),
        loc varchar2(255 char),
        primary key (id)
    );
    
    create table tbl_emp (
       id varchar2(255 char) not null,
        comm double precision,
        empno number(10,0),
        ename varchar2(255 char),
        hiredate timestamp,
        job varchar2(255 char),
        mgr number(10,0),
        sal double precision,
        deptno number(10,0),
        primary key (id)
    );
    
    
    alter table tbl_dept 
       drop constraint UK_tbl_dept_deptno;

    
    alter table tbl_dept 
       add constraint UK_tbl_dept_deptno unique (deptno);

    
    alter table tbl_emp 
       drop constraint UK_tbl_emp_empno;

    
    alter table tbl_emp 
       add constraint UK_tbl_emp_empno unique (empno);

    
    alter table tbl_emp 
       add constraint FK_tbl_emp_tbl_dept_deptno
       foreign key (deptno) 
       references tbl_dept (deptno);