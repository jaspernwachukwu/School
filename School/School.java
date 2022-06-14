package School;

import java.util.ArrayList;

public class School {
    private String schoolName;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.courses = new ArrayList<Course>();
        this.students = new ArrayList<Student>();
    }

    public Course getCourse(int courseID) throws Exception {
        for (Course course : courses) {
            if (course.getCourseID() == courseID) {
                return course;
            }
        }
        throw new Exception("Course never exist");
    }

    public void createCourse(int courseId, String courseName) {
        Course newCourse = new Course(courseId, courseName);
        courses.add(newCourse);
    }

    public void deleteCourse(int courseID) throws Exception {
        int initialArrayListSize = courses.size();

        for(Course course : courses){
            if(course.getCourseID() == courseID){
                courses.remove(course);
                break;
            }
        }

        if(courses.size() == initialArrayListSize) {
            throw new Exception("Course not found!!");
        }
    }

    public int getCourseNumber() {
        return courses.size();
    }

    public void createStudent(int studentId, String studentName) {
        Student newStudent = new Student(studentId, studentName);
        students.add(newStudent);
    }

    public Student getStudent(int studentId) throws Exception {
        for(Student student : students){
            if(student.getStudentId() == studentId){
                return student;
            }
        }
        throw new Exception("Student never register for ya fake school!");
    }

    public void expelStudent(int studentID) throws Exception {
        int initialArraySize = students.size();

        for(Student student : students){
            if(student.getStudentId() == studentID){
                students.remove(student);
                break;
            }
        }

        if(initialArraySize == students.size()){
            throw new Exception("Student not found!!!") ;
        }
    }

    public ArrayList<Student> getStudentsList(){
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
