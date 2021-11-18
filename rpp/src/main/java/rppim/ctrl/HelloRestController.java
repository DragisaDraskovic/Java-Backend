package rppim.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	
	@RequestMapping("/")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@RequestMapping("zbir")
	public String zbir() {
		long x = Math.round(Math.random()*10);   //Math.random daje random brojeve 0.0 do 1.0 pa ga zato mnozimo 
		long y = Math.round(Math.random()*10);	 // sa 10 da bi dobili broj o 0 do 10
		return x+" + "+y+" = "+(x+y);
	}
}
