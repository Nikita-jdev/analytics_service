package faang.school.analytics.mapper;

import faang.school.analytics.model.AnalyticsEvent;
import faang.school.analytics.service.redis.events.PremiumEvent;
import faang.school.analytics.service.redis.events.ProjectEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PremiumEventsMapper {
    @Mapping(source = "userId", target = "actorId")
    AnalyticsEvent toAnalyticsEvent(PremiumEvent premiumEvent);
}
