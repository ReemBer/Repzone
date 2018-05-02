package by.powerline.repzone.repository;

import by.powerline.repzone.model.db.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 21.02.2018 1:17
 */
@Repository
public interface ServiceModelRepository extends JpaRepository<ServiceModel, Long> {
    ServiceModel findServiceByEmail(String email);
    ServiceModel findAllByRegionId(Long regionId);
}
