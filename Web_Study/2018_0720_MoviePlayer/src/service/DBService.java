package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;


public class DBService {

	DataSource ds;
	BasicDataSource ds1;

	// single-ton pattern: 1���� ��ü�� �����ؼ� ��������
	static DBService single = null;

	public static DBService getInstance() {
		if (single == null)
			single = new DBService();
		return single;
	}

	public DBService() {
		// TODO Auto-generated constructor stub
		// JNDI(Java Naming Directory(Ž��) Interface)�� ��ϵ� �ڿ������� ȹ��
		try {
			// 1. �ڿ��� Ž���� ��ü�� ����
			InitialContext ic = new InitialContext();
			// 2. �ڿ��� �����ϰ� �ִ� Context������ ȹ��
			Context context = (Context) ic.lookup("java:comp/env");
			// 3. Context���� �ִ� ���� ȹ��
			ds = (DataSource) context.lookup("jdbc/oracle_test");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			// JNDI�� ���ؼ� ȹ���� DataSource�� ���� Ŀ�ؼ��� ���´�.
			conn = ds.getConnection();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

}
