package quickstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Mundo TRT!";
    }

    @RequestMapping("/helloPeople")
    public String helloPeople(@RequestParam(name = "nome") String nome) {
        return String.format("Hello %s!", nome);
    }

}