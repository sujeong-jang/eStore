package kr.ac.hansung.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
		
		private int year;
		
		private int semester;
		
		private String code;
		
		private String name;
		
		private String level;

		private int credit;

}
