package com.dealer.app.repository;
import com.dealer.app.domain.Dealer;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Dealer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {

}
