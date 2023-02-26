package org.example.simpleApp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.simpleApp.exception.ResourceNotFoundException;
import org.example.simpleApp.persistence.entity.SimpleEntity;
import org.example.simpleApp.persistence.repositoty.SimpleRepository;
import org.example.simpleApp.service.SimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SimpleServiceImpl implements SimpleService {
    private final SimpleRepository repository;

    @Override
    public SimpleEntity save(SimpleEntity simpleEntity) {
        log.info("SimpleServiceImpl save {}", simpleEntity);
        return repository.save(simpleEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public SimpleEntity getById(Long id) {
        log.info("SimpleServiceImpl get by id: {}", id);
        return repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("SimpleEntity with index " + id + " not found"));
    }
}
