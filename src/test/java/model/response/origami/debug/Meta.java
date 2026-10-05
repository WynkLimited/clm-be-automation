
package model.response.origami.debug;

import lombok.Data;
import com.google.gson.annotations.SerializedName;

@Data
public class Meta {

    @SerializedName("ACTION")
    private ACTION aCTION;
    @SerializedName("DISPLAY")
    private DISPLAY dISPLAY;
}
