/*

--�Ϸù�ȣ������ü

*/


drop table board

create table board(

idx int, --�Ϸù�ȣ
id	varchar2(100), 		--�ۼ��� ���̵�
name varchar2(100), 	--�ۼ��� �̸�
subject varchar2(300), 	--����
content clob, 			--����
pwd	varchar2(100),		--��й�ȣ
ip varchar2(100), 		--ip
regdate date, 			--�ۼ�����
readhit int, 			--��ȸ��
--�亯���Խ��ǰ����Ӽ�
ref 	int,			--���α� ��ȣ
step 	int,			--������ ����
depth 	int 			--������ ����
)




alter table board
add constraint pk_board_idx primary key(idx)


--�ܷ�Ű ����
alter table board
add constraint fk_board_id foreign key(id) references member(id)

select * from member;

select * from board

delete from board where idx = 6

insert into board values(seq_board_idx.nextVal,'hong','ȫ�浿','����1��','����',1234,'127.0.0.1',sysdate,0,seq_board_idx.currVal,0,0)
--��۾��� �μ�Ʈ ��

insert into board values(seq_board_idx.nextVal,'admin','������','�׷� �װ� 1���̴�','�ϵ��̳� �ض�',1234,'127.0.0.1',sysdate,0,1,1,1)
insert into board values(seq_board_idx.nextVal,'admin','������','�ٵ� ���� 1���ϰ� �ͳ�?','�ױ��� ����',1234,'127.0.0.1',sysdate,0,1,2,2)

insert into board values(seq_board_idx.nextVal,'hong','ȫ�浿','������ �������','�����ڳ��',1234,'127.0.0.1',sysdate,0,seq_board_idx.currVal,0,0);
insert into board values(seq_board_idx.nextVal,'hong','ȫ�浿','�����Ѵ�. ������ �������� �ȳ����ϱ� �����Ѵ�. �ĳĳĳĳĳĳĳĳĳĳĳĳĳĳĳĳĳĳ�','������',1234,'127.0.0.1',sysdate,0,seq_board_idx.currVal,0,0);


commit



delete from board where idx>=34

create or replace view board_show as select rownum no,s.* from (select * from board order by ref desc,step asc) s

create or replace view board_show_rank as select  rank() over(order by ref desc,step asc) no ,b.* from(select * from board) b



select * from board_show_rank



select * from member



update board set id = 1,ref =1 where idx = 11

rollback

update board set idx =1,ref = 1 where idx =11
update board set idx=3 where idx =13

update board set subject = '����? �̰�',content = '�߾߾߾߾�',pwd=121212 where idx = 48


select *
from board_show
where ref = 60


--select b2.*
--from board b1 inner join board b2
--on b1.idx = b2.ref
--where b1.idx = 47 and b2.idx 

select count(*)
from board
where ref = 47 and step>6;


alter table board
ADD(del NUMBER(1));

update board set del = 0;



select * from board where ref = 60;
select * from board where idx = 65;
	select nvl(count(*),0)
	from board
	where ref =60 and step>3
