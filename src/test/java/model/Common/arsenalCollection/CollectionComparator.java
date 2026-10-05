package model.Common.arsenalCollection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import model.Common.arsenalCollection.constants.SortingMethod;
import model.Common.arsenalCollection.constants.SortingOrder;
import lombok.*;


@Data
public class CollectionComparator  {
    private SortingMethod method;
    private SortingOrder sortingOrder;
    private CollectionComparator sorting;
    private List<String> data;

    @JsonIgnore
    public boolean needContentMeta() {
        List<SortingMethod> methods = getMethods();
        return !methods.isEmpty()
                && methods.stream().anyMatch(SortingMethod::isNeedContentMeta);
    }

    @JsonIgnore
    public boolean needUserPersona() {
        List<SortingMethod> methods = getMethods();
        return !methods.isEmpty()
                && methods.stream().anyMatch(SortingMethod::isNeedUserPersona);
    }

    @JsonIgnore
    private List<SortingMethod> getMethods() {
        List<SortingMethod> methods = new LinkedList<>();
        CollectionComparator order = this;
        while (order != null) {
            methods.add(order.method);
            order = order.getSorting();
        }

        return methods.stream().filter(Objects::nonNull).toList();
    }

    @JsonIgnore
    public boolean asc() {
        return sortingOrder == null || sortingOrder == SortingOrder.asc;
    }
}
