package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDAO {
	private JdbcTemplate jdbcTemplate;

	// 어노테이션을 사용하려면 beans.xml에서 annotation-config를 추가해 줘야한다
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// sql문 실행
	public int getRowCount() {
		String sqlStatment = "select count(*) from course";

		return jdbcTemplate.queryForObject(sqlStatment, Integer.class);
	}

	// 학기별 수강과목 조회
	public List<Course> getSemester(int year, int semester) {
		String sqlStatement = "select * from course where year=? and semester=?";

		return jdbcTemplate.query(sqlStatement, new Object[] {year, semester}, new RowMapper<Course>() {

			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setName(rs.getString("name"));
				course.setYear(rs.getInt("year"));
				course.setCode(rs.getString("code"));
				course.setCredit(rs.getInt("credit"));
				course.setLevel(rs.getString("level"));
				course.setSemester(rs.getInt("semester"));

				return course;
			}
		});
	}
	
	// 학기별 수강과목 조회
	public List<Course> getCourse() {
		String sqlStatement = "select * from course where year=2019 and semester=1";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course1 = new Course();
				course1.setName(rs.getString("name"));
				course1.setYear(rs.getInt("year"));
				course1.setCode(rs.getString("code"));
				course1.setCredit(rs.getInt("credit"));
				course1.setLevel(rs.getString("level"));
				course1.setSemester(rs.getInt("semester"));

				return course1;
			}
		});
	}
	
	
	
	//여러개 레코드 조회
	public List<Course> getCourses() {
		String sqlStatement = "select * from course";

		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setName(rs.getString("name"));
				course.setYear(rs.getInt("year"));
				course.setCode(rs.getString("code"));
				course.setCredit(rs.getInt("credit"));
				course.setLevel(rs.getString("level"));
				course.setSemester(rs.getInt("semester"));

				return course;
			}
		});
	}
	
	public boolean insert(Course course) {
		String name = course.getName();
		int year = course.getYear();
		String code = course.getCode();
		int credit = course.getCredit();
		String level = course.getLevel();
		int semester = course.getSemester();
		
		String sqlStatement = "insert into course (year, semester, code, name, level, credit) values (?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, level, credit}) == 1);
	}
	
	public boolean update(Course course) {
		String name = course.getName();
		int year = course.getYear();
		String code = course.getCode();
		int credit = course.getCredit();
		String level = course.getLevel();
		int semester = course.getSemester();
		
		String sqlStatement = "update course set year=?, semester=?, code=?, level=?, credit=? where name=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, name, level, credit}) == 1);
	}
	
	public boolean delete(String name) {
		String sqlStatement = "delete from course where name=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {name}) == 1);
	}
}
