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
import com.app.pojos.Account;
import com.app.pojos.Customer;
import com.app.service.IAccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private IAccountService accountService;
	
	public AccountController() {
		System.out.println("in cont of "+getClass().getName());
	}
	
	@GetMapping("/add_account")
	public String showAccountForm(Account account) {
		System.out.println("in show account form "+account);
		return "/account/add_account";// actual view name : /WEB-INF/views/account/add_account.jsp
	}
	@PostMapping("/add_account")
	public String processAccountForm(Account accountDetails, Model map,RedirectAttributes flashMap,HttpSession session) {
		System.out.println("in process registration form "+accountDetails);
		Customer user = (Customer) session.getAttribute("customer_details");
		if (user == null) {
			session.invalidate();
			return "redirect:/customer/bank_login";
		}
		//session.setAttribute("customer_details",customerService.registerCustomer(customerDetails));
		flashMap.addFlashAttribute("account_details",accountService.addAccount(accountDetails,user.getUsername()));
		return "redirect:/customer/account_summary";// actual view name : /WEB-INF/views/customer/bank_login.jsp
	}
	
}
