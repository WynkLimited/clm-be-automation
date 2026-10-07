package model.response.clm.partner;

import lombok.Data;

import java.util.Map;

@Data
public class PartnerInfoItem {
    private String id;
    private String partnerKey;
    private String displayName;
    private Map<String, DeliveryMechanismConfig> deliveryMechanism;
}
