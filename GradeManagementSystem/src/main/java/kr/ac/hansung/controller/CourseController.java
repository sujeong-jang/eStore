package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

//servlet-context가 package를 스캔해서 @controller를 찾아서 빈등록
@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/credit")
	public String showCredit(Model model, 
			@RequestParam(value="one15", required=false)String one15,
			@RequestParam(value="two15", required=false)String two15,
			@RequestParam(value="one16", required=false)String one16,
			@RequestParam(value="two16", required=false)String two16,
			@RequestParam(value="one17", required=false)String one17,
			@RequestParam(value="one18", required=false)String one18,
			@RequestParam(value="two18", required=false)String two18) {
		
		if(one15 != null) {
			List<Course> course = courseService.getCourse(2015, 1);
			model.addAttribute("course", course);
			
			return "courses";
		}
		
		if(two15 != null) {
			List<Course> course = courseService.getCourse(2015, 2);
			model.addAttribute("course", course);
			
			return "courses";
		}
		if(one16 != null) {
			List<Course> course = courseService.getCourse(2016, 1);
			model.addAttribute("course", course);
			
			return "courses";
		}
		if(two16 != null) {
			List<Course> course = courseService.getCourse(2016, 2);
			model.addAttribute("course", course);
			
			return "courses";
		}
		if(one17 != null) {
			List<Course> course = courseService.getCourse(2017, 1);
			model.addAttribute("course", course);
			
			return "courses";
		}
		if(one18 != null) {
			List<Course> course = courseService.getCourse(2018, 1);
			model.addAttribute("course", course);
			
			return "courses";
		}
		if(two18 != null) {
			List<Course> course = courseService.getCourse(2018, 2);
			model.addAttribute("course", course);
			
			return "courses";
		}
		
		return "credit";
	}
	
	@RequestMapping("/courses")
	public String showCourse(Model model) {
		List<Course> course = courseService.getCurrent();
		model.addAttribute("course", course);
		
		return "courses";
	}
	 
	@RequestMapping("/createCourse")
	public String createCourse(Model model) {
		
		model.addAttribute("course", new Course());
		
		return "createCourse";
	}
	
	//course에 자동 바인딩됨
	@RequestMapping("/docreate")
	public String doCreate(Model model, Course course) {
		
		courseService.insert(course);
		return "coursecreated";
	}

}

