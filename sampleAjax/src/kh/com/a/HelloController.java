package kh.com.a;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//1번
	@RequestMapping(value="login.do", method=RequestMethod.GET) //value값 컨트롤러명칭
	public String login(Model model) {	/*Model:인터페이스*/
	//public String login(Model model, HttpServletRequest req) {
		//HttpServletRequest req를 위에 붙이면 requset를 받아올수 있다...
	//	model.addAttribute(attributeName, attributeValue) // setattribute와같다
		
		logger.info("HelloController login.do");
		
		MyClass cls = new MyClass();
		cls.setNumber(1001);
		cls.setName("홍길동");
		
		model.addAttribute("mycls", cls);		
		
		
		/*int amount = 1001;
		double balance = 10000;
		
		logger.info("amount:{}, balance:{}", amount, balance);*/
		
		
		
		//System.out.println("HelloController login.do");
		
		return "helloSpring";	// helloSpring.jsp로 쭉간다...
	}
	
	// 2번
	@RequestMapping(value="inputData.do", method=RequestMethod.GET)
	public String inputData(MyClass cls, Model model) {	//그냥 넣어줘도 변수명만 맞추어주면 
		
		logger.info(cls.toString()); // 확인
		
		model.addAttribute("mycls", cls);
		
		return "helloSpring";		// view찾아가는 용도
	}
	
	
	// 3번 id하나만 지금은 넘어온다.. 파라미터 1나 따라서 String으로 받자
	@ResponseBody		//ajax를 사용시에는 반드시 붙여준다!!!!
	@RequestMapping(value="idcheck.do",
					produces="application/String; charset=utf8",
					method=RequestMethod.GET)
	public String idcheck(String id) {
		System.out.println("id:"+id);
		
		// id 확인 부분 필요
		
		String str = "오케이";	//한글 깨진다 웹에서 받을떄는 web.xml에 설정했지만
								// 보낼때는 java에서 보내기때문에 설정(produces)이 필요하고
								// helloSpring.jsp에서 mvc2개 추가해야한다..
		
		return str;	// 값을 얻어오는 용도		
		// ajax jsp찾아가는게 아니고 그냥 보내주는 역활...이동한것이아니다..비동기
	}
	
	
	// 4번 Map으로 넘기기
	@ResponseBody		//ajax를 사용시에는 반드시 붙여준다!!!!
	@RequestMapping(value="account.do",	method=RequestMethod.POST)
	public Map<String, Object> account(Dto dto){	// Model 필요없다.. attribute로 보내줄때 필요하므로
		
		System.out.println(dto.toString());
		
		Map<String, Object> rmap = new HashMap<String, Object>();		
		rmap.put("msg", "메세지를 보냅니다");		
		
		return rmap;		
	}
	
	// 5번 Map형태로 받기 consol확인해보자
	@ResponseBody		//ajax를 사용시에는 반드시 붙여준다!!!!
	@RequestMapping(value="updateUser.do",	method=RequestMethod.POST)
	public Map<String, Object> updateUser(@RequestBody Map<String, Object> params){
		
		System.out.println(params.get("name"));
		System.out.println(params.get("tel"));
		System.out.println(params.get("email"));
		System.out.println(params.get("birth"));
		
		Map<String, Object> rmap = new HashMap<String, Object>();		
		rmap.put("msg", "메세지를 보냅니다");		
		
		return rmap;
	}
	
	
	
	
}
