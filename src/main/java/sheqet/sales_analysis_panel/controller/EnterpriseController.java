package sheqet.sales_analysis_panel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sheqet.sales_analysis_panel.model.Enterprise;
import sheqet.sales_analysis_panel.service.EnterpriseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enterprises")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping
    public List<Enterprise> getAllEnterprises() {
        return enterpriseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enterprise> getEnterpriseById(@PathVariable Long id) {
        Optional<Enterprise> enterprise = enterpriseService.findById(id);
        return enterprise.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Enterprise> createEnterprise(@RequestBody Enterprise enterprise) {
        Enterprise savedEnterprise = enterpriseService.save(enterprise);
        return ResponseEntity.ok(savedEnterprise);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Enterprise> updateEnterprise(@PathVariable Long id, @RequestBody Enterprise enterpriseDetails) {
        Optional<Enterprise> enterprise = enterpriseService.findById(id);
        if (enterprise.isPresent()) {
            Enterprise updatedEnterprise = enterprise.get();
            updatedEnterprise.setName(enterpriseDetails.getName());
            updatedEnterprise.setAddress(enterpriseDetails.getAddress());
            updatedEnterprise.setPhone(enterpriseDetails.getPhone());
            updatedEnterprise.setEmail(enterpriseDetails.getEmail());
            return ResponseEntity.ok(enterpriseService.save(updatedEnterprise));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnterprise(@PathVariable Long id) {
        if (enterpriseService.findById(id).isPresent()) {
            enterpriseService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
