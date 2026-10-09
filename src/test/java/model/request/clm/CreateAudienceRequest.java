package model.request.clm;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateAudienceRequest {
    private String name;
    private String description;
    private List<String> tags;
    private List<CreateAudiencePartnerInfo> partnerInfo;
}
