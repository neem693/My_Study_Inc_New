
--ȸ���Ϸù�ȣ ������ü
create sequence seq_member_idx


--ȸ�����̺�
create table member
(
	idx int, --�Ϸù�ȣ
	name varchar2(100) not null, --�̸�
	id 	varchar2(100) not null unique, --���̵�
	pwd varchar2(100) not null, --��й�ȣ
	zipcode varchar2(100), --�����ȣ
	addr varchar2(255), --�ּ�
	ip varchar2(100), --IP
	regdate date --��������
)



--idx �⺻Ű ����
alter table member
add constraint pk_member_idx primary key(idx)



insert into member values(seq_member_idx.nextVal,
'������',
'admin',
'admin1234',
'12345',
'���� ���α� ����3��',
'127.0.0.1',
sysdate);


insert into member values(seq_member_idx.nextVal,
'ȫ�浿',
'hong',
'1234',
'12345',
'���� ���α� ����3��',
'127.0.0.1',
sysdate);

select * from member;

commit

select * from member where idx = 1;