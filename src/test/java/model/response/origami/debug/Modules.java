package model.response.origami.debug;

import lombok.Data;

import java.util.List;

@Data
public class Modules {
    private List<Module> data;
    private int pageNo;
    private int pageSize;
    private int total;
}
