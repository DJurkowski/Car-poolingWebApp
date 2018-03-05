package bootsample.controller;

import bootsample.model.Task;
import bootsample.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private TaskService taskService;

//    @GetMapping("/")
//    public String home(HttpServletRequest request) {
//        request.setAttribute("mode", "MODE_HOME");
//        return "index";
//    }

    @GetMapping("/all-tasks")
    public String allTasks(HttpServletRequest request) {
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @PostMapping("/save-task")
    public String saveTasks(@ModelAttribute Task task, HttpServletRequest request) {
        taskService.save(task);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @GetMapping("/new-task")
    public String newTask(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @GetMapping("/update-task")
    public String updateTask(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("task", taskService.findTask(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }

    @GetMapping("/delete-task")
    public String deleteTask(@RequestParam int id, HttpServletRequest request) {
        taskService.delete(id);
        request.setAttribute("tasks", taskService.findTask(id));
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }
}
