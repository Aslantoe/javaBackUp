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

	private static final long serialVersionUID = 1L;

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
	
	//显示全部书籍方法
	public String getAllBook(HttpServletRequest request,HttpServletResponse response){
		
		BookDao bd = new BookDao();
		List<Book> list = bd.getAllBook();
		request.setAttribute("bList", list);
		return "showAllBook.jsp";
	}
	
	//登录验证方法
	public String loginCheck(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
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
	public String loginCheck2(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		UserDao ud = new UserDao();
		User u = ud.loginCheck(name, pwd);
		if (u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			return "showOrderForm.jsp";
		}else{
		     return "showOrderForm.jsp";
		}
	}
	//通过id获取一本书,当点击书名时,触发此方法
	public String getBookById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Integer bid = Integer.valueOf(request.getParameter("bid"));
		BookDao bd = new BookDao();
		Book b = bd.getBookById(bid);
		
		if(b != null){
			request.setAttribute("book", b);
			return "showOneBook.jsp";
		}else{
			return "failed.jsp";
		}
	}
	
	//当点击添加到购物车时,触发此方法
	public String addToCart(HttpServletRequest request,HttpServletResponse response){
		CartDao cd = new CartDao();
		
		String bimgurl = request.getParameter("bimgurl");
		Integer bid = Integer.valueOf(request.getParameter("bid"));
		String btitle = request.getParameter("btitle");
		Double bprice = Double.valueOf(request.getParameter("bprice"));
		//判断,如果cart中有此书籍,bcount加一
		int newCount = 0;
		if(cd.getCartById(bid) != null){
			newCount = cd.getCartById(bid).getBcount() + 1;
			Cart c = new Cart(newCount, bid);
			cd.updateCart(c);
			return "indexCart.jsp";
		}//否则,将此书籍加到cart,bcount默认为1
		Cart c = new Cart(bimgurl, btitle, bprice, 1, bid);
		if(cd.addToCart(c)){
			return "indexCart.jsp";
		}
		return "failed.jsp";
	}
	
	//显示购物车列表,添加购物车成功后,通过return "indexCart.jsp";触发此方法
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
	//通过cid删除cart中的一条记录
	public String delCartById(HttpServletRequest request,HttpServletResponse response){
		Integer cid = Integer.valueOf(request.getParameter("cid"));
		CartDao cd = new CartDao();
		if(cd.delCartById(cid)){
		   return "indexCart.jsp";
		}else{
			return "failed.jsp";
		}
	}
	//在showCart.jsp页面中点击 “+”触发此方法,修改bcount 
	public String plusCart(HttpServletRequest request,HttpServletResponse response){
        Integer bid = Integer.valueOf(request.getParameter("bid"));
		CartDao cd = new CartDao();
		Integer newCount = cd.getCartById(bid).getBcount() + 1;
		Cart c = new Cart(newCount, bid);
		if(cd.updateCart(c)){
			return "indexCart.jsp";
		}else{
			return "failed.jsp";
		}
	}
	//在showCart.jsp页面中点击 “-”触发此方法,修改bcount 
	public String cutCart(HttpServletRequest request,HttpServletResponse response){
		CartDao cd = new CartDao();
        Integer bid = Integer.valueOf(request.getParameter("bid"));
    	Integer cid = Integer.valueOf(request.getParameter("cid"));
    	//判断  当bcount等于1的时候,删除此记录
        if( cd.getCartById(bid).getBcount() == 1){
        	if(cd.delCartById(cid)){
        		return "indexCart.jsp";
        	}
        	    return "failed.jsp";
        }
		Integer newCount = cd.getCartById(bid).getBcount() - 1;
		Cart c = new Cart(newCount, bid);
		if(cd.updateCart(c)){
			return "indexCart.jsp";
		}else{
			return "failed.jsp";
		}
	}
	
	public String addToOrderForm(HttpServletRequest request,HttpServletResponse response){
		Double totalPrice = Double.valueOf(request.getParameter("totalPrice"));
		
		HttpSession session = request.getSession();
		
		session.setAttribute("totalPrice", totalPrice);
		
		return "showOrderForm.jsp";
	}
	
	
	//*********************************************************************************
}
