package model.request.watchInfo;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class UserWatchInfoRequest {
    private String uid;
    private List<String> sources;
    private Filters filters;
    private Pagination pagination;
    private List<String> fields;

    @Data
    @Builder
    public static class Filters {
        private Boolean dedupeBySeries;
        private List<String> cwContentTypes;
        private List<String> programTypes;
        private Long updatedAtStart;
        private Long updatedAtEnd;
        private List<String> languages;
        private List<String> contentPartners;
        private Integer durationFrom;
        private Integer durationTo;
        private Integer remainingTimeFrom;
        private Integer remainingTimeTo;
        private Integer completionFrom;
        private Integer completionTo;
    }

    @Data
    @Builder
    public static class Pagination {
        private Integer pageSize;
        private String continueWatchingCursor;
        private String historyCursor;
        private String favouritesCursor;
        private String reactionsCursor;
    }
}
