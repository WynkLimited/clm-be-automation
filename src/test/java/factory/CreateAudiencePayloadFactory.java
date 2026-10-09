package factory;

import model.request.clm.CreateAudiencePartnerInfo;
import model.request.clm.CreateAudienceRequest;
import model.response.clm.partner.DeliveryMechanismConfig;
import model.response.clm.partner.PartnerInfoItem;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static helpers.ApiHelper.parseToJson;

public final class CreateAudiencePayloadFactory {

    private CreateAudiencePayloadFactory() {
    }

    /**
     * Builds create-audience JSON body from partner info + tags.
     */
    public static String buildRequestBody(PartnerInfoItem sourcePartner, List<String> tags) {
        return parseToJson(buildRequest(sourcePartner, tags));
    }

    public static CreateAudienceRequest buildRequest(PartnerInfoItem sourcePartner, List<String> tags) {
        CreateAudiencePartnerInfo partnerPayload = CreateAudiencePartnerInfo.builder()
                .id(sourcePartner.getId())
                .partnerKey(sourcePartner.getPartnerKey())
                .displayName(sourcePartner.getDisplayName())
                .deliveryMechanism(buildDeliveryMechanism(sourcePartner))
                .name(sourcePartner.getDisplayName() != null
                        ? sourcePartner.getDisplayName()
                        : sourcePartner.getPartnerKey())
                .status("ACTIVE")
                .build();

        return CreateAudienceRequest.builder()
                .name("auto_audience_" + Instant.now().toEpochMilli())
                .description("Created by automation")
                .tags(tags)
                .partnerInfo(List.of(partnerPayload))
                .build();
    }

    public static Map<String, String> saveQueryParams() {
        return Map.of(
                "visibility", "PRIVATE",
                "scope", "PERSISTENT",
                "status", "DRAFT"
        );
    }

    private static Map<String, DeliveryMechanismConfig> buildDeliveryMechanism(PartnerInfoItem sourcePartner) {
        Map<String, DeliveryMechanismConfig> deliveryMechanism = new HashMap<>();
        if (sourcePartner.getDeliveryMechanism() != null) {
            sourcePartner.getDeliveryMechanism().forEach((key, value) -> {
                DeliveryMechanismConfig config = new DeliveryMechanismConfig();
                config.setActive(value != null && Boolean.TRUE.equals(value.getActive()));
                config.setSelected(Boolean.TRUE.equals(config.getActive()));
                deliveryMechanism.put(key, config);
            });
        }
        if (deliveryMechanism.isEmpty()) {
            DeliveryMechanismConfig pull = new DeliveryMechanismConfig();
            pull.setActive(true);
            pull.setSelected(true);
            deliveryMechanism.put("PULL", pull);
        }
        return deliveryMechanism;
    }
}
