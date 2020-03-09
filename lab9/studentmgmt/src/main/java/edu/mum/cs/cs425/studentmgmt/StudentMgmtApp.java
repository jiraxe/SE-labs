package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.dao.IstudentRepository;
import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StudentMgmtApp  implements CommandLineRunner {

    @Autowired
    IstudentRepository studentRepository;


    public static void main(String[] args) {
        SpringApplication.run(StudentMgmtApp.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


        Student student = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.45,
                LocalDate.of(2019, 5, 24));
        Transcript transcript = new Transcript(1, "BS Computer Science");
        Classroom classroom = new Classroom(1, "McLaughlin building", "M105");
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        classroom.setStudentList(studentList);
        student.setTranscript(transcript);
        student.setClassroom(classroom);

   saveStudent(student);
    };

    void saveStudent(Student student) {

        studentRepository.save(student) ;
    }
}
