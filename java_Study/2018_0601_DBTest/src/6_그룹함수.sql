
select count(*) ��ü�����, count(samgr) �Ϲݻ����
from sawon


	select count(*) ��ü�����,
		   max(sapay) �ִ�޿���,
		   min(sapay) �ּұ޿���,
		   max(sahire) �ֱ��Ի�����,
		   min(sahire) �����Ի�����,
		   sum(sapay) ��ü�޿��հ�,
		   avg(sapay) ��ü�޿����
	from sawon

 ##1.�μ��� �ο��� �� �޿��հ�
 
 select deptno,
 		count(*) �ο���,
 		sum(sapay) �޿��հ�
 from sawon
 group by deptno 
 order by deptno;
 
 ##2. �μ��� ���� �ο���
 select 
 	deptno,sasex,
 	count(*) �ο���
 	from sawon
 	group by deptno,sasex
 	order by deptno,sasex;
 
 ##�Ի�⵵�� 
 select *
 from sawon;
 
 select to_number(to_char(sahire,'yyyy')) �⵵��,count(*) �Ի��ο���
 from sawon
 group by to_number(to_char(sahire,'yyyy'))
 order by to_number(to_char(sahire,'yyyy'));
 
 
 ##�Ի��뺰 �ο���
 select 
 	count(*) �ο���,
 	substr(to_char(sahire,'YYYY'),1,3) || '0' as �Ի�⵵
 	from sawon
 	group by substr(to_char(sahire,'YYYY'),1,3) || '0'
 	order by substr(to_char(sahire,'YYYY'),1,3) || '0';
 	
 	
 ##5. �Ի������ �ο���
 
 select case floor(to_number(substr(sahire,4,2))/3)
    when   1    then '��'
    when   2    then '����'
    when   3    then '����'
    else '�ܿ�'
    end as ����
    from sawon
    group by case floor(to_number(substr(sahire,4,2))/3)
    when   1    then '��'
    when   2    then '����'
    when   3    then '����'
    else '�ܿ�'
    end;
 
 select count(*) �ο���,
 case  floor(to_number(substr(sahire,4,2))/3)
    when   1    then '��'
    when   2    then '����'
    when   3    then '����'
    else '�ܿ�'
    end as ����
    from sawon
    group by case floor(to_number(substr(sahire,4,2))/3)
    when   1    then '��'
    when   2    then '����'
    when   3    then '����'
    else '�ܿ�'
    end
    order by case floor(to_number(substr(sahire,4,2))/3)
    when   1    then '��'
    when   2    then '����'
    when   3    then '����'
    else '�ܿ�'
    end;

    
    
    
    
 select *
 from gogek;
 
 ##6. �����̺��� ���������� �ο���
 
 select substr(goaddr,1,2) ����������,count(*) �ο���
 from gogek
 group by substr(goaddr,1,2);
 

 
 
 
 ##7. 
 
 select  substr(gojumin,1,1) || '0�⵵',count(*) �ο���
 from gogek
 group by substr(gojumin,1,1) || '0�⵵';
 
 
 
 select 
 case to_number(substr(gojumin,8,1))
 when 1 then '��'
 when 2 then '��'
 end ����,
 count(*) �ο���
 from gogek
 group by case to_number(substr(gojumin,8,1))
 when 1 then '��'
 when 2 then '��'
 end;
 
 select deptno,
 		count(*)
 		from sawon
 		group by deptno
 		having count(*) >=5;
 		
 select *
 from sawon;
 
 select substr(saname,1,1) || '��' as ����, count(*) �ο���
 from sawon
 group by substr(saname,1,1)
 order by substr(saname,1,1);
 
 
 select sapay ����,count(*) as �ο���
 from sawon
 group by sapay;
 
 
 select case 
 when floor(sapay/1000) * 1000>1000 then to_char(floor(sapay/1000) * 1000)
 when floor(sapay/1000) * 1000<1000 then '1000�����̸�'
 end,
 count(*) �ο���
 from sawon
 group by case 
 when floor(sapay/1000) * 1000>1000 then to_char(floor(sapay/1000) * 1000)
 when floor(sapay/1000) * 1000<1000 then '1000�����̸�'
 end;
	
 	
 	
 