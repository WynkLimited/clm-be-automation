package services.discovery;

import io.restassured.response.Response;
import model.request.segment.SegmentationCheckReq;
import utilities.BaseServiceClient;

import java.util.Map;

public class DiscoveryServices extends BaseServiceClient {

    public Response getUserPersona(
            String uid, Boolean fetch_click_rt_persona, Boolean fetchXstreamOnboarding, Boolean fetchSlotRtPersona
    ) {
        Map<String, String> queryParams = Map.of(
                "realm", appName,
                "fetch_persona", "true",
                "fetch_realtime_persona", "true",
                "fetch_custom_segments", "false",
                "fetch_click_rt_persona", fetch_click_rt_persona.toString(),
                "fetchXstreamOnboarding", fetchXstreamOnboarding.toString(),
                "fetch_slot_rt_persona", fetchSlotRtPersona.toString()
        );
        return get(
                queryParams,
                "/segmentation/v1/persona/" + uid
        );
    }

    public Response getUserPersonaIQ(
            String uid, Boolean fetch_click_rt_persona, Boolean fetchXstreamOnboarding, Boolean fetchSlotRtPersona
    ) {
        Map<String, String> queryParams = Map.of(
                "realm", appName,
                "fetch_persona", "true",
                "fetch_realtime_persona", "true",
                "fetch_custom_segments", "false",
                "fetch_click_rt_persona", fetch_click_rt_persona.toString(),
                "fetchXstreamOnboarding", fetchXstreamOnboarding.toString(),
                "fetch_slot_rt_persona", fetchSlotRtPersona.toString()
        );
        return get(
                queryParams,
                "/personaiq/v1/persona" + uid
        );
    }

    public Response getExperimentForUser(String uid) {
        return get(
                Map.of("realm", appName),
                "/segmentation/v1/persona/" + uid + "/experiment"
        );
    }

    public Response checkSegmentation(SegmentationCheckReq segmentationCheckReq) {
        return post(
                parseToJson(segmentationCheckReq), "/segmentation/v1/segmentation"
        );
    }
}
