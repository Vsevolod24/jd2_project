package it.academy.service;

import it.academy.dao.UnitDao;
import it.academy.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    private UnitDao unitDao;

    @Autowired
    public UnitService(UnitDao unitDao) {
        this.unitDao = unitDao;
    }

    public UnitService(String unitName) {

    }

    public List<Unit> findAll() {
        return unitDao.findAll();
    }

}
