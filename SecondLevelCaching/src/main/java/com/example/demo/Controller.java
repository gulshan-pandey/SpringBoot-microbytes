package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    @Autowired
    private TestRepo testRepo;

        @Autowired
        TestEntityService testEntityService;



    @PostMapping("/set")
    public TestEntity set(@RequestBody TestEntity testEntity) {
        TestEntity saved = testEntityService.saveEntity(testEntity);

        // Test that the entity is now in cache (optional)
        TestEntity fromCache = testEntityService.getEntity(saved.getId());

        return saved;
    }

    @GetMapping("/get/{id}")
    public TestEntity get(@PathVariable Long id) {
        return testEntityService.getEntity(id);
    }


    @PutMapping("/update/{id}")
    public TestEntity update(@PathVariable Long id, @RequestBody TestEntity testEntity) {
        TestEntity testEntityOrg = testEntityService.getEntity(id);
        testEntityOrg.setUsername(testEntity.getUsername());
        return  testEntityService.updateEntity(testEntityOrg);

    }




}
