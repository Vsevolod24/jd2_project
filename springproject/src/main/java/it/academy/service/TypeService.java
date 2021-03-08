package it.academy.service;

import it.academy.dao.TypeDao;
import it.academy.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private TypeDao typeDao;

    @Autowired
    public TypeService(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    public TypeService(String typeName) {
    }

    public List<Type> findAll() {
        return typeDao.findAll();
    }

}
