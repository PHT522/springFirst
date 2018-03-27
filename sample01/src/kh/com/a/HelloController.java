package kh.com.a;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller		// <- Annotation 주석문, 무조건 컨트롤러 오게함!!
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	/*
	@RequestMapping("/hello")
	public ModelAndView hello() {
		
		System.out.println("HelloController hello");
		
		ModelAndView v = new ModelAndView();
		v.setViewName("/helloSpring");	// helloSpring.jsp를 찾는다 
		
		return v;
	}
	//.do 아래에 적용
	*/ 
	
	@RequestMapping(value="login.do", method=RequestMethod.GET) //value값 컨트롤러명칭
	public String login(Model model) {	/*Model:인터페이스*/
	//public String login(Model model, HttpServletRequest req) {
		//HttpServletRequest req를 위에 붙이면 requset를 받아올수 있다...
	//	model.addAttribute(attributeName, attributeValue) // setattribute와같다
		
		logger.info("HelloController login.do");
		
		int amount = 1001;
		double balance = 10000;
		
		logger.info("amount:{}, balance:{}", amount, balance);
		
		
		
		//System.out.println("HelloController login.do");
		
		return "helloSpring";	// helloSpring.jsp로 쭉간다...
	}
	
}
