package com.example.modelEntities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.Objects;

public class Departament implements Serializable {
    private static final long serialVersionUID = 1L;
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;

    public Departament(SimpleIntegerProperty id, SimpleStringProperty name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departament that = (Departament) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Departament{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}

