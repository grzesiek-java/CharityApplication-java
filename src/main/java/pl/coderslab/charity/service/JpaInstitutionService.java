package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repo.InstitutionRepo;

import java.util.List;

@Service
public class JpaInstitutionService implements InstitutionService{

    private InstitutionRepo institutionRepo;

    public JpaInstitutionService(InstitutionRepo institutionRepo) {
        this.institutionRepo = institutionRepo;
    }

    @Override
    public List<Institution> showAll() {
        return institutionRepo.findAll();
    }

    @Override
    public void addInstitution(Institution institution) {
        institutionRepo.save(institution);
    }
}
