package control.finance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import control.finance.domain.models.Cash;

@Repository
public interface CashRepository extends MongoRepository<Cash, String> {

}
