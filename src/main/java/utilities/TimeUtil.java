package utilities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class TimeUtil {

    private TimeUtil() {}

    public static String convert(String dateTime, String sourceFormat, String targetFormat) {

        DateTimeFormatter targetFormatter = DateTimeFormatter.ofPattern(targetFormat);

        // epoch milliseconds input
        if ("epoch".equalsIgnoreCase(sourceFormat)) {
            long millis = Long.parseLong(dateTime);

            return Instant.ofEpochMilli(millis)
                    .atZone(ZoneId.systemDefault())
                    .format(targetFormatter);
        }

        DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern(sourceFormat);
        LocalDateTime parsedDate = LocalDateTime.parse(dateTime, sourceFormatter);

        return parsedDate.format(targetFormatter);
    }


    public static long toMillis(String dateTime, String sourceFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(sourceFormat);
        LocalDateTime parsedDate = LocalDateTime.parse(dateTime, formatter);

        return parsedDate
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    public static long toMicros(String dateTime, String sourceFormat) {
        return toMillis(dateTime, sourceFormat) * 1000;
    }
}
