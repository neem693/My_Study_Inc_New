package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVo;

public class ProductDao {
	
	//single-ton pattern: 1���� ��ü�� �����ؼ� ��������
	static ProductDao single = null;
	SqlSessionFactory factory;

	public static ProductDao getInstance() {
		if (single == null)
			single = new ProductDao();
		return single;
	}

	public ProductDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//ī�װ��� ��ǰ���
	
	public List<ProductVo> selectList(String category){
		List<ProductVo> list = null;
		System.out.println();
		SqlSession session = factory.openSession();
		list = session.selectList("product.product_list",category);
		session.close();
		
		
		return list;
	}

	public int insert(ProductVo vo) {
		// TODO Auto-generated method stub
		int res =0;
		
		SqlSession session = factory.openSession(true);
		res = session.insert("product.product_insert",vo);
		session.close();
		
		return res;
	}
	
	
	

}
