package kr.ac.hansung.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
//@Component 빈으로 등록해주는 어노테이션
@Controller //@Component의 기능도 해주면서(빈 등록 후) 컨트롤러라는 것도 명시
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showhome(Locale locale, Model model) {

		return "home";
	}
}
