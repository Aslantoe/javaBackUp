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
	
	//��ʾȫ���鼮����
	public String getAllBook(HttpServletRequest request,HttpServletResponse response){
		
		BookDao bd = new BookDao();
		List<Book> list = bd.getAllBook();
		request.setAttribute("bList", list);
		return "showAllBook.jsp";
	}
	
	//��¼��֤����
	public String loginCheck(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String str = "�û������������,�����µ�½!";
		
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
	//ͨ��id��ȡһ����,���������ʱ,�����˷���
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
	
	//�������ӵ����ﳵʱ,�����˷���
	public String addToCart(HttpServletRequest request,HttpServletResponse response){
		CartDao cd = new CartDao();
		
		String bimgurl = request.getParameter("bimgurl");
		Integer bid = Integer.valueOf(request.getParameter("bid"));
		String btitle = request.getParameter("btitle");
		Double bprice = Double.valueOf(request.getParameter("bprice"));
		//�ж�,���cart���д��鼮,bcount��һ
		int newCount = 0;
		if(cd.getCartById(bid) != null){
			newCount = cd.getCartById(bid).getBcount() + 1;
			Cart c = new Cart(newCount, bid);
			cd.updateCart(c);
			return "indexCart.jsp";
		}//����,�����鼮�ӵ�cart,bcountĬ��Ϊ1
		Cart c = new Cart(bimgurl, btitle, bprice, 1, bid);
		if(cd.addToCart(c)){
			return "indexCart.jsp";
		}
		return "failed.jsp";
	}
	
	//��ʾ���ﳵ�б�,��ӹ��ﳵ�ɹ���,ͨ��return "indexCart.jsp";�����˷���
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
	//ͨ��cidɾ��cart�е�һ����¼
	public String delCartById(HttpServletRequest request,HttpServletResponse response){
		Integer cid = Integer.valueOf(request.getParameter("cid"));
		CartDao cd = new CartDao();
		if(cd.delCartById(cid)){
		   return "indexCart.jsp";
		}else{
			return "failed.jsp";
		}
	}
	//��showCart.jspҳ���е�� ��+�������˷���,�޸�bcount 
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
	//��showCart.jspҳ���е�� ��-�������˷���,�޸�bcount 
	public String cutCart(HttpServletRequest request,HttpServletResponse response){
		CartDao cd = new CartDao();
        Integer bid = Integer.valueOf(request.getParameter("bid"));
    	Integer cid = Integer.valueOf(request.getParameter("cid"));
    	//�ж�  ��bcount����1��ʱ��,ɾ���˼�¼
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
