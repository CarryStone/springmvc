package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.UserException;
import model.User;
@Controller
public class UserLoginTest {
	
	@RequestMapping("toLogin")
	public String toLogin(){
		return "/user/login";
	}

	@RequestMapping("login")
	public String loginTest(Model model,HttpServletRequest req,@Validated User user,BindingResult result ) throws UserException{
		List<ObjectError> errorList = null;
		if(result.hasErrors()){
			errorList = result.getAllErrors();
			for(ObjectError error:errorList){
				System.out.println(error.getDefaultMessage());
			}
			model.addAttribute("errorList", errorList);
			return "/user/login";
		}else{
			boolean boolblack = checkBlackList(user);
			boolean booluser = checkUser(user);
			if(boolblack){
				throw new UserException("黑名单用户无权限访问");
			}
			if(booluser){	
				//将用户信息放入session
				req.getSession().setAttribute("user", user);			
			}else{
				model.addAttribute("errorMessage","用户名或密码错误");
				return "/user/login";
			}
			return "/fruits/findFruits";
		}
		
				
	}
	
	public boolean checkBlackList(User user){
		boolean bool =false;
		String[] blackArray = {"libanzhuan","lijianshe","lijianguo"};
		for(String str:blackArray){
			if(user.getUsername().equals(str)){
				bool = true;
			}
		}
		return bool;
	}
	
	public boolean checkUser(User user){
		boolean bool = false;
		if(user.getUsername().equals("lirenjie")&&user.getPassword().equals("000381lrj")){
			bool =true;
		}
		return bool;
	}
	
	@RequestMapping("loginout.action")
	public String loginOut(Model model,HttpServletRequest req){
		if(req.getSession().getAttribute("user")!=null){
			req.getSession().removeAttribute("user");
		}else{
			model.addAttribute("errorMessage", "注销失败，该用户已注销！");
		}
		return "/user/login";
	}
}
