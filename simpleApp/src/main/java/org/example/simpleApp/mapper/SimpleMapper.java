package org.example.simpleApp.mapper;

import org.example.simpleApp.dto.SimpleCreateRequest;
import org.example.simpleApp.dto.SimpleGetResponse;
import org.example.simpleApp.persistence.entity.SimpleEntity;
import org.springframework.stereotype.Component;

@Component
public class SimpleMapper {

    public SimpleEntity mapToEntity(SimpleCreateRequest request){
        SimpleEntity entity = new SimpleEntity();
        entity.setIntValue(request.getIntValue());

        return entity;
    }

    public SimpleGetResponse mapToResponse (SimpleEntity entity){
        return new SimpleGetResponse(entity.getId(), entity.getIntValue());
    }
}
