package faang.school.analytics.mapper;

import faang.school.analytics.dto.EventDto;
import faang.school.analytics.model.AnalyticsEvent;
import faang.school.analytics.model.EventType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


class AnalyticsEventMapperTest {

    private AnalyticsEventMapper analyticsEventMapper;

    private EventDto dto;

    private AnalyticsEvent model;

    @BeforeEach
    void setUp() {
        analyticsEventMapper = new AnalyticsEventMapperImpl();
        LocalDateTime currentTime = LocalDateTime.now();
        dto = EventDto.builder()
                .receiverId(1L)
                .actorId(2L)
                .eventType(EventType.FOLLOWER)
                .receivedAt(currentTime)
                .build();
        model = AnalyticsEvent.builder()
                .receiverId(1)
                .actorId(2)
                .eventType(EventType.FOLLOWER)
                .receivedAt(currentTime)
                .build();
    }

    @Test
    void toModelTest() {
        AnalyticsEvent result = analyticsEventMapper.toModel(dto);

        assertEquals(model, result);
    }

    @Test
    void toDto() {
        EventDto result = analyticsEventMapper.toDto(model);
        assertEquals(dto, result);
    }
}