package org.example.demo_jstl.service;

import org.example.demo_jstl.entity.ClassCG;
import org.example.demo_jstl.repository.ClassRepository;
import org.example.demo_jstl.repository.IClassRepository;

import java.util.List;

public class ClassService implements IClassService{
    private IClassRepository classRepository = new ClassRepository();
    @Override
    public List<ClassCG> findAll() {
        return classRepository.findAll();
    }
}
