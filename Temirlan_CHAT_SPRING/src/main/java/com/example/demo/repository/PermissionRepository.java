package com.example.demo.repository;

import com.example.demo.model.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {
    // Дополнительные методы, если необходимо
}
