package asmhuybtph26874.demo.Repository;

import asmhuybtph26874.demo.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccoutRepository  extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);
}
