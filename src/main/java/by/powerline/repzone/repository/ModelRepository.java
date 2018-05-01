package by.powerline.repzone.repository;

import by.powerline.repzone.model.db.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findAllByBrandId(Long brandId);
}
