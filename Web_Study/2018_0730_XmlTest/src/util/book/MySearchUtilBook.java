package util.book;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import vo.book.BookVo;

public class MySearchUtilBook {

	public static List<BookVo> search_shop(String b_name, int start, int display, String sort) {
		List<BookVo> list = new ArrayList<BookVo>();
		String clientId = "lKpHdFQuD5R1OIRYERy9";
		String clientSecret = "aTCtJgB9Pp";

		try {
			b_name = URLEncoder.encode(b_name, "utf-8");
			String urlStr = String.format(
					"https://openapi.naver.com/v1/search/book.xml?query=%s&start=%d&display=%d&sort=%s", b_name, start,
					display, sort);

			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// �߱޹��� ID
			connection.setRequestProperty("X-Naver-Client-Id", clientId);
			// �߱޹��� PW
			connection.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			// ������ûŸ��
			connection.setRequestProperty("Content-Type", "application/xml");
			connection.connect();

			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(connection.getInputStream());

			Element root = doc.getRootElement();
			List<Element> element_list = (List<Element>) root.getChild("channel").getChildren("item");

			for (Element item : element_list) {
				String title = item.getChildText("title");
				String link = item.getChildText("link");
				String image = item.getChildText("image");
				String author = item.getChildText("author");
				String publisher = item.getChildText("publisher");
				int price = 0, discount = 0;
				try {
					price = Integer.parseInt(item.getChildText("price"));
					discount = Integer.parseInt(item.getChildText("discount"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
				String pubdate = item.getChildText("pubdate");

				// ��ǰ����� ����
				BookVo vo = new BookVo();
				vo.setTitle(title);
				vo.setLink(link);
				vo.setImage(image);
				vo.setAuthor(author);
				vo.setPublisher(publisher);
				vo.setPrice(price);
				vo.setDiscount(discount);
				vo.setPubdate(pubdate);

				// ArrayList�� �ֱ�
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
