package com.dt.gamv.plant.repo;

import com.dt.gamv.plant.bo.PlantBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;
import java.util.Optional;

public interface PlantRepo extends JpaRepository<PlantBO, String> {

        @Procedure
        public List<PlantBO> retrievePlants();

        public Optional<PlantBO> findByPcodeAndEnabledIsTrue(String code);

}
