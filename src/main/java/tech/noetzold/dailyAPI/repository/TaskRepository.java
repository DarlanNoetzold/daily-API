package tech.noetzold.dailyAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.dailyAPI.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
