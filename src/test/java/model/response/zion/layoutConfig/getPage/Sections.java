package model.response.zion.layoutConfig.getPage;

import lombok.Data;

import java.util.List;

@Data
public class Sections {
    private List<Section> data;
    private int pageNo;
    private int pageSize;
    private int total;
}
