package School;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {
    @Test
    public void testThatWeCanCreateACourse(){
     Course course = new Course(1,"ace");
     int courseId = course.getCourseID();
     assertEquals(1, courseId);
assertEquals("ace",course.getCourseName());
    }


}
