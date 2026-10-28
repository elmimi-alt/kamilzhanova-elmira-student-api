package kz.elmira.studentapi;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
            "author", "Kamilzhanova Elmira",
            "application", "Student API"
        );
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@Valid @RequestBody Student student) {
        student.id = null;
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> getAll() {
        return repository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getOne(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Student not found"
            ));
    }

    @PutMapping("/students/{id}")
    public Student update(
            @PathVariable Long id,
            @Valid @RequestBody Student data) {

        Student student = getOne(id);
        student.name = data.name;
        student.email = data.email;

        return repository.save(student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Student student = getOne(id);
        repository.delete(student);
    }
}
