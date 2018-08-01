package vo;

import java.util.List;

/*
 VO : Value Object
 1.�������̸� DB�ʵ��� ������ �Ӽ����� ���
 2.�Ӽ�(����)�� ���� getter/setter�����ض�

 */

public class SawonVo {
	int year;
	int sabun, deptno, sapay, samgr;
	String saname, sasex, sajob, sahire;
	List<GogekVo> gogek_list;

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getSapay() {
		return sapay;
	}

	public void setSapay(int sapay) {
		this.sapay = sapay;
	}

	public int getSamgr() {
		return samgr;
	}

	public void setSamgr(int samgr) {
		this.samgr = samgr;
	}

	public String getSaname() {
		return saname;
	}

	public void setSaname(String saname) {
		this.saname = saname;
	}

	public String getSasex() {
		return sasex;
	}

	public void setSasex(String sasex) {
		this.sasex = sasex;
	}

	public String getSajob() {
		return sajob;
	}

	public void setSajob(String sajob) {
		this.sajob = sajob;
	}

	public String getSahire() {
		return sahire;
	}

	public void setSahire(String sahire) {
		this.year = Integer.parseInt(sahire.substring(0, 4));
		this.sahire = sahire;
	}

	public List<GogekVo> getGogek_list() {
		return gogek_list;
	}

	public void setGogek_list(List<GogekVo> gogek_list) {
		this.gogek_list = gogek_list;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	

}
