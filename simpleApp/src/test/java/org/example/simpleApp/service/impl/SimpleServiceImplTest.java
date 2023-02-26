package org.example.simpleApp.service.impl;

import org.assertj.core.api.Assertions;
import org.example.simpleApp.persistence.entity.SimpleEntity;
import org.example.simpleApp.service.SimpleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class SimpleServiceImplTest {

    @Autowired
    SimpleService service;

    private final static Long ID = 1L;
    private final static Integer INT_VAL = 100;

    @Test
    void shouldSaveNewEntity() {
        // given
        SimpleEntity model = new SimpleEntity();
        model.setId(ID);
        model.setIntValue(INT_VAL);

        // when
        SimpleEntity newModel = service.save(model);
        SimpleEntity modelFromBase = service.getById(ID);

        // then
        Assertions.assertThat(newModel.getId()).isEqualTo(ID);
        Assertions.assertThat(newModel.getIntValue()).isEqualTo(INT_VAL);

        Assertions.assertThat(modelFromBase.getIntValue()).isEqualTo(INT_VAL);

    }
}
