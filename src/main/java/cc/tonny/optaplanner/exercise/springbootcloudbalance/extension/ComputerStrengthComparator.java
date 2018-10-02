package cc.tonny.optaplanner.exercise.springbootcloudbalance.extension;

import cc.tonny.optaplanner.exercise.springbootcloudbalance.domain.CloudComputer;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.Comparator;

public class ComputerStrengthComparator implements Comparator<CloudComputer> {
    @Override
    public int compare(CloudComputer o1, CloudComputer o2) {
        return new CompareToBuilder()
                .append(o2.getDifficultyIndex(), o1.getDifficultyIndex())
                .append(o1.getId(), o2.getId())
                .build();
    }
}
