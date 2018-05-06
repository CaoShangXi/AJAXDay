package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Stock;
import net.sf.json.JSONArray;

public class ActionServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ������������Ľ��뷽ʽ
		req.setCharacterEncoding("utf-8");
		// ������Ӧ���뷽ʽ
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		// ��ȡ������Դ·��
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if (path.equals("/get_text")) {// get����
			// ��ȡ·���������
			String name = req.getParameter("name");
			out.println("���Զ�������!!!");
			System.out.println(name);
		} else if (path.equals("/post_text")) {// post����
			// ��ȡ·���������
			String name = req.getParameter("uname");
			System.out.println(name);
			out.println("post����ɹ�!!" + name);
		} else if (path.equals("/check_name")) {
			String name = req.getParameter("uname");
			if (1 == 1) {
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(name);
			if (name.equals("����")) {
				out.println("���û����ѱ�ע��!!!");
			} else {
				out.println("����ʹ��!!!");
			}

		} else if (path.equals("/getCity")) {// ���������б�
			String val = req.getParameter("val");
			System.out.println(val);
			if (val.equals("bj")) {// ����
				out.println("�йش�,zgc;����,hd;����,cy");
			} else if (val.equals("sh")) {// �Ϻ�
				out.println("����,ja;����,hp;�ֶ���,pdx");
			} else if (val.equals("sz")) {// ����
				out.println("����,ba;����,ft;����,lg;����,yt");
			}
			// jquery��AJAX��֧��
		} else if (path.equals("/salary")) {
			String val = req.getParameter("eId");
			if (val.equals("T001")) {
				out.println("ʵ�ʹ���:��10000<br/>��˰:2500");
			} else {
				out.println("ʵ�ʹ���:��20000<br/>��˰:5000");
			}
		} else if (path.equals("/quoto")) {
			Random r = new Random();
			List<Stock> stocks = new ArrayList<Stock>();
			for (int i = 0; i < 8; i++) {
				Stock s = new Stock();
				s.setCode("6001" + r.nextInt(10));
				s.setName("�й���ó" + r.nextInt(10));
				DecimalFormat df = new DecimalFormat("0.00");
				double price = Double.parseDouble(df.format(100 * r.nextDouble()));
				s.setPrice(price);
				stocks.add(s);

			}
			//������תΪJSON����
			JSONArray jsonarr=JSONArray.fromObject(stocks);
			//������תΪJSON�ַ���
			String jsonstr=jsonarr.toString();
			System.out.println(jsonstr);
			out.println(jsonstr);
		}

		out.close();
	}
}
