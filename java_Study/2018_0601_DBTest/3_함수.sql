select sysdate �Դ�����,add_months(sysdate,21) �������� from dual;

select * from sawon;



   
        select sabun,saname,sahire,months_between(sysdate,sahire) �ٹ�����
        from sawon;



select sabun,saname,sahire,
		floor(mod(months_between(sysdate,sahire),12)) ��ü�ٹ�����,
		floor(months_between(sysdate,sahire)/12) �ٹ����,
		round(sapay/13 + 0.5,0) as ����,
		round(months_between(sysdate,sahire) * round(sapay/13 + 0.5,0)/12,0) as ������
from sawon;


