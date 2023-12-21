package tech.noetzold.dailyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.dailyAPI.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {
}