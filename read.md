framework used:- springboot
language used:-java
database used:- h2

model
Student{
studentId	integer($int32)
firstName	string
lastName	string
age	integer($int32)
dept	string
}

Event{
eventId	integer($int32)
eventName	string
eventLocation	string
date	string
startTime	string
endTime	string
imgUrl	string
}

SERVICE & CONTROLLER
    public List<Student> getAllStudents();

    public void addStudent(Student student);

    public Student findStudentById(int id);

    public void updateStudent(int id, Student newstudent);
    public void deleteStudent(int studentId);

    public List<Event> getAllEvents();

    public void addEvent(Event event);


    public Event findEventById(int eventId);
    public void updateEvent(int eventId, Event newevent);

    public void deleteEvent(int eventId);
  
  
  
  
  
  
