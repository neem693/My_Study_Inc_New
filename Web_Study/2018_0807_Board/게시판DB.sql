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

select * from board order by ref desc,step asc



update board set id = 1,ref =1 where idx = 11

rollback

update board set idx =1,ref = 1 where idx =11
update board set idx=3 where idx =13

update board set subject = '����? �̰�',content = '�߾߾߾߾�',pwd=121212 where idx = 48