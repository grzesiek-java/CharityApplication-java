package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repo.CategoryRepo;

import java.util.List;

@Service
public class JpaCategoryService implements CategoryService{

    private CategoryRepo categoryRepo;

    public JpaCategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> showAll() {
        return categoryRepo.findAll();
    }
}
