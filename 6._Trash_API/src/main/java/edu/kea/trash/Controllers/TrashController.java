package edu.kea.trash.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TrashController {

    List<String> deadlySins = new ArrayList<>(){{
        add("Lust");
        add("Gluttony");
        add("Greed");
        add("Sloth");
        add("Wrath");
        add("Envy");
        add("Pride");
    }};

    @GetMapping("/")
    public String renderIndex(){
        return "Hello World";
    }

    //create a clock that sends back the time
    @GetMapping("clock")
    public String renderClock(){
        Calendar calendar = new GregorianCalendar();
        String clock = "";
        clock += calendar.get(Calendar.HOUR) + ":";
        clock += calendar.get(Calendar.MINUTE) + ":";
        clock += calendar.get(Calendar.SECOND);
         return clock;
    }

    @GetMapping("date")
    public String renderDate(){
        Date date = new Date();
        return date.toString();
    }

    //todo create a route that gives one of the seven deadly sins based on a number
    //todo you are allowed to hardcode the number inside the route for now

    @GetMapping("deadlysins")
    public String renderDeadlySinsRequestParam(@RequestParam int i){
        if(i >= 1 && i <= 7){
            return deadlySins.get(i-1);
        }
        else {
            return "Only 7 deadly sins.";
        }
    }

    @GetMapping("deadlysinsno/{id}")
    public String renderDeadlySinsPathVariable(@PathVariable int id){
        try {
            if (id >= 1 && id <= 7) {
                return deadlySins.get(id - 1);
            } else {
                return "Only 7 deadly sins.";
            }
        }catch (Exception error){
            error.printStackTrace();
        }
        return null;
    }

    @GetMapping("/trash")
    public String returnTrash(@RequestParam String trash){
        return trash;
    }

    @PostMapping("/rubbishbin")
    public String throwOutRubbish(@RequestBody String rubbish) {
        System.out.println(rubbish);
        return "Everything went well";
    }

}
