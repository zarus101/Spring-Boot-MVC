package com.suraj.vedu.controller;

import com.suraj.vedu.exception.CourseNotFoundException;
import com.suraj.vedu.model.Contact;
import com.suraj.vedu.model.Course;
import com.suraj.vedu.repository.ContactRepository;
import com.suraj.vedu.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
@CrossOrigin("http://localhost:3000")
public class CourseController {
    private CourseRepository courseRepository;
    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    List<Course> getAllCourses(){
        return  courseRepository.findAll();
    }

    @PostMapping("/course")
    Course newCourse(@RequestBody Course newCourse){
        return courseRepository.save(newCourse);
    }

    @GetMapping("/course/{id}")
    Course getUserById(@PathVariable String id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    @PutMapping("/course/{id}")
    Course updateCourse(@RequestBody Course newCourse, @PathVariable String id) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setCourse_name(newCourse.getCourse_name());
                    course.setCourse_des(newCourse.getCourse_des());
                    course.setCategory(newCourse.getCategory());
                    course.setIs_course_available(newCourse.getIs_course_available());
                    return courseRepository.save(course);
                }).orElseThrow(() -> new CourseNotFoundException(id));
    }

    @DeleteMapping(path = "course/{id}")
    String deleteCourse(@PathVariable String id){
        if (!courseRepository.existsById(id)) {
            throw  new CourseNotFoundException(id);
        }
        courseRepository.deleteById(id);
        return "course with id"+ id + "has been deleted successfully";
    }

    @GetMapping("/contacts")
    List<Contact> getAllContact(){
        return contactRepository.findAll();
    }

    @PostMapping("/contact")
    Contact newContact(@RequestBody Contact newContact){
        return contactRepository.save(newContact);
    }

    @DeleteMapping(path = "contact/{id}")
    String DeleteContact(@PathVariable Long id){
        contactRepository.deleteById(id);
        return "contact details with id " + id + " has been deleted successfully";
    }



}
