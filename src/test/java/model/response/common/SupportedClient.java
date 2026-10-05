
package model.response.common;

import lombok.Data;

@Data
public class SupportedClient {
    private String client;
    private Long maxBuildNo;
    private Long minBuildNo;
}
