package com.demo.eregister.controller;


import com.demo.eregister.model.Student;
import com.demo.eregister.service.IStudentServcice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private IStudentServcice studentServcice;

    @PostMapping(value = "/register")
    public void registerStudent(@ModelAttribute("student") Student student, HttpServletResponse response) throws IOException {
        studentServcice.registerStudent(student);
        response.sendRedirect("/students");
    }

    @GetMapping(value = "/students")
    public ModelAndView listStudent() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("students",studentServcice.getStudents());
        modelAndView.setViewName("studentList");
        return modelAndView;
    }

    @GetMapping(value = "/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId,HttpServletResponse response) throws IOException {
        studentServcice.deleteStudent(studentId);
        response.sendRedirect("/students");
    }

    @GetMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student",new Student());
        modelAndView.setViewName("/new");
       return modelAndView;
    }

    @GetMapping(value = "/search",params = "searchString")
    public ModelAndView getStudents(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students",studentServcice.filterStudents(searchString));
        modelAndView.setViewName("studentList");
        return modelAndView;



    }


}
