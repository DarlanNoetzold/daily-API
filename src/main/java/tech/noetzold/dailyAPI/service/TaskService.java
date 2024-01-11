package tech.noetzold.dailyAPI.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.model.Task;
import tech.noetzold.dailyAPI.repository.TaskRepository;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Transactional
    public List<Task> findAllTask(){
        return taskRepository.findAll();
    }

    @Transactional
    public Task findTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    @Transactional
    public Task updateTask(Long id, Task task){
        task.setId(id);
        return taskRepository.save(task);
    }

    @Transactional
    public Task saveTask(Task task){
        task.setAddDate(new Date());
        return taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
