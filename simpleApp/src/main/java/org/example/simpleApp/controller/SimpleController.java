package org.example.simpleApp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.simpleApp.dto.SimpleCreateRequest;
import org.example.simpleApp.dto.SimpleGetResponse;
import org.example.simpleApp.mapper.SimpleMapper;
import org.example.simpleApp.persistence.entity.SimpleEntity;
import org.example.simpleApp.service.SimpleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/simple")
@RequiredArgsConstructor
public class SimpleController {
    private final SimpleMapper mapper;
    private final SimpleService service;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody SimpleCreateRequest request) {
        log.info("create()");
        SimpleEntity model = service.save(mapper.mapToEntity(request));
        String response = "New simpleEntity was successfully created with Id: " + model.getId();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimpleGetResponse> getById(@PathVariable Long id) {
        log.info("getById({})", id);

        var model = service.getById(id);
        var response = mapper.mapToResponse(model);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
