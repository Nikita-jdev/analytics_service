package faang.school.analytics.mapper;

import faang.school.analytics.dto.AnalyticsEventDto;
import faang.school.analytics.model.AnalyticsEvent;
import faang.school.analytics.model.EventType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalyticsEventMapperTest {
    private AnalyticsEventMapper analyticsEventMapper = new AnalyticsEventMapperImpl();

    @Test
    void testToDto() {
        // Arrange
        AnalyticsEvent analyticsEvent = AnalyticsEvent.builder()
                .id(1l)
                .receivedAt(LocalDateTime.now())
                .receiverId(10L)
                .eventType(EventType.POST_VIEW)
                .actorId(15L).build();

        // Act
        AnalyticsEventDto dto = analyticsEventMapper.toDto(analyticsEvent);

        // Assert
        assertAll(
                () -> assertEquals(dto.getActorId(), analyticsEvent.getActorId()),
                () -> assertEquals(dto.getReceiverId(), analyticsEvent.getReceiverId()),
                () -> assertEquals(dto.getReceivedAt(), analyticsEvent.getReceivedAt()),
                () -> assertEquals(dto.getId(), analyticsEvent.getId()),
                () -> assertEquals(dto.getEventType(), analyticsEvent.getEventType())
        );
    }
}