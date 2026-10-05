package model.response.userPersona;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.*;

@Data
public class UserPersonaDTO  {

    @SerializedName("monthly_rolling_total_stream_time")
    private double monthlyRollingTotalStreamTime;

    @SerializedName("music__rolling_30_played_long_15_total_count")
    private int musicRolling30PlayedLong15TotalCount;

    @SerializedName("xstream__dominant_recent_content_type__daily")
    private String xstreamDominantRecentContentTypeDaily;

    @SerializedName("xstream__user_attr_subs_history__period_validity")
    private String xstreamUserAttrSubsHistoryPeriodValidity1;

    @SerializedName("music__lowest_consumed_language__daily")
    private List<String> musicLowestConsumedLanguageDaily;

    @SerializedName("music__rolling_30_total_stream_time")
    private int musicRolling30TotalStreamTime;

    @SerializedName("music__dominant_language__daily")
    private String musicDominantLanguageDaily;

    @SerializedName("xstream__is_user_registered__daily")
    private boolean xstreamIsUserRegisteredDaily;

    @SerializedName("music__top_artist__daily")
    private List<String> musicTopArtistDaily;

    @SerializedName("day")
    private String day;

    @SerializedName("music__rolling_30_unique_item_count")
    private int musicRolling30UniqueItemCount;

    @SerializedName("music__isReg__daily")
    private boolean musicIsRegDaily;

    @SerializedName("music_mtd_stream_time")
    private double musicMtdStreamTime;

    @SerializedName("music_mtd_stream_count")
    private int musicMtdStreamCount;

    @SerializedName("common__operator__daily")
    private String commonOperatorDaily;

    @SerializedName("xstream__dominant_genres__daily")
    private List<String> xstreamDominantGenresDaily;

    @SerializedName("xstream__dominant_recent_genres__daily")
    private List<String> xstreamDominantRecentGenresDaily;

    @SerializedName("dth_dominant_sports_genre")
    private String dthDominantSports;

    @SerializedName("music__top_consumed_language__daily")
    private String musicTopConsumedLanguageDaily;

    @SerializedName("music__rolling_30_played_long_30_total_count")
    private int musicRolling30PlayedLong30TotalCount;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("xstream__persona_eligible_flag__daily")
    private int xstreamPersonaEligibleFlagDaily;

    @SerializedName("music__rolling_30_played_long_30_item_count")
    private int musicRolling30PlayedLong30ItemCount;

    @SerializedName("common__name__daily")
    private String commonNameDaily;

    @SerializedName("music__install_day__daily")
    private String musicInstallDayDaily;

    @SerializedName("xstream__significant_language__daily")
    private List<String> xstreamSignificantLanguageDaily;

    @SerializedName("music__last_app_open_date__daily")
    private String musicLastAppOpenDateDaily;

    @SerializedName("music__onboarding_langauge")
    private List<String> musicOnboardingLanguage;

    @SerializedName("common__dob__daily")
    private String commonDobDaily;

    @SerializedName("music__last_active_date__daily")
    private String musicLastActiveDateDaily;

    @SerializedName("music__rolling_30_played_long_15_item_count")
    private int musicRolling30PlayedLong15ItemCount;

    @SerializedName("music__reinstall_day__daily")
    private String musicReinstallDayDaily;

    @SerializedName("click_persona_dominant_lang")
    private String clickPersonaDominantLang;

    @SerializedName("click_persona_significant_lang")
    private String clickPersonaSignificantLang;

    @SerializedName("music__subscription_status__daily")
    private String musicSubscriptionStatusDaily;

    @SerializedName("xstream__dominant_cp__daily")
    private String xstreamDominantCpDaily;

    @SerializedName("xstream__subscription_status__daily")
    private List<String> xstreamSubscriptionStatusDaily;

    @SerializedName("xstream__dominant_recent_content_category__daily")
    private String xstreamDominantRecentContentCategoryDaily;

    @SerializedName("music__mymixes_updated_day")
    private String musicMymixesUpdatedDay;

    @SerializedName("music__rolling_30_total_stream_count")
    private int musicRolling30TotalStreamCount;

    @SerializedName("monthly_rolling_downloads_total_stream_count")
    private int monthlyRollingDownloadsTotalStreamCount;

    @SerializedName("xstream__dominant_content_type__daily")
    private String xstreamDominantContentTypeDaily;

    @SerializedName("xstream__dominant_language__daily")
    private String xstreamDominantLanguageDaily;

    @SerializedName("xstream__dominant_recent_cp__daily")
    private String xstreamDominantRecentCpDaily;

    @SerializedName("music__onboarding_day")
    private String musicOnboardingDay;

    @SerializedName("monthly_rolling_downloads_total_stream_time")
    private double monthlyRollingDownloadsTotalStreamTime;

    @SerializedName("music__followed_artist__daily")
    private List<String> musicFollowedArtistDaily;

    @SerializedName("music__onboarding_artist")
    private List<String> musicOnboardingArtist;

    @SerializedName("music__significant_language__daily")
    private List<String> musicSignificantLanguageDaily;

    @SerializedName("common__circle__daily")
    private String commonCircleDaily;

    @SerializedName("xstream__dominant_content_category__daily")
    private String xstreamDominantContentCategoryDaily;

    @SerializedName("monthly_rolling_total_stream_count")
    private int monthlyRollingTotalStreamCount;

    @SerializedName("most_consumed_sport")
    private String mostConsumedSport;

    @SerializedName("most_dubbed_lang")
    private String mostDubbedLanguage;

    @SerializedName("dth_language")
    private String dthLanguage;

    @SerializedName("dth_state")
    private String dthState;

    @SerializedName("segmentIds")
    private List<String> segmentIds;

    @SerializedName("uid")
    private String uid;

    @SerializedName("realtime-persona")
    private RealtimePersona realtimePersona;

    @SerializedName("xstream__onboarding_usl")
    private String xstreamOnboardingUsl;

    @SerializedName("xstream_onboarding_timestamp")
    private Double xstreamOnboardingTimestamp;

    @SerializedName("click-based-persona-dp")
    private ClickBasedPersonaDp clickBasedPersonaDp;

    @SerializedName("dth_top_language_name")
    private String dthTopLanguageName;

    @SerializedName("dth_dominant_language_name")
    private String dthDominantLanguageName;

    @SerializedName("dth_significant_language_names")
    private List<String> dthSignificantLanguages;

    @SerializedName("dth_top_content_genre")
    private String dthTopContentGenre;

    @SerializedName("dth_dominant_content_genre")
    private String dthDominantContentGenre;

    @SerializedName("dth_significant_content_genres")
    private List<String> dthSignificantContentGenres;

    @SerializedName("dth_dominant_channel_genre")
    private String dthDominantChannelGenre;

    @SerializedName("dth_top_sports_genre")
    private String dthTopSportsGenre;

    @SerializedName("click_persona_dominant_sport")
    private String clickPersonaDominantSport;

    @SerializedName("click_persona_significant_sport")
    private String clickPersonaSignificantSport;

    @SerializedName("click_persona_dominant_cp")
    private String clickPersonaDominantCp;

    @SerializedName("click_persona_significant_cp")
    private String clickPersonaSignificantCp;

    @SerializedName("click_persona_other_explored_cp")
    private String clickPersonaOtherExploredCp;

    @SerializedName("last_30days_streamtime")
    private Double xstreamLast30DaysStreamTime;

    @SerializedName("ltv_linear_tv_streamtime_share_percent")
    private Double ltvLinearTvStreamtimeSharePercent;

}
