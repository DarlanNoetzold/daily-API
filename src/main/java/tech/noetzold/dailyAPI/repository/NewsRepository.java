package tech.noetzold.dailyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.dailyAPI.model.dto.TabnewsResponse;

public interface NewsRepository extends JpaRepository<TabnewsResponse, Long> {
}
