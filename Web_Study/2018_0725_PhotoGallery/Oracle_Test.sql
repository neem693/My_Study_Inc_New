



--�Ϸù�ȣ ������ü

create sequence seq_photo_idx;

create table photo
(

idx 		int, --�Ϸù�ȣ
title 		varchar2(100), --����
filename 	varchar2(255), --ȭ�ϸ�
pwd 		varchar2(100), -- ���
ip 			varchar2(100), --IP
regdate 	date --��¥

)

alter table photo
add constraint pk_photo_idx primary key(idx);

select * from photo;