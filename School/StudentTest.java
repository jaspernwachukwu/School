package School;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    @Test
    void testThatWeCanHaveAStudentIdAndName(){
        Student student = new Student(1, "Wale");
        int studentId = student.getStudentId();
        assertEquals(1, studentId);
        String studentName = student.getStudentName();
        assertEquals("Wale",studentName);
    }

    @Test
    void testThatStudentsCanAddACourse() throws Exception {
        Student student = new Student(1, "Jasper");
        student.addCourse(1, "Python");
        assertEquals(1,student.getCourse(1).getCourseID() );
    }

    @Test
    void testThatStudentCanDeleteCourse() throws Exception {
        Student student = new Student(1, "Jasper");
        student.addCourse(1, "Python");
        student.deleteCourse(1);
        assertEquals(0, student.getCourseList().size() );
    }
}
