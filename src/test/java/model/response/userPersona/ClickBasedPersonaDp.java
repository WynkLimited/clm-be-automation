package model.response.userPersona;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ClickBasedPersonaDp  {
    @SerializedName("arity")
    private Integer arity;

    @SerializedName("f0")
    private String f0;

    @SerializedName("f1")
    private F1 f1;
}