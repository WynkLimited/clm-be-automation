package model.response.clm.tag;

import lombok.Data;

@Data
public class TagCatalogResponse {
    private TagCatalogData data;
    private Boolean success;
    private Object error;
}
