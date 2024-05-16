package springboot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public ModelAndView loadEmployeeForm(Employee employee) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("employee");
		
		List<Employee> empList = (List<Employee>) employeeRepository.findAll();
		mv.addObject("empList", empList);
		
		return mv;
	}
	
	@PostMapping("/insertEmployee")
	public ModelAndView insertEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println(employee);
		String msg ="";
		ModelAndView mv = new ModelAndView();
		
		
		try {
			employeeRepository.save(employee);
			msg ="Save Employee Details";
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		mv.setViewName("employee");
		List<Employee> empList = (List<Employee>) employeeRepository.findAll();
		mv.addObject("empList", empList);
		mv.addObject("msg", msg);
		
		return mv;
	}
	
	

	@GetMapping("/delete")
	public ModelAndView delete(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Employee employee = employeeRepository.findByEmpId(id);
		
		String msg="";
		try {
			employeeRepository.delete(employee);
			msg ="deleted Employee Details";
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		mv.addObject("msg", msg);
		mv.setViewName("employee");
		
		List<Employee> empList = (List<Employee>) employeeRepository.findAll();
		mv.addObject("empList", empList);
		
		return mv;
	}
	
	@GetMapping("/update")
	public ModelAndView update(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		Employee employee = employeeRepository.findByEmpId(id);
		mv.addObject("employee", employee);
		mv.setViewName("update");
		
		List<Employee> empList = (List<Employee>) employeeRepository.findAll();
		mv.addObject("empList", empList);
		
		return mv;
	}
	
	
	
	@PostMapping("/updateEmployee")
	public ModelAndView updateEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println(employee);
		String msg ="";
		ModelAndView mv = new ModelAndView();
		
		try {
			employeeRepository.save(employee);
			msg ="updated  Employee Details";
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		mv.setViewName("employee");
		List<Employee> empList = (List<Employee>) employeeRepository.findAll();
		mv.addObject("empList", empList);
		mv.addObject("msg", msg);
		
		return mv;
	}
	
	
}
