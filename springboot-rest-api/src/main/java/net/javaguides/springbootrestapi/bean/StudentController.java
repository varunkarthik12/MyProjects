package net.javaguides.springbootrestapi.bean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {

    //http://localhost:8080/student?id=1&fname=vk

    @GetMapping("/student")
    public Student getStudent(@RequestParam int id, @RequestParam String fname)
    {
        Student s1 = new Student(id,fname,",T");
        return s1;
    }

    @PostMapping("student/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student st)
    {
        System.out.println(st.getId());
        System.out.println(st.getFirst_name());
        System.out.println(st.getLast_name());

        return st;
    }

    @PutMapping("student/{id1}/put")
    public ResponseEntity<Student>  update(@RequestBody Student st,@PathVariable("id1") int id)
    {
        System.out.println(st.getFirst_name());
        System.out.println(st.getLast_name());
        return new ResponseEntity<>(st,HttpStatus.CREATED);
    }




}
