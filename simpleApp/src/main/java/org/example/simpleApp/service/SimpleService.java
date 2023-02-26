package org.example.simpleApp.service;

import org.example.simpleApp.persistence.entity.SimpleEntity;

public interface SimpleService {

    SimpleEntity save(SimpleEntity simpleEntity);

    SimpleEntity getById (Long id);

}
