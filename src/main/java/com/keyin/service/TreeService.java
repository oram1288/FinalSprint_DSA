package com.keyin.service;

import com.keyin.model.BinarySearchTree;
import com.keyin.model.TreeEntity;
import com.keyin.model.TreeNode;
import com.keyin.repository.TreeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {
    private final TreeRepository repository;

    public TreeService(TreeRepository repository) {
        this.repository = repository;
    }

    public TreeEntity saveTree(String numbers, BinarySearchTree tree) {
        String treeStructure = serializeTree(tree.getRoot());
        TreeEntity entity = new TreeEntity(numbers, treeStructure);
        return repository.save(entity);
    }

    public List<TreeEntity> getAllTrees() {
        return repository.findAll();
    }

    private String serializeTree(TreeNode node) {
        if (node == null) {
            return "null";
        }
        return node.getValue() + "," + serializeTree(node.getLeft()) + "," + serializeTree(node.getRight());
    }
}
