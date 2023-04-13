package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.handler.RollcallHander;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @Autowired
    RollcallHander rollcallHander;





    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/hello/rollcall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Roster> rollCall() {
        return rollcallHander.getRoster();

    }

//    @RequestMapping(path = "/hello/pojo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public String something() {
//        ControllerPOJO controllerPOJO = new ControllerPOJO();
//        return controllerPOJO;
//        }


    @RequestMapping(path = "/hello/rollcall", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> rollCall(@RequestBody List<Roster> rosters) {
        rollcallHander.addToRoster(rosters);
        return ResponseEntity.ok("CREATED");

    }

}




