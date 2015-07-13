package io.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller
@RestController
public class SampleController {
//  private static final String template = "Hello, %s!";
//  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/")
  public String index() {
      return "Greetings from Spring Boot!";
  }

//  @RequestMapping(value = {"/hello-world"}, method=RequestMethod.GET)
//  public @ResponseBody Greeting sayHello(@RequestParam(value="name", 
//  	required=false, defaultValue="Stranger") String name) {
//      return new Greeting(counter.incrementAndGet(), String.format(template, name));
//  }

}