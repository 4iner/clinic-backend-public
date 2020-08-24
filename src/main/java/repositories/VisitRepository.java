package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import models.Visit;
import models.enums.PlasticSurgeryProcedure;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer>, JpaSpecificationExecutor<Visit> {
    List<Visit> findByPlasticSurgeryProcedure(PlasticSurgeryProcedure procedure);
}