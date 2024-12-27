package actions.model;


import org.springframework.stereotype.Service;
import actions.repository.StudentRepository;
import actions.entity.Student;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(String name) {
        Student student = new Student();
        student.setName(name);
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Long id, String newName) {
        return studentRepository.findById(id).map(student -> {
            student.setName(newName);
            return studentRepository.save(student);
        });
    }

    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
