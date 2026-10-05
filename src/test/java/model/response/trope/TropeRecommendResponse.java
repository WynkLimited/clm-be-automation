package model.response.trope;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class TropeRecommendResponse {
    private List<TropeItem> tropes;

    @Data
    public static class TropeItem {
        @SerializedName("trope_id")
        private int tropeId;

        private String trope;
        private double score;
    }
}
