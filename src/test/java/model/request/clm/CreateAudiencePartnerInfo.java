package model.request.clm;

import lombok.Builder;
import lombok.Data;
import model.response.clm.partner.DeliveryMechanismConfig;

import java.util.Map;

@Data
@Builder
public class CreateAudiencePartnerInfo {
    private String id;
    private String partnerKey;
    private String displayName;
    private Map<String, DeliveryMechanismConfig> deliveryMechanism;
    private String name;
    private String status;
}
