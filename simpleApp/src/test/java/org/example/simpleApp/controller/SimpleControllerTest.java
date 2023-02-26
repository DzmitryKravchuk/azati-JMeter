package org.example.simpleApp.controller;

import org.assertj.core.api.SoftAssertions;
import org.example.simpleApp.dto.SimpleCreateRequest;
import org.example.simpleApp.mapper.SimpleMapper;
import org.example.simpleApp.persistence.entity.SimpleEntity;
import org.example.simpleApp.service.SimpleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SimpleControllerTest {
    @Mock
    private SimpleService simpleService;
    @Mock
    private SimpleMapper mapper;

    @InjectMocks
    SimpleController simpleController;

    private static final SimpleCreateRequest request = createRequest(100);

    private static final SimpleEntity modelFromRequest = createModel(null, 100);

    private static final SimpleEntity modelFromResponse = createModel(1L, 100);

    private static SimpleEntity createModel(Long id, Integer intVal) {
        SimpleEntity model = new SimpleEntity();
        model.setId(id);
        model.setIntValue(intVal);

        return model;
    }

    private static SimpleCreateRequest createRequest(Integer intValue) {
        return new SimpleCreateRequest(intValue);
    }

    @Test
    public void shouldCreate() {
        // when
        when(mapper.mapToEntity(request)).thenReturn(modelFromRequest);
        when(simpleService.save(modelFromRequest)).thenReturn(modelFromResponse);
        var actualResult = simpleController.create(request);

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult.getStatusCode()).isEqualTo(HttpStatus.OK);
            softly.assertThat(actualResult.getBody()).isEqualTo("New simpleEntity was successfully created with Id: 1");
        });
    }
}