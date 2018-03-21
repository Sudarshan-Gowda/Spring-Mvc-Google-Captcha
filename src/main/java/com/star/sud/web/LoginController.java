package com.star.sud.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.star.sud.captch.StarCaptchaUtil;
import com.star.sud.form.LoginForm;
import com.star.sud.message.L2LMessage;
import com.star.sud.message.L2LMessageType;

@Controller
public class LoginController {

	protected static final String L2L_MESSAGE = "l2lMessage";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(Model model) {

		LoginForm loginForm = new LoginForm();
		model.addAttribute("loginPage", loginForm);
		return "login/login-page";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginValidation(Model model, HttpServletRequest request,
			@ModelAttribute("loginForm") LoginForm loginForm) {

		Boolean isValid = Boolean.FALSE;
		String gRecaptchaResp = request.getParameter("g-recaptcha-response");
		Boolean verify = StarCaptchaUtil.verify(gRecaptchaResp);

		if (loginForm != null && loginForm.getUserName() != null && loginForm.getPassword() != null) {

			if (loginForm.getUserName().equals("admin") && loginForm.getPassword().equals("test")) {
				isValid = Boolean.TRUE;
			}

		}

		if (verify && isValid) {
			return "login/welcome";
		}
		List<L2LMessage> scrnMessages = new ArrayList<L2LMessage>();
		String msg = "";
		if (verify) {
			msg = "Invalid Credentails!";
		} else {
			msg = "You missed the captch";
		}

		L2LMessage l2lMsg = new L2LMessage("", "" + msg, L2LMessageType.ERROR);
		scrnMessages.add(l2lMsg);
		model.addAttribute(L2L_MESSAGE, scrnMessages);
		return "login/login-page";

	}

}
