package cc.tonny.optaplanner.exercise.springbootcloudbalance.repository;

import cc.tonny.optaplanner.exercise.springbootcloudbalance.domain.CloudBalance;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CloudBalanceRepository extends PagingAndSortingRepository<CloudBalance, Long> {
}
