package kh.com.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller		// <- Annotation 주석문, 무조건 컨트롤러 오게함!!
public class HelloController {

	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		
		System.out.println("HelloController hello");
		
		ModelAndView v = new ModelAndView();
		v.setViewName("/helloSpring");	// helloSpring.jsp를 찾는다 
		
		return v;
	}
	
	
	
}
