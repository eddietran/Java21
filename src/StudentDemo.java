import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Create a list grouping students by department using streams and collectors

public class StudentDemo {

	public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(105, "Mathematics", "Linear Algebra"),
        		new Student(103, "Mechanical Engineering", "Thermodynamics"),
                new Student(102, "Computer Science", "Algorithms"),
                new Student(104, "Mechanical Engineering", "Fluid Mechanics"),
                new Student(106, "Mathematics", "Probability"),
                new Student(101, "Computer Science", "Data Structures")
        );

        List<List<Student>> groupedStudents = students.stream()
        	.collect(Collectors.groupingBy((Student s) -> s.getDepartment()))
        	.values()
        	.stream()
        	.toList();
        
        groupedStudents.stream().flatMap((List<Student> s) -> s.stream()).forEach(System.out::println);
        
	}
	
}

class Student {
	private int id;
	private String department;
	private String subject;
	
	Student(int id, String department, String subject) {
		this.id = id;
		this.department = department;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", department=" + department + ", subject=" + subject + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}