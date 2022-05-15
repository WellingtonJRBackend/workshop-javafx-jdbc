package com.example.modelService;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import com.example.modelEntities.Departament;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    public List <Departament> findAll (){
        List <Departament> list = new ArrayList<>();
        list.add(new Departament(new SimpleIntegerProperty(1),new SimpleStringProperty("Books")));
        list.add(new Departament(new SimpleIntegerProperty(2),new SimpleStringProperty("Computers")));
        list.add(new Departament(new SimpleIntegerProperty(3),new SimpleStringProperty("Electronics")));
        return list;
    }
}