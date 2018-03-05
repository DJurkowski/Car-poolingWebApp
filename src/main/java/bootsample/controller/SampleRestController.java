package bootsample.controller;

import bootsample.model.Task;
import bootsample.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SampleRestController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/helllo")
    public String hello(){
        return "hello";
    }


//    @GetMapping("/all-tasks")
//    public String allTasks(){
//        return taskService.findAll().toString();
//    }
//
//    @GetMapping("/save-task")
//    public String saveTask(@RequestParam String name, @RequestParam String desc){
//        Task task = new Task(name, desc, new Date(), 0);
//        taskService.save(task);
//        return "Task saved";
//    }
//
//    @GetMapping("/delete-task")
//    public String deleteTask(@RequestParam int id){
//        taskService.delete(id);
//        return "Delete done";
//    }
}
