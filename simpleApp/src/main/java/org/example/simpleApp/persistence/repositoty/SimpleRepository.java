package org.example.simpleApp.persistence.repositoty;

import org.example.simpleApp.persistence.entity.SimpleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleRepository extends JpaRepository <SimpleEntity, Long> {
}
