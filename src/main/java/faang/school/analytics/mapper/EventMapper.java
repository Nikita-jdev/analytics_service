package faang.school.analytics.mapper;

import faang.school.analytics.dto.CommentEventDto;
import faang.school.analytics.model.AnalyticsEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    @Mapping(target = "receiverId", source = "authorId")
    @Mapping(target = "actorId", source = "commentId")
    @Mapping(target = "eventType", expression = "java(faang.school.analytics.model.EventType. POST_COMMENT)")
    AnalyticsEvent toEntity(CommentEventDto commentEventDto);
}