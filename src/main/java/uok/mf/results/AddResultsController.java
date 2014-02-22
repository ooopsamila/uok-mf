package uok.mf.results;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by amila on 2/22/14.
 */
@Controller
@RequestMapping("add_results")
@SessionAttributes("addResultsForm")
public class AddResultsController {
    public static final String view = "add_results";
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initForm(){
        return new ModelAndView(view,"addResultsForm",new AddResultsForm());
    }
}
