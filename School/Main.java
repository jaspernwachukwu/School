package School;

import java.util.Scanner;

public class Main {
    public static School school;
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to  omo ota school. God go help you here...");
        initializeDummies();
        int sentinel = 1;
        while (sentinel != -1) {
            System.out.print("""
                                    
                    1. Log into a Student's Portal
                    2. Log into a Course's portal
                    3. Log into Admins' dashboard
                    4. Log Out
                    > """);

            int mainMenuChoice = userInput.nextInt();

            switch (mainMenuChoice) {
                case 1 -> {
                    studentPortal();
                    break;
                }

                case 2 -> {
                    coursePortal();
                    break;
                }

                case 3 -> {
                    adminDashboard();
                    break;
                }
                case 4 -> sentinel = -1;

                default -> {
                    System.out.println("Wrong input. Try again!");
                    String[] arr = new String[5];
                    Main.main(arr);
                }
            }

        }}

    public static void studentPortal() throws Exception {
        System.out.println();

        System.out.print("Enter your student ID: ");
        int studentId = userInput.nextInt();

        getStudentInfo(studentId);
    }

    public static void getStudentInfo(int studentId) throws Exception {
        System.out.printf("""
                Name: %s
                ID: %d
                """, school.getStudent(studentId).getStudentName(),
                school.getStudent(studentId).getStudentId());
    }

    public static void coursePortal() throws Exception {
        System.out.println();

        System.out.print("""
                Enter course id:
                > """);

        int courseId = userInput.nextInt();
        getCourseInfo(courseId);
    }

    public static void getCourseInfo(int courseId) throws Exception {
        System.out.println();

        System.out.printf("""
                Course Name: %s
                Course ID: %d
                """, school.getCourse(courseId).getCourseName(), school.getCourse(courseId).getCourseID());
    }

    public static void adminDashboard() throws Exception {
        System.out.println();

        System.out.print("""
                1. Create a new course
                2. List all courses
                3. Delete a course
                4. Admit a new student
                5. expel student
                > """);

        int adminChoice = userInput.nextInt();
        
        switch (adminChoice) {
            case 1 -> {
                System.out.println();

                System.out.print("""
                        Enter the name of the new course:
                        """);
                
                String courseName = userInput.next();

                System.out.print("Enter the ID of the new course: ");
                
                int courseID = userInput.nextInt();
                
                school.createCourse(courseID, courseName);

                System.out.println("Course created successfully!");
                adminDashboard();
            }
            
            case 2 -> {
                System.out.println();

                for (int i = 0; i < school.getCourses().size(); i++) {
                    System.out.printf("%d. %s%nCourse ID is: %d%n%n", i + 1, school.getCourse(i).getCourseName(),
                            school.getCourse(i).getCourseID());
                }

                System.out.println("To be continued...");
            }
            
            case 3 -> {
                System.out.println();

                System.out.println("Enter the ID of course to delete: ");
                int deletedCourse = userInput.nextInt();

                school.deleteCourse(deletedCourse);
                System.out.println("School deleted successfully!");

                adminDashboard();
            }
            
            case 4 -> {
                System.out.println();

                System.out.print("Enter the name of the new student: ");

                String username = userInput.next();

                System.out.print("Enter the new student's ID: ");

                int studentID = userInput.nextInt();

                school.createStudent(studentID, username);

                System.out.println("Student admitted successfully!");
                adminDashboard();
            }
            
            case 5 -> {
                System.out.println();

                System.out.println("Enter the ID of the bloody wimp to be expelled: ");
                int expelledId = userInput.nextInt();

                school.expelStudent(expelledId);
                System.out.println("Student successfully expelled Good riddance! You won't see them again, hopefully.");

                adminDashboard();
            }
            
            default -> {
                System.out.println("Invalid choice! Try again.");
                adminDashboard();
            }
        }
    }

    public static void initializeDummies() {
        school = new School("Vawulence High School");

        String[] names = { "Olamide", "Davis", "David", "Idiot", "Smart", "Rick",
                "Richard", "Stones", "Rick", "Sam", "Sule", "Grace", "Alice", "Precious", "Hair" };

        for (int i = 0; i < 32; i++) {
            String name = String.format("%s %s", names[(int)(Math.random() * names.length - 1)],
                    names[(int)(Math.random() * names.length - 1)]);
            school.createStudent(i + 1, name);
        }

        String[] courses = {"Maths", "Biology", "Arts", "Data Processing",
                "English", "Economics", "Computer Science"};

        for (int i = 0; i < courses.length; i++) {
            school.createCourse(i, courses[i]);
        }
    }
}
