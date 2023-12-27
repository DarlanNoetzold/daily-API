package tech.noetzold.dailyAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.noetzold.dailyAPI.client.NewsFeignClient;
import tech.noetzold.dailyAPI.model.dto.TabnewsResponse;
import tech.noetzold.dailyAPI.repository.NewsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    private NewsFeignClient newsFeignClient;

    @Autowired
    private NewsRepository newsRepository;

    public List<TabnewsResponse> getNews(){
        List<TabnewsResponse> tabnewsResponse = newsFeignClient.getNews("1", "20", "relevant");
        return newsRepository.saveAll(tabnewsResponse);
    }

}
