package sheqet.sales_analysis_panel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sheqet.sales_analysis_panel.model.Enterprise;
import sheqet.sales_analysis_panel.repository.EnterpriseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> findAll() {
        return enterpriseRepository.findAll();
    }

    public Optional<Enterprise> findById(Long id) {
        return enterpriseRepository.findById(id);
    }

    public Enterprise save(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    public void deleteById(Long id) {
        enterpriseRepository.deleteById(id);
    }
}