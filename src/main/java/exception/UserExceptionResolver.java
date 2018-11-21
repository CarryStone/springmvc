package exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class UserExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exc) {
		UserException ue = null;
		
		if(exc instanceof UserException){
			ue = (UserException)exc;		
		}else if(exc instanceof SQLException){
			ue = new UserException("数据库异常");
		}else{
			ue = new UserException("未知错误");
		}
		
		String message = ue.getMessage();
		ModelAndView mv = new ModelAndView();
		mv.addObject("errorMessage", message);
		mv.setViewName("/error/error");
		return mv;
	}

}
