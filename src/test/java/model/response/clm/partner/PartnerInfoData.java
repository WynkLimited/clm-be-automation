package model.response.clm.partner;

import lombok.Data;

import java.util.List;

@Data
public class PartnerInfoData {
    private String id;
    private List<PartnerInfoItem> partnerInfo;
}
