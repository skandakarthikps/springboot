
package com.dutta.sai.power.solution.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.dutta.sai.power.solution.entity.BranchDetails;
import com.dutta.sai.power.solution.entity.BranchPayment;
import com.dutta.sai.power.solution.entity.Employee;

@RestController
@RequestMapping("/main")
@EnableConfigurationProperties
public class DPSController {

	@Bean
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}

	@Value("${CGST}")
	private int cgst;
	@Value("${SGST}")
	private int sgst;

	@GetMapping
	public ModelAndView mainPage() {

		return new ModelAndView("mainPage");
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contactPage() {

		return new ModelAndView("contact");
	}

	@RequestMapping(value = "/employeeService")
	public ModelAndView employeePage(Model model) {

		model.addAttribute("employees",
				Arrays.asList(restTemplate().getForObject("http://localhost:8010/allEmployees", Employee[].class)));
		return new ModelAndView("employeeMain");
	}

	@RequestMapping(value = "/addEmployee")
	public ModelAndView addEmployee(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return new ModelAndView("addNewEmployee");
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addNewEmployee(@ModelAttribute("employee") Employee employee) {

		System.out.println("Inside addNewEmployee method");
		restTemplate().postForEntity("http://localhost:8010/addEmployee", employee, Employee.class);
		return new ModelAndView("redirect:/employeeService");
	}

	@RequestMapping(value = "/employees/edit/{id}")
	public ModelAndView updateEmployee(@PathVariable("id") long id, Model model) throws ParseException {

		Employee employee = restTemplate().getForEntity("http://localhost:8010/employees/" + id, Employee.class)
				.getBody();
		model.addAttribute("employee", employee);
		return new ModelAndView("updateEmployee");
	}

	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.POST)
	public ModelAndView updateExistingEmployee(@PathVariable("id") long id,
			@ModelAttribute("employee") Employee employee) {

		Employee updatemp = employee;
		updatemp.setEmpId(id);
		restTemplate().postForEntity("http://localhost:8010/employee/update", updatemp, Employee.class);
		return new ModelAndView("redirect:/employeeService");
	}

	@RequestMapping(value = "/employees/delete/{id}")
	public ModelAndView deleteEmployee(@PathVariable("id") long id) {

		restTemplate().getForObject("http://localhost:8010/employee/delete/" + id, long.class);
		return new ModelAndView("redirect:/employeeService");
	}

	@RequestMapping(value = "/branchService")
	public ModelAndView branchPage(Model model) {

		model.addAttribute("branches", Arrays
				.asList(restTemplate().getForObject("http://localhost:8020/allActiveBranches", BranchDetails[].class)));
		return new ModelAndView("branchMain");
	}

	@RequestMapping(value = "/addBranch")
	public ModelAndView addBranch(Model model) {

		BranchDetails branch = new BranchDetails();
		model.addAttribute("branch", branch);
		return new ModelAndView("addNewBranch");
	}

	@RequestMapping(value = "/addBranch", method = RequestMethod.POST)
	public ModelAndView addNewBranch(@ModelAttribute("branch") BranchDetails branch) {

		branch.setStatus("Active");
		branch.setBranchStartDate(new SimpleDateFormat("yyy-MM-dd").format(new Date()));
		restTemplate().postForEntity("http://localhost:8020/addBranch", branch, BranchDetails.class);
		return new ModelAndView("redirect:/branchService");
	}

	@RequestMapping(value = "/branch/edit/{id}")
	public ModelAndView updateBranch(@PathVariable("id") int dpCode, Model model) {

		model.addAttribute("branch",
				restTemplate().getForObject("http://localhost:8020/branch/" + dpCode, BranchDetails.class));
		return new ModelAndView("updateBranch");
	}

	@RequestMapping(value = "/updateBranch/{id}", method = RequestMethod.POST)
	public ModelAndView updateExistingBranch(@PathVariable("id") int id,
			@ModelAttribute("branch") BranchDetails branch) {

		System.out.println(branch.toString());
		BranchDetails updateBranch = branch;
		updateBranch.setDpcode(id);
		restTemplate().postForEntity("http://localhost:8020/branch/update", updateBranch, BranchDetails.class);
		return new ModelAndView("redirect:/branchService");
	}

	@RequestMapping(value = "/allBranches")
	public ModelAndView allBranches(Model model) {

		model.addAttribute("branches",
				Arrays.asList(restTemplate().getForObject("http://localhost:8020/allBranches", BranchDetails[].class)));
		return new ModelAndView("allBranches");
	}

	@RequestMapping(value = "/paymentService")
	public ModelAndView paymentServicePage(Model model) {

		model.addAttribute("branches", Arrays
				.asList(restTemplate().getForObject("http://localhost:8020/allActiveBranches", BranchDetails[].class))
				.stream().map(BranchDetails::getBranch_name).collect(Collectors.toList()));
		return new ModelAndView("paymentPage");
	}

	@RequestMapping(value = "/addBranchPayment", method = RequestMethod.POST)
	public ModelAndView branchPaymentUpdate(@RequestBody String branchName, Model model) {

		System.out.println("From DPS COntroller: " + branchName.toString());
		BranchPayment branchPayment = new BranchPayment();
		BranchDetails branch = restTemplate().getForObject(
				"http://localhost:8020/getBranchByName/" + branchName.substring(branchName.indexOf("=") + 1),
				BranchDetails.class);
		System.out.println("From DPS COntroller: " + branch.toString());
		branchPayment.setDpcode(branch.getDpcode());
		branchPayment.setBranch_name(branch.getBranch_name());
		branchPayment.setLocation(branch.getLocation());
		branchPayment.setDgDetails(branch.getDgMake() + "_" + branch.getDgKVA() + " KVA");
		branchPayment.setOldReading(branch.getCurrentReading());
		branchPayment.setBasicAmount(branch.getBasicAmount());
		branchPayment.setExtraHrRate(branch.getExtraHrsRate());
		branchPayment.setExtraHoursAmount(new BigDecimal(BigInteger.ZERO));
		branchPayment.setExtraHours(Integer.parseInt("0"));
		branchPayment.setCgst(cgst);
		branchPayment.setSgst(sgst);
		branchPayment.setTotalAmount(new BigDecimal(BigInteger.ZERO));

		model.addAttribute("branch", branchPayment);
		return new ModelAndView("addBranchPayment");
	}
}
