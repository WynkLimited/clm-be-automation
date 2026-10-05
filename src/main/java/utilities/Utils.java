package utilities;


import io.cucumber.datatable.DataTable;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Utils {

    private Utils(){}

    public static long calculateDateDifference(String dateStr) {
        return ChronoUnit.DAYS.between(
                LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                LocalDate.now()
        );
    }

    public static Map<String, String[]> convertMapOfStringToMapOfList(Map<String, String> data) {
        Map<String, String[]> data2 = new HashMap<>();

        for (Map.Entry<String, String> entry : data.entrySet()) {
            data2.put(entry.getKey(), entry.getValue().split(", "));
        }
        return data2;
    }

    public static Map<String, List<String>> convertIntoParamsObject(String data) {
        List<String> paramsList = List.of(data.split("&"));
        Map<String, List<String>> data2 = new HashMap<>();
        for (String s : paramsList) {
            String[] param = s.split("=");
            data2.put(param[0].trim(), List.of(param[1].trim().split(",")));
        }
        return data2;
    }

    public static Map<String, String> getParams(String url) throws Exception {

        URI uri = new URI(url);
        String query = uri.getQuery();  // everything after '?'

        Map<String, String> map = new HashMap<>();

        if (query == null || query.isEmpty()) {
            return map;
        }

        String[] params = query.split("&");

        for (String param : params) {
            String[] pair = param.split("=", 2);

            String key = URLDecoder.decode(pair[0], StandardCharsets.UTF_8.name());
            String value = "";

            if (pair.length > 1) {
                value = URLDecoder.decode(pair[1], StandardCharsets.UTF_8.name());
            }
            map.put(key, value);
        }

        return map;
    }

    public static String generateAuth(String username,String password) {
        return Base64.getEncoder()
                .encodeToString((username + ":" + password)
                        .getBytes(StandardCharsets.UTF_8));
    }

    public static String jsonToBody(String jsonPath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(jsonPath)));
    }

    public static List<Map<String, String>> convertDataTableToMap(DataTable dataTable) throws IOException {
        return dataTable.asMaps(String.class, String.class);
    }

    public static boolean checkDateRange(String timestamp, int end){

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        ZonedDateTime watchedTime =
                ZonedDateTime.parse(timestamp, formatter);

        ZonedDateTime now = ZonedDateTime.now();

        ZonedDateTime twentyFiveDaysAgo = now.minusDays(end+1);

        return
                !watchedTime.isBefore(twentyFiveDaysAgo) &&
                        !watchedTime.isAfter(now);


    }

    public static boolean checkDateRange(String timestamp, int start, int end){
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        ZonedDateTime watchedTime =
                ZonedDateTime.parse(timestamp, formatter);

        ZonedDateTime now = ZonedDateTime.now();

        ZonedDateTime from = now.minusDays(end+1);
        ZonedDateTime to = now.minusDays(start);

               return  !watchedTime.isBefore(from) &&
                        !watchedTime.isAfter(to);
    }
}
