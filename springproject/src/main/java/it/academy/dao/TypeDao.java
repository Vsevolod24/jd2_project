package it.academy.dao;

import it.academy.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDao extends JpaRepository<Type, Integer> {
}
