package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	public CustomerController() {
		System.out.println("in const of "+getClass().getName());
	}
	
	@GetMapping("/bank_login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/customer/bank_login";// actual view name : /WEB-INF/views/customer/bank_login.jsp
	}
	@PostMapping("/bank_login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map,
			HttpSession session) {
		System.out.println("in process login form");
		try {
			// invoke service layer method
			Customer validatedCustomer = customerService.validateCustomer(email, password);
			// valid login : add the validated customer details under model map(saved in request
			// scope)
			session.setAttribute("customer_details", validatedCustomer);
			return "redirect:/customer/account_summary";

		} catch (RuntimeException e) {
			e.printStackTrace();
			// invalid login --forward the clnt to login.jsp
			map.addAttribute("message", "Invalid Login ! Pls retry....");
			return "/customer/bank_login";// actual view name : /WEB-INF/views/user/login.jsp
		}

	}
	
	@GetMapping("/reg_form")
	public String showRegistrationForm(Customer customer) {
		System.out.println("in show registration form "+customer);
		return "/customer/reg_form";// actual view name : /WEB-INF/views/customer/reg_form.jsp
	}
	
	@PostMapping("/reg_form")
	public String processRegistrationForm(Customer customerDetails,RedirectAttributes flashMap) {
		System.out.println("in process registration form "+customerDetails);
		//session.setAttribute("customer_details",customerService.registerCustomer(customerDetails));
		flashMap.addFlashAttribute("customer_details",customerService.registerCustomer(customerDetails));
		return "redirect:/customer/bank_login";// actual view name : /WEB-INF/views/customer/bank_login.jsp
	}
	@GetMapping("/account_summary")
	public String showAccountSummary()
	{
		System.out.println("in show account summary ");
		return "/customer/account_summary";
	}
	
	
	
}
