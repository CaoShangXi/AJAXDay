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
		// 设置请求过来的解码方式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码方式
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		// 获取请求资源路径
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if (path.equals("/get_text")) {// get请求
			// 获取路径请求参数
			String name = req.getParameter("name");
			out.println("来自东方的你!!!");
			System.out.println(name);
		} else if (path.equals("/post_text")) {// post请求
			// 获取路径请求参数
			String name = req.getParameter("uname");
			System.out.println(name);
			out.println("post请求成功!!" + name);
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
			if (name.equals("中文")) {
				out.println("该用户名已被注册!!!");
			} else {
				out.println("可以使用!!!");
			}

		} else if (path.equals("/getCity")) {// 下拉城市列表
			String val = req.getParameter("val");
			System.out.println(val);
			if (val.equals("bj")) {// 北京
				out.println("中关村,zgc;海淀,hd;朝阳,cy");
			} else if (val.equals("sh")) {// 上海
				out.println("静安,ja;黄埔,hp;浦东新,pdx");
			} else if (val.equals("sz")) {// 深圳
				out.println("宝安,ba;福田,ft;龙岗,lg;盐田,yt");
			}
			// jquery对AJAX的支持
		} else if (path.equals("/salary")) {
			String val = req.getParameter("eId");
			if (val.equals("T001")) {
				out.println("实际工资:￥10000<br/>个税:2500");
			} else {
				out.println("实际工资:￥20000<br/>个税:5000");
			}
		} else if (path.equals("/quoto")) {
			Random r = new Random();
			List<Stock> stocks = new ArrayList<Stock>();
			for (int i = 0; i < 8; i++) {
				Stock s = new Stock();
				s.setCode("6001" + r.nextInt(10));
				s.setName("中国国贸" + r.nextInt(10));
				DecimalFormat df = new DecimalFormat("0.00");
				double price = Double.parseDouble(df.format(100 * r.nextDouble()));
				s.setPrice(price);
				stocks.add(s);

			}
			//将集合转为JSON数组
			JSONArray jsonarr=JSONArray.fromObject(stocks);
			//将数组转为JSON字符串
			String jsonstr=jsonarr.toString();
			System.out.println(jsonstr);
			out.println(jsonstr);
		}

		out.close();
	}
}
