package com.example.Students.controlllers;

import main.Students;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controllers {
    List<Students> studentsList= new ArrayList<>();
    int id;
    @GetMapping("/Students")
    public List<Students> students (){
        return studentsList;
    }
    @PostMapping("/AddStudents")
    public String Add(@RequestBody Students students){
        id++;
        students.setId(id);
        studentsList.add(students);
        return "Succesfull";
    }
    @DeleteMapping("/Delet")
    public String deleted(@RequestBody String id){
        int a=Integer.parseInt(id);
        try {
            Students delStudent= studentsList.remove(a);
            return delStudent.getName()+" adlı tələbə sistemden silinmişdir";
        }catch (RuntimeException e){
            return "Belə ID tapilmadi";
        }

    }
}
