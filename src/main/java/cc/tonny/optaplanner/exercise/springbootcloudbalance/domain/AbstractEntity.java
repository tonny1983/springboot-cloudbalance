package cc.tonny.optaplanner.exercise.springbootcloudbalance.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import java.io.Serializable;

public class AbstractEntity implements Serializable, Comparable<AbstractEntity> {
    @Setter
    @Getter
    @PlanningId
    protected Long id;

    protected AbstractEntity() {
    }

    protected AbstractEntity(Long id) {
        this.id = id;
    }

    @Override
    public int compareTo(AbstractEntity o) {
        return new CompareToBuilder().append(getClass().getName(), o.getClass().getName())
                .append(id, o.id).toComparison();
    }

    @Override
    public String toString() {
        return getClass().getName().replaceAll(".*\\.", "") + "-" + id;
    }
}
