--��ǰ�Ϸù�ȣ ������ü

drop sequence seq_product_idx

create sequence seq_product_idx
increment by 1
start with 1;

--��ǰ���̺�
CREATE TABLE product	(
idx		 int,						--�Ϸù�ȣ
category	 varchar2(100)		Not Null,		--ī�װ�(��ǻ��/������)
p_num		 varchar2(100)	unique	Not Null,	--��ǰ��ȣ(�𵨹�ȣ)
p_name		 varchar2(50)		Not Null,		--��ǰ��
p_company    varchar2(50)		Not Null,		--������
p_price		 int				Not Null,		--����(�ܰ�)
p_saleprice  int			Not Null,			--���ΰ�
p_image_s	 varchar2(255)		Null,			--��ǰ�̹���(��)
p_image_l	 varchar2(255)		Null,			--��ǰ�̹���(��)
p_content	 clob	Not Null,					--��ǰ����
p_date		 date					Not Null	--�������		
) ;

select * from product

delete from PRODUCT

drop table product;


alter table product add constraint pk_proudct_idx primary key(idx);

insert into product values(seq_product_idx.nextVal,'sp003', 'RC-113',
'��ü�� �ζ���','��ü��',3200,1150,'pds1.jpg','pds1_z.jpg',
'���̿��ƽ� ��ǳ ���Ϸ�-HGPU SHELL * Ư�� ��� ��� ��â * �Ź߲� �޸� ��Ŭ * �� ���� ���� �ż��� �Ź߲� �ý��� * ���� �޸� ������ ���� ����� ��ǳ���� ������ ���̳� * �� ��ǳ �ý��� * ��ǳ���� ��ü������ �Ź߹�â * �ս��� ��Ʈ�� �ý���(�ű� ���� �Ա�) * ����� �˷�̴� ������ * 80mm 82a hyper dubbs �� * ��ö �����̼� * ABEC-5 ���',sysdate);

insert into product values(seq_product_idx.nextVal,'ele002', 'vC-13',
'���PDP-TV','���',9200,4750,'pds4.jpg','pds4_z.jpg',
'����~ ����! 
������ ������~ ��ȸ ���� �ʾ�~~',sysdate);


select * from product;

delete from product where p_num = '�Ｚ qled ��Ʈ��'
commit;
                                     

   6 com001   �Ｚ qled ��Ʈ�� �Ｚ qled ��Ʈ�� �Ｚ         800000      680000 xs139350tlnb000459.jpg xs139350tlnb0004510.jpg �� ����.                                                                                                                                                                                                                         2018-08-03 16:24:09.0

select * from tab;

commit


SELECT *
FROM USER_TAB_COLUMNS
WHERE table_name = 'PRODUCT'


select * from product where category = 'ele002';

select * from product where category = 'ele002';

