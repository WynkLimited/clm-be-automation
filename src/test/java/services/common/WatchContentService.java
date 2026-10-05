package services.common;

import io.restassured.response.Response;
import model.request.watchInfo.UserWatchInfoRequest;
import utilities.BaseServiceClient;

import java.util.Map;

import static helpers.ApiHelper.parseToJson;

public class WatchContentService extends BaseServiceClient {

    public Response getWatchHistory(String userID) {
        return get("watchContentApiUrl",
                Map.of("uid", userID), "/get/userWatchInfo"
        );
    }

    /**
     * POST /v2/user/watch/info?uid={uid}
     */
    public Response getUserWatchInfo(String uid, UserWatchInfoRequest requestBody) {
        return post(
                "watchContentApiUrl",
                Map.of("uid", uid),
                parseToJson(requestBody),
                "/v2/user/watch/info"
        );
    }
}
