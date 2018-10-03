package cc.tonny.optaplanner.exercise.springbootcloudbalance.repository;

import cc.tonny.optaplanner.exercise.springbootcloudbalance.domain.CloudProcess;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CloudProcessRepository extends PagingAndSortingRepository<CloudProcess, Long> {
}
