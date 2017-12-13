/**
 * 
 */
/**
 * @author linbin
 *
 */
package com.home.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.home.common.Common;
import com.sun.javafx.collections.MappingChange.Map;
import com.sun.xml.internal.fastinfoset.util.StringArray;

@Controller
@RequestMapping("/springmvc")
public class HomeController {

	@RequestMapping("/login")
	public String login(@RequestParam(value = "username") String username, @RequestParam(value = "pwd") String pwd,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println(" ’µΩ«Î«Û£°" + username + "√‹¬Î£∫" + pwd);

		if (username.equals("linbin") && pwd.equals("123321")) {

			return "home";
		}

		return "home";

	}

	@RequestMapping("/phoneLogin")
	public void phoneLogin(@RequestParam(value = "username") String name, @RequestParam(value = "pwd") String pwd,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			if (name.equals(Common.userName) && pwd.equals(Common.pwd)) {

				response.getWriter().write(200);

			} else {
				response.getWriter().write(100);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@RequestMapping("/getVideo")
	public void getVideo(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> list = new ArrayList<String>();
		File file = new File(Common.fileDir);

		File[] tempList = file.listFiles();

		StringArray array = new StringArray();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < tempList.length; i++) {

			array.add(tempList[i].getName());
			buffer.append(tempList[i].getName() + "&");
			list.add(tempList[i].getName());
		}

		try {
			response.getWriter().write(buffer.toString());
			HttpSession s =  request.getSession();
			
			s.setAttribute("list", list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/openVideo")
	public void openvideo(@RequestParam(value = "fileName") String name,HttpServletRequest request, HttpServletResponse response) {

		String fileName = "";
		File file = new File(Common.fileDir);

		File[] tempList = file.listFiles();
		for (int i = 0; i < tempList.length; i++) {

			if(tempList[i].getName().equals(name)){
				
				fileName = tempList[i].getPath();
				
				try {
					response.getWriter().write(fileName);
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
		}
		
		
		

	}

}