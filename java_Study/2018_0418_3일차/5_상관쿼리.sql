##��ü �����߿��� �ִ�޿��ڸ� ����
select * from sawon
where sapay = 4500

##10�� �μ��� �ִ�޿��ڸ� ����
select * from sawon
where sapay = 4000 and deptno =10;


##10�� �μ��� �ִ� �޿��ڸ� ����
select max(sapay) from sawon;

##���μ��� �ִ�޿��ڸ� ����
select * from sawon
where 
(sapay=(select max(sapay) from sawon where deptno = 10) and deptno = 10)
or
 (sapay=(select max(sapay) from sawon where deptno = 20) and deptno = 20)
or
 (sapay=(select max(sapay) from sawon where deptno = 30) and deptno = 30)
or
 (sapay=(select max(sapay) from sawon where deptno = 40) and deptno = 40);
 
 
 
 ##��������̿��ؼ� �� �μ��� �ִ�޿��ڸ� ����
 select * from sawon s
 where sapay = (select max(sapay) from sawon where s.deptno=deptno);
 
 