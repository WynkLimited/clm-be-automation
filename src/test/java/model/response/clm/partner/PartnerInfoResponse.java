package model.response.clm.partner;

import lombok.Data;

@Data
public class PartnerInfoResponse {
    private PartnerInfoData data;
    private Boolean success;
    private Object error;
}
