package model.Common.arsenalCollection.constants;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum DeduplicationMethod {
    usl_based,
    ul_based,
    dubbed_overlap,
    live_channel_program_overlap,
    none;

    public static DeduplicationMethod getMethod(String method) {
        if (!method.isEmpty()) {
            return Arrays.stream(DeduplicationMethod.values())
                    .filter(curMethod -> method.equalsIgnoreCase(curMethod.name()))
                    .findFirst()
                    .orElse(dubbed_overlap);
        }
        return dubbed_overlap;
    }
}
