package diya.dahara.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("welcome")
@SessionAttributes("welcomeForm")
public class WelcomeController {
    private static final String view = "welcome";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initForm() {
        //todo welcome form to be implemented
        return new ModelAndView(view, "welcomeForm", new WelcomeForm());
    }
}
