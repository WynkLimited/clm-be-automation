package model.response.userPersona;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Data
public class RTPersonaIntentValues {
    @SerializedName("GENRE_COUNT")
    private List<Integer> genreCount;
    @SerializedName("CONTENT_ID_COUNT")
    private List<Integer> contentIdCount;
    @SerializedName("CONTENT_ID_POSITION")
    private List<Integer> contentIdPosition;
    @SerializedName("CONTENT_TYPE")
    private List<String> contentType;
    @SerializedName("CONTENT_TYPE_COUNT")
    private List<Integer> contentTypeCount;
    @SerializedName("GENRE")
    private List<String> genre;
    @SerializedName("LANG_COUNT")
    private List<Integer> langCount;
    @SerializedName("LANG")
    private List<String> lang;
    @SerializedName("CONTENT_ID")
    private List<String> contentIds;
}
