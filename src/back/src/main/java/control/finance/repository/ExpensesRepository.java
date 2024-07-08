package control.finance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import control.finance.domain.models.Expenses;

@Repository
public interface ExpensesRepository extends  MongoRepository<Expenses, String> {

}
