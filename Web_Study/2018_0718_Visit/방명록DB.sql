
--������ ����
create sequence seq_visit_idx;

--���� ���̺� ����
drop table visit;

create table visit(

idx int,
name varchar2(100) not null,
content clob not null,
pwd varchar2(100) not null,
ip varchar2(100) not null,
regdate date  --�ۼ�����

)
alter table visit
add constraint pk_visit_idx primary key(idx);


--����
insert into visit values(seq_visit_idx.nextVal,'����Ʈ��','�ȳ��ϼ���. ��������������ȣȣȣ�����������������������������ٰ�����������⸶����������������������������','1234','127.0.0.1',sysdate);
insert into visit values(seq_visit_idx.nextVal,'�̱浿','�ȳȳȳ�','1234','127.0.0.1',sysdate);

update visit set name ='SCP���',content='1231231234',pwd='1234',regdate=sysdate where idx=6
select * from visit;
delete from visit;