package model.Common.arsenalCollection.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SortingMethod {

    explicit(true, false),
    langauge(true, false),
    cpId(true, false),
    popularity(true, false),
    daily_stream_time(true, false),
    daily_unique_user(true, false),
    source(false, false),
    recency(true, false),
    releaseYear(true, false),
    random(false, false),
    user_content_type_affinity(true, true),
    user_lang_based(true, true),
    genre(true, false),
    user_significant_language_based(true, true),
    user_dominant_language_based(true, true),
    user_consumed_language_based(true, true),
    user_trend_lang_iptv(true, true),
    user_selected_language_based(true, true),
    content_onboarding(true, false),
    usr_cp_affinity(true, true),
    usr_genre_affinity(true, true),
    lang_cp_priority(true, false),
    lang_cp_user_priority(true, true),
    content_usr_langauge(true, true),
    last_watched_timestamp(true, false),
    score(false,false ),
    ml_model(true, true),
    sports_genre(true, true),
    usr_priority_sports_genre_affinity(true, true),
    usr_simple_sports_genre_affinity(true, true),
    neuralflix(true, false ),
    usl_boosting(true,true),
    latest_interaction_timestamp(true, false ),
    unique_days_count(true, false ),
    stream_time(true, false ),
    usr_subscription_channel_affinity(true,true),
    india_match_boosting(true,false);

    private final boolean needContentMeta;
    private final boolean needUserPersona;

}
