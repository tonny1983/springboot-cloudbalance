package cc.tonny.optaplanner.exercise.springbootcloudbalance.repository;

import cc.tonny.optaplanner.exercise.springbootcloudbalance.domain.CloudComputer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CloudComputerRepository extends PagingAndSortingRepository<CloudComputer, Long> {
}
