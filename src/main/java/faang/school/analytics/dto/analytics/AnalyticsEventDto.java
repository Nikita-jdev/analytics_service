package faang.school.analytics.dto.analytics;

import faang.school.analytics.model.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsEventDto {

    private long id;
    private long receiverId;
    private long actorId;
    private EventType eventType;
    private LocalDateTime receivedAt;
}