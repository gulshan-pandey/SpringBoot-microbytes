package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TestEntityService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TestRepo testRepo;

    public TestEntity getEntity(long id) {
        // Hibernate 2nd-level cache will handle this
        return testRepo.findById(id).orElse(null);
    }

    @Transactional
    public TestEntity saveEntity(TestEntity testEntity) {
        TestEntity saved = testRepo.save(testEntity);

        entityManager.detach(saved);
        // Force load to populate 2nd-level cache
        testRepo.findById(saved.getId());

        return saved;
    }


    @Transactional
    public TestEntity updateEntity(TestEntity testEntity) {
        return testRepo.save(testEntity); // Hibernate evicts and puts new version
    }
}
