package School;

import java.util.ArrayList;
import java.util.Collection;

public class Student {
    private int studentId;
    private String studentName;
    private ArrayList<Course> courses;
    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void addCourse(int courseId,String courseName){
        Course newCourse = new Course(courseId, courseName);
        courses.add(newCourse);

    }

    public Course getCourse(int courseId) throws Exception {
        for(Course course : courses){
            if(course.getCourseID() == courseId){
                return course;
            }
        }

        throw new Exception("You haven't started taking this course, nitwit!");
    }

    public void deleteCourse(int courseId) throws Exception {
        int initialArraySize = courses.size();
        for(Course course: courses){
            if(course.getCourseID() == courseId){
                courses.remove(course);
                break;
            }
        }
        if (initialArraySize == courses.size()){
            throw new Exception ("The course doesn't exist");
        }
    }


    public ArrayList<Course> getCourseList() {
        return courses;
    }
}
