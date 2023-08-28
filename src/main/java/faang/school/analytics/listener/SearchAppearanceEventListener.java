package faang.school.analytics.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.analytics.dto.SearchAppearanceEventDto;
import faang.school.analytics.mapper.search_appearance_event.AnalyticsEventMapper;
import faang.school.analytics.model.EventType;
import faang.school.analytics.repository.search_appearance_event.AnalyticsEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;

import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SearchAppearanceEventListener extends AbstractListener<SearchAppearanceEventDto> {
    public SearchAppearanceEventListener(ObjectMapper objectMapper,
                                         AnalyticsEventMapper analyticsEventMapper,
                                         AnalyticsEventRepository analyticsEventRepository) {
        super(objectMapper, analyticsEventMapper, analyticsEventRepository);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        SearchAppearanceEventDto event = readValue(message.getBody(), SearchAppearanceEventDto.class);
        event.setEventType(EventType.PROFILE_APPEARED_IN_SEARCH);
        save(analyticsEventMapper.toEntity(event));
        System.out.println("Analytics event saved: " + event);
    }
}