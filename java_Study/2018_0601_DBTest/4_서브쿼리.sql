
select * from sawon
where deptno=(select deptno from sawon where saname = '�嵿��');


##�嵿�ǰ� ������ ������ ��������
select * from sawon where sajob = (select sajob from sawon where saname = '�嵿��');

##�嵿�ǰ� ������ �⵵�� �Ի��� ��������
select * from sawon where to_char(sahire,'yyyy') = (select to_char(sahire,'yyyy') from sawon where saname = '�嵿��');

##�嵿�ǰ� ������ ������ �Ի��� ��������
select * from sawon
where case floor(to_number(to_char(sahire,'MM'))/3)
	when 1 then '��'
	when 2 then '����'
	when 3 then '����'
	else '�ܿ�'
	end = (

	select 
	case floor(to_number(to_char(sahire,'MM'))/3)
	when 1 then '��'
	when 2 then '����'
	when 3 then '����'
	else '�ܿ�' 
	end as ����
	from sawon where saname = '�嵿��');
	
	
	##�嵿�ǰ� ������ ��뿡 �Ի��� ���� ���� (1993 =>1990��� �Ի���)
	select * from sawon where  substr(to_char(sahire,'yyyy'),1,3)=(
	select substr(to_char(sahire,'yyyy'),1,3) from sawon where saname ='�嵿��');
	
	
	##�嵿�� �Ǵ� ������� �μ����� ����
	select * from sawon where deptno in (select deptno from sawon where saname='�����' or saname = '�嵿��');
	
	
	
	
	
	
	