package model.response.origami.crud.pages;

import lombok.Data;


import java.util.List;

@Data
public class Pages {
    private List<Page> data;
    private int pageNo;
    private int pageSize;
    private int total;

}
