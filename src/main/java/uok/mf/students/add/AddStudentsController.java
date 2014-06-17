package uok.mf.students.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import uok.mf.domain.impl.DataAccessException;
import uok.mf.service.StudentsService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amila on 2/22/14.
 */
@Controller
@RequestMapping("add_students")
@SessionAttributes("addStudentsForm")
public class AddStudentsController {

    @Autowired
    private AddStudentsValidator addStudentsValidator;
    @Autowired
    private StudentsService studentsService;
    public static final String view = "add_students";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initForm() {
        return new ModelAndView(view, "addStudentsForm", new AddStudentForm());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute("addStudentsForm") AddStudentForm addStudentForm, BindingResult result) {
        addStudentsValidator.validate(addStudentForm, result);
        if (!result.hasErrors()) {
            Map<String, String> model = new HashMap();
            try {
                studentsService.createStudent(addStudentForm);
                model.put("successMessage", "uok.mf.add.students.success");
                model.put("redirectUrl", "/manage_students.html");
                return new ModelAndView("success", "model", model);
            } catch (DataAccessException e) {
                model.put("errorMessage", "uok.mf.add.students.error");
                model.put("redirectUrl", "/add_students.html");
                return new ModelAndView("error", "model", model);
            }
        }
        return new ModelAndView(view, "addStudentsForm", addStudentForm);
    }
}
