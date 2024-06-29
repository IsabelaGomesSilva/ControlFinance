package control.finance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import control.finance.domain.models.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

}