package com.example.event_management_system.service;

import com.example.event_management_system.model.Event;
import com.example.event_management_system.model.Student;
import com.example.event_management_system.repository.EventRepository;
import com.example.event_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class EVSService implements IEVSService {
    private static List<Student> students=new ArrayList<>();

    @Autowired
    EventRepository eventRepository;

    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    @Override
    public Student findStudentById(int id){
        return studentRepository.findById(id).get();
    }
    @Override
    public void updateStudent(int id, Student newstudent){
        Student student=studentRepository.findById(id).get();
        student.setStudentId(newstudent.getStudentId());
        student.setFirstName(newstudent.getFirstName());
        student.setLastName(newstudent.getLastName());
        student.setAge(newstudent.getAge());
        student.setDept(newstudent.getDept());
        studentRepository.save(student);
    }
    @Override
    public void deleteStudent(int studentId){
        studentRepository.deleteById(studentId);
    }




    public static List<Event> events= new ArrayList<>();

@Override
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }
    @Override
    public void addEvent(Event event){
        eventRepository.save(event);
    }

    @Override
    public Event findEventById(int eventId){
       return eventRepository.findById(eventId).get();
    }
    @Override
    public void updateEvent(int eventId, Event newevent){
        Event event=eventRepository.findById(eventId).get();
        event.setEventId(newevent.getEventId());
        event.setEventName(newevent.getEventName());
        event.setEventLocation(newevent.getEventLocation());
        event.setDate(newevent.getDate());
        event.setStartTime(newevent.getStartTime());
        event.setEndTime(newevent.getEndTime());
        event.setImgUrl(newevent.getImgUrl());
        eventRepository.save(event);
    }
    @Override
    public void deleteEvent(int eventId){
        eventRepository.deleteById(eventId);
    }
}
