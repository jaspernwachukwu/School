package School;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchoolTest {
    @Test
    void testThatWeCanHaveListOfCourses() throws Exception {
        School school= new School("SemiColon");
        school.createCourse(1, "Maths");
        Course math = school.getCourse(1);

        assertEquals(1, math.getCourseID());
    }

    @Test
    void testThatWeCanDeleteCourse() throws Exception {
        School school = new School("Semicolon");
        school.createCourse(1, "Java");
        school.deleteCourse(1);
        assertEquals(0, school.getCourseNumber());

    }
    @Test
    void testThatWeAddStudent() throws Exception {
        School school = new School("Sungbalaja");
        school.createStudent(1, "Grace");
        assertEquals(1, school.getStudent(1).getStudentId());
    }

    @Test
    void testThatWeCanExpelStudent() throws Exception {
        School school = new School("Semicolon");
        school.createStudent(1, "Grace");
        school.expelStudent(1);
        assertEquals(0,school.getStudentsList().size());
    }
}
