package com.keyin.model;

import jakarta.persistence.*;

@Entity
public class TreeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String numbers;

    @Lob
    private String treeStructure;

    public TreeEntity() {}

    public TreeEntity(String numbers, String treeStructure) {
        this.numbers = numbers;
        this.treeStructure = treeStructure;
    }

    public Long getId() {
        return id;
    }

    public String getNumbers() {
        return numbers;
    }

    public String getTreeStructure() {
        return treeStructure;
    }
}
