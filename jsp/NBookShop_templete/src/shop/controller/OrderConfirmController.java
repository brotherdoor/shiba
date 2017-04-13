package shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.domain.Order;
import shop.domain.PaymentMethod;
import shop.service.facade.CustomerService;
import shop.service.facade.ProductService;
import shop.service.logic.CustomerServiceLogic;
import shop.service.logic.ProductServiceLogic;

@WebServlet("/oderConfirm.do")
public class OrderConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String [] serials = request.getParameterValues("serials");
		String userId = (String)request.getSession().getAttribute("userId");
		String approval = request.getParameter("approval");
		String shipAddress = request.getParameter("shipAddress");
		
		CustomerService customerService = new CustomerServiceLogic();
		ProductService productService = new ProductServiceLogic();
		Order order = new Order();
		
		order.setCustomer(customerService.getCustomer(userId));
		order.setShipAddress(shipAddress);
		order.setPayment(PaymentMethod.findBy(approval));
		for(String s : serials){
			order.addProduct(productService.getProduct(s));
		}
		
		request.setAttribute("order", order);
		request.getRequestDispatcher("orderConfirm.jsp").forward(request, response);
	}

}
