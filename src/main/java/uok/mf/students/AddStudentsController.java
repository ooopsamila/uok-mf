package uok.mf.students;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by amila on 2/22/14.
 */
@Controller
@RequestMapping("add_students")
@SessionAttributes("addStudentsForm")
public class AddStudentsController {
    public static final String view = "add_students";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initForm() {

        return new ModelAndView(view, "addStudentsForm", new AddStudentForm());
    }
}
