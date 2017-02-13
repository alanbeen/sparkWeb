package com.huaxia.test.route;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.huaxia.test.bean.MyUsers;
import com.huaxia.test.service.SparkService;
import com.huaxia.test.util.SparkBean;

import spark.ModelAndView;
import spark.Request;
import spark.routematch.RouteMatch;

import static spark.Spark.*;

public class SparkTest extends SparkBean {
	 HttpServletRequest servletRequest;
	 HttpSession httpSession;
	 Request request1;
	 RouteMatch match = new RouteMatch(null, "/hi", "/hi", "text/html");
	 private SparkService sparkService = new SparkService();
    @Override
    public void init()
     {
        get("/hi.do", (request, response) -> {
        	SparkService sparkService = new SparkService();
        	List<MyUsers> list = sparkService.listUsers();
            return "Hello World!";
        });
        post("/poster.do", (request, response) -> {
        	String userName = request.queryParams("name");
        	String pwd = request.queryParams("pwd");
        	if (sparkService.login(userName,pwd)) {
				response.redirect("../index2.jsp");
			}else{
				response.redirect("../index.jsp");
			}
        	return null;
        });
    }
    

}
