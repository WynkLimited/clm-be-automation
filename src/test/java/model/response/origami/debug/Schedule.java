
package model.response.origami.debug;

import lombok.Data;
import com.google.gson.annotations.Expose;

@Data
public class Schedule {
    private String cron;
    private Long duration;
}
