package com.ra.controller;

import com.ra.model.entity.Employee;
import com.ra.model.service.EmployServiceImpl;
import com.ra.model.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "employeeController",value = "/employee")
public class EmployeeController extends HttpServlet {
    private static EmployeeService employeeService=new EmployServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action=req.getParameter("action");
       if (action==null){
           action="";
       }
           switch (action){
               case "add":
                   resp.sendRedirect("views/add-employee.jsp");
                   break;
               case "edit":
                   int idEdit= Integer.parseInt(req.getParameter("id"));
                   Employee employee=employeeService.findById(idEdit);
                   req.setAttribute("employeee",employee);
                   req.getRequestDispatcher("views/edit-employee.jsp").forward(req,resp);

                   break;
                   case "delete":
                       int idDelete= Integer.parseInt(req.getParameter("id"));
                       employeeService.findById(idDelete);
                       employeeService.delete(idDelete);
                       showEmployee(req,resp);
                       break;
               default:
                   showEmployee(req,resp);
                   break;

       }
    }
    private void showEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee>employeeList=employeeService.findAll();
        req.setAttribute("employeeList",employeeList);
        req.getRequestDispatcher("views/employee.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action=req.getParameter("action");
       if (action==null){
           action="";
       }
       switch (action){
           case "add":
               actionAdd(req,resp);
               break;
           case "edit":
               actionEdit(req,resp);
               break;
       }
    }

    private void actionEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idEdit= Integer.parseInt(req.getParameter("id"));
        employeeService.findById(idEdit);
        System.out.println(employeeService.findById(idEdit));
        String name =req.getParameter("name");
        int phone=Integer.parseInt(req.getParameter("phone"));
        String address=req.getParameter("address");
        Date date=Date.valueOf(req.getParameter("birthday"));
        boolean sex=Boolean.parseBoolean(req.getParameter("sex"));
        double salary=Double.parseDouble(req.getParameter("salary"));
        Employee employee=new Employee(idEdit,name,phone,address,date,sex,salary);
        employeeService.saveOfUpdate(employee);
        showEmployee(req,resp);
    }

    private void actionAdd(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
        Employee employee=new Employee();
        employee.setName(req.getParameter("name"));
        employee.setPhone(Integer.parseInt(req.getParameter("phone")));
        employee.setAddress(req.getParameter("address"));
        employee.setBirthday(Date.valueOf(req.getParameter("birthday")));
        employee.setSex(Boolean.parseBoolean(req.getParameter("sex")));
        employee.setSalary(Double.parseDouble(req.getParameter("salary")));
        employeeService.saveOfUpdate(employee);
        showEmployee(req,resp);
    }
}
