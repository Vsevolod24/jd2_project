package it.academy.dao;

import it.academy.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitDao extends JpaRepository<Unit, Integer> {
}
