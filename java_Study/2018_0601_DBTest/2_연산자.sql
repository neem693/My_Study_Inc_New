select 1+1,3-1,3/2,10/3,mod(10,3)
from dual;


select sabun,saname,sapay,sapay*0.1 as bonus from sawon;



select * from sawon where sapay >=3000;
select * from sawon where sajob != '����';

select * from sawon where deptno = 10 and sasex = '����';

select * from sawon where sajob = '����' or sajob='����';

select * from sawon where sasex ='����';
select * from sawon where not(sasex ='����');

select * from sawon where deptno in (10,20);


select * from sawon
where saname like '��%';

select * from sawon
where saname like '_��%';

select * from gogek where substr(gojumin,8,1) in ('2','4','6','8');

select * from gogek where gojumin like '______-2%';


select TO_CHAR(ROUND(TO_DATE("2011-09-11 21:00:01","RRRR-MM-DD HH24:MI:SS"),"DD")) from dual;