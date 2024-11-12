package sheqet.sales_analysis_panel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sheqet.sales_analysis_panel.model.Enterprise;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
}
