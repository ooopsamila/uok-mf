package uok.mf.students.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uok.mf.domain.impl.DataAccessException;
import uok.mf.reporttemplate.impl.ReportViewer;
import uok.mf.service.StudentsService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amila on 2/22/14.
 */
@Controller
@RequestMapping("manage_students")
@SessionAttributes("manageStudentsForm")
public class ManageStudentsController {
    @Autowired
    private StudentsService studentsService;
    public static final String view = "manage_students";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initForm(Model model, Map pageMap) throws DataAccessException {
        ManageStudentsForm manageStudentsForm = new ManageStudentsForm();
        studentsService.populateManageStudentsForm(manageStudentsForm, pageMap, 0);
        model.addAttribute("manageStudentsForm", manageStudentsForm);
        model.addAttribute("pageMap", pageMap);
        return new ModelAndView(view, "model", model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pager")
    public ModelAndView pagingHandler(@ModelAttribute("manageStudentsForm") ManageStudentsForm manageStudentsForm,
                                      @RequestParam("pager.offset") int offset, Model model, Map pageMap) throws Exception {
        manageStudentsForm.setOffset(offset);
        studentsService.populateManageStudentsForm(manageStudentsForm, pageMap, offset);
        model.addAttribute("manageStudentsForm", manageStudentsForm);
        model.addAttribute("pageMap", pageMap);
        return new ModelAndView(view, "model", model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public ModelAndView delete(@ModelAttribute("manageStudentsForm") ManageStudentsForm manageStudentsForm,
                               @RequestParam("indexNumber") String indexNumber) {
        Map<String, String> model = new HashMap<String, String>();
        model.put("redirectUrl", "/manage_students.html");
        try {
            studentsService.deleteStudent(indexNumber);
            model.put("successMessage", "uok.mf.delete.students.success");
            return new ModelAndView("success", "model", model);
        } catch (DataAccessException e) {
            model.put("errorMessage", "uok.mf.delete.students.error");
            return new ModelAndView("error", "model", model);
        }

    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("manageStudentsForm") ManageStudentsForm manageStudentsForm,
                                 Model model, Map pageMap) throws Exception {
        studentsService.populateManageStudentsForm(manageStudentsForm, pageMap, manageStudentsForm.getOffset());
        model.addAttribute("manageStudentsForm", manageStudentsForm);
        model.addAttribute("pageMap", pageMap);
        return new ModelAndView(view, "model", model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/downloadReport")
    public ModelAndView downloadReportAs(@ModelAttribute("manageStudentsForm") ManageStudentsForm manageStudentsForm,
                                                 @RequestParam("type") String type) throws Exception {
//        logger.info("Request received to download the report as {} type", type);
        Map model = new HashMap();
        ReportViewer reportViewer = new ReportViewer();
        model = studentsService.generateReport(manageStudentsForm, type);
        return new ModelAndView(reportViewer, model);
    }
}
