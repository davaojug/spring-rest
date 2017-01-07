package com.journaldev.spring.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.model.Employee;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	//Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	
	@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee() {
		logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setCreatedDate(new Date());
		empData.put(9999, emp);
		return emp;
	}
	
	/**@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP2, method = RequestMethod.POST)
	public @ResponseBody Employee getDummyEmployee2(@RequestBody final HashMap<String, String> pParamMap) {
		try {
			logger.info("Start getDummyEmployee2");
			Iterator<String> keySetIterator = pParamMap.keySet().iterator();
			
			while(keySetIterator.hasNext()) { 
				String key = keySetIterator.next(); 
				System.out.println("key: " + key + " value: " + pParamMap.get(key)); 
			}

			String id = pParamMap.get("id");
			String name = pParamMap.get("name");
			String createdDate = pParamMap.get("createdDate");
			Date d = new Date(Long.valueOf(createdDate).longValue());
			
			Employee emp = new Employee();
			emp.setId(9999);
			emp.setName("Dummy");
			emp.setCreatedDate(new Date());
			empData.put(9999, emp);
			return emp;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}*/

	
	@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP2, method = RequestMethod.POST)
	public @ResponseBody Employee getDummyEmployee2(@RequestBody final HashMap<String, String> pParamMap) {
		try {
			logger.info("Start getDummyEmployee2");
			Iterator<String> keySetIterator = pParamMap.keySet().iterator();
			
			while(keySetIterator.hasNext()) { 
				String key = keySetIterator.next(); 
				System.out.println("key: " + key + " value: " + pParamMap.get(key)); 
			}

			String id = pParamMap.get("id");
			String name = pParamMap.get("name");
			String createdDate = pParamMap.get("createdDate");
			Date d = new Date(Long.valueOf(createdDate).longValue());
			
			Employee emp = new Employee();
			emp.setId(Integer.valueOf(id));
			emp.setName(name);
			emp.setCreatedDate(d);
			empData.put(Integer.valueOf(id), emp);
			return emp;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	
	
	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		logger.info("Start getEmployee. ID="+empId);
		
		return empData.get(empId);
	}
	
	@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {
		logger.info("Start getAllEmployees.");
		List<Employee> emps = new ArrayList<Employee>();
		Set<Integer> empIdKeys = empData.keySet();
		for(Integer i : empIdKeys){
			emps.add(empData.get(i));
		}
		return emps;
	}
	
	@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
		logger.info("Start createEmployee.");
		emp.setCreatedDate(new Date());
		empData.put(emp.getId(), emp);
		return emp;
	}
	
	/**@RequestMapping(value = EmpRestURIConstants.CREATE_EMP_MAP, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployeeMap(@RequestBody final HashMap<String, String> pParamMap) {
	public @ResponseBody String createEmployeeMap(@RequestBody final HashMap<String, String> pParamMap) {
		logger.info("Start createEmployee.");
		emp.setCreatedDate(new Date());
		empData.put(emp.getId(), emp);
		return emp;

		Set set<String,String> = pParamMap.entrySet();
		Iterator i = set.iterator();
		 Display elements
		while(i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}		
		return "createEmployeeMap";
	}

	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("RESTRequest{");
        sb.append(",parameters=[");
        boolean first = true;
        for(Map.Entry<String,Object[]> entry: empData.entrySet()) {
            if(first) {
                first = false;
            } else {
                sb.append(", ");
            }
            sb.append(entry.getKey()).append('=').append(Arrays.asList(entry.getValue()));
        }
        sb.append("]}");
        return sb.toString();
    }*/
	
	@RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
		logger.info("Start deleteEmployee.");
		Employee emp = empData.get(empId);
		empData.remove(empId);
		return emp;
	}
	
}
