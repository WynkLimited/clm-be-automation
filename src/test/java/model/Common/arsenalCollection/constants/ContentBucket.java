package model.Common.arsenalCollection.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ContentBucket {
    size(false, false),
    genre(true,false),
    language(true,false),
    language_usil(true,true),
    language_ul(true,true),
    language_usl(true,true),
    language_udl(true,true),
    language_ucl(true,true),
    type(true,false),
    cpId(true,false),
    source(false,false),
    popularity_window(true,false),
    release_window(true,false),
    india_boosting(true,true),
    onboarding_window(true,false),
    usr_cp_affinity(true, true),
    usr_genre_affinity(true,true),
    release_year_window(true,false),
    free_to_view(true,true),
    strategy_source(false,false);

    private final boolean needContentMeta;
    private final boolean needUserPersona;
}
