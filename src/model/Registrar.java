package model;
import exceptions.CourseFullException;
import exceptions.GPATooLowException;
import exceptions.MissingPrereqException;
import exceptions.NoCoursesTakenException;

import java.util.ArrayList;
import java.util.List;

public class Registrar {

    private String name;
    private List<Transcript> students;

    public Registrar(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }
    public List<Transcript> getStudents() {
        return students;
    }

    // MODIFIES: this
    // EFFECTS: returns true if the student (represented as a transcript) was successfully added to the
    //          Registrar's list. Remember to check if the student already exists in the list
    public boolean addStudent(Transcript stu) {
        if(!students.contains(stu)){
            students.add(stu);
            return true;
        }
        return false;
    }

    // EFFECTS: registers a given student represented by tct to a course c.
    //          if the student is missing the necessary prerequisites throws MissingPrereqException
    //          if the course is full throws CourseFullException
    public void registerStudent(Course c, Transcript tct){

            try {
                tct.addCourse(c);
            } catch (MissingPrereqException e) {
                e.printStackTrace();
            } catch (CourseFullException e) {
                e.printStackTrace();
            }

    }

    // EFFECTS: promotes all students to their next year level.
    //          if the GPA is too low (2.6 out of 4.0), throws a GPATooLowException
    //          if no courses have been taken, throws a NoCoursesTaken exception
    public void promoteAllStudents() {

        for (int i = 0; i < students.size(); i++) {
            try {
                students.get(i).promoteStudent();
            } catch (GPATooLowException e) {
                e.printStackTrace();
            } catch (NoCoursesTakenException e) {
                e.printStackTrace();
            }

        }
    }


}
