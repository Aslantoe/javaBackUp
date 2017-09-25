package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import dao.CartDao;
import dao.UserDao;
import entity.Book;
import entity.Cart;
import entity.User;

public class ShopServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		try {
			
			Method method = this.getClass().getDeclaredMethod
			(action, new Class[]{HttpServletRequest.class,HttpServletResponse.class});
			String url = (String)method.invoke(this, new Object[]{request,response});
		    request.getRequestDispatcher(url).forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAllBook(HttpServletRequest request,HttpServletResponse response){
		
		BookDao bd = new BookDao();
		List<Book> list = bd.getAllBook();
		request.setAttribute("bList", list);
		return "showAllBook.jsp";
	}
	
	
	public String loginCheck(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String str = "用户名或密码错误,请重新登陆!";
		
		UserDao ud = new UserDao();
		User u = ud.loginCheck(name, pwd);
		if (u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			return "index.jsp";
		}else{
			request.setAttribute("msg", str);
		    return "index.jsp";
		}
	}
	
	public String getBookById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Integer bid = Integer.valueOf(request.getParameter("bid"));
		BookDao bd = new BookDao();
		Book b = bd.getBookById(bid);
		
		if(b != null){
			request.setAttribute("book", b);
			return "showOneBook.jsp";
		}
		return "";
	}
	
	public String addToCart(HttpServletRequest request,HttpServletResponse response){
		String bimgurl = request.getParameter("bimgurl");
		Integer bid = Integer.valueOf(request.getParameter("bid"));
		String btitle = request.getParameter("btitle");
		
		//
		
		Cart c = new Cart(btitle, bimgurl, 1, bid);
		CartDao cd = new CartDao();
		if(cd.addToCart(c)){
			return "indexCart.jsp";
		}
		return "";
	}
	
	
	public String showCart(HttpServletRequest request,HttpServletResponse response){
		CartDao cd = new CartDao();
		List<Cart> list = cd.showCart();
		if(list.size() > 0){
			request.setAttribute("cList", list);
			return "showCart.jsp";
		}else{
			return "failed.jsp";
		}
		
	}
	
}
