create or replace view sawon_view_man
as
select * from sawon where sasex = '����';


select * from sawon_view_man;

create or replace view sawon_view_man
as
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
    
    
    
    select * from gogek;
    
    create or replace view gogek_view
    as
	    select gobun,goname,goaddr,
	    to_number(substr(gojumin,1,2)) +
	    (
	    case when substr(gojumin,8,1) in (1,2,5,6) then 1900
	    else 2000
	    end
	    )  as year, 
	    to_number(substr(gojumin,3,2)) month, to_number(substr(gojumin,5,2)) day 
	    from gogek;
	    
	    
	    
	    create user test2 identified by test2;
	    grant connect to test2;
	    
	    ##������ ������(dbo.test)�� test2���� ��ü������ �ο�
	    //��ü ��뿡 ���� ����
	    grant select on gogek_view to test2;
	    
	    
	    ##test2�������� ��ȸ
	    (test�κ��� gogek_view�� select ���Ѻο� ������������ ���� ����)
	    dbo.��ü��
	    select s.*, sapay*0.1 as bonus from (select * from sawon) s;
	    
	    select 	s.*, 
	    		sapay*0.1 as bonus,
	    		(select avg(sapay) from sawon) as tot_avg,
	    		sapay - (select avg(sapay) from sawon) as gap
	    		from(select * from sawon) s
	    		
	   select 
	   s.*,
	   rank() over(order by sapay desc) as rank
	   from (select * from sawon)s
	   order by sabun;
	   
	   
	   select *
	   from(
	   select 
	   s.*,
	   rank() over(order by sapay desc) as rank
	   from (select * from sawon)s
	   order by sabun
	   )
	   where rank<=5;
	    
	   
	   
	   
	   
	    
	    
	    
