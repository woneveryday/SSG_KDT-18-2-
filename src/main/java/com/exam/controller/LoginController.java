package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;

@Controller
public class LoginController {

	Logger logger = LoggerFactory.getLogger(getClass());

	MemberService memberService;

	public LoginController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping(value={"/login"})
	public String showLoginPage() {
		return "loginForm";
	}
	
	@PostMapping(value={"/login_fail"})
	public String showlogin_failPage(RedirectAttributes redirectAttributes) {
		logger.info("logger:showlogin_failPage");
		redirectAttributes.addFlashAttribute("loginFailed", true);
		return "redirect:login";
	}
	
	@GetMapping(value={"/login_success"})
	   public String showlogin_successPage(HttpSession session) {
	      logger.info("logger:showlogin_successPage");
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof MemberDTO) {
	            MemberDTO user = (MemberDTO) auth.getPrincipal();
	            session.setAttribute("userId", user.getUserId());
	        }
	      return "redirect:main";
	   }
	 @GetMapping("/checkLoginStatus")
	    public Map<String, Boolean> checkLoginStatus() {
	        Map<String, Boolean> response = new HashMap<>();
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        response.put("loggedIn", auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal()));
	        return response;
	    }
	
}