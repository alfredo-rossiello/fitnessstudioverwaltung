package org.example.fitnessstudioverwaltung.Interface;

import org.example.fitnessstudioverwaltung.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBaseRepositoryInterface {
    public BaseType save(BaseType basetype);
}
