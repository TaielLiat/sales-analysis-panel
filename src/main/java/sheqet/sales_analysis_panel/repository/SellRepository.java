package sheqet.sales_analysis_panel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sheqet.sales_analysis_panel.model.Sell;

public interface SellRepository extends JpaRepository<Sell, Long> {
}
