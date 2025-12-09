package org.example.demo_jstl.repository;

import org.example.demo_jstl.entity.ClassCG;

import java.util.List;

public interface IClassRepository {
    List<ClassCG> findAll();
}
