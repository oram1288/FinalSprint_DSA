package com.keyin.controller;

import com.keyin.model.BinarySearchTree;
import com.keyin.service.TreeService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TreeController {
    private final TreeService service;

    public TreeController(TreeService service) {
        this.service = service;
    }

    @GetMapping("/enter-numbers")
    public String enterNumbers() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam String numbers, Model model) {
        BinarySearchTree tree = new BinarySearchTree();
        for (String num : numbers.split(",")) {
            tree.insert(Integer.parseInt(num.trim()));
        }
        service.saveTree(numbers, tree);
        model.addAttribute("tree", tree);
        return "tree-view";
    }

    @GetMapping("/previous-trees")
    public String previousTrees(Model model) {
        model.addAttribute("trees", service.getAllTrees());
        return "previous-trees";
    }
}
