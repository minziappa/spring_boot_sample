package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloController {
    
//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

//    @RequestMapping(value = {"/hello-world"}, method=RequestMethod.GET)
//    public @ResponseBody Greeting sayHello(@RequestParam(value="name", 
//    	required=false, defaultValue="Stranger") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

}
