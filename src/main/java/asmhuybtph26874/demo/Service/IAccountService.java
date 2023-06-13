package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.Account;

import java.util.List;

public interface IAccountService {
    List<Account> getList();

    Account insert(Account account);

    boolean delete(int id);

//    Account update(Integer id, Account account);

    Account findByUsername(String userName);
    Account findById(int id);
    Account login(String username, String password);
    boolean hasAdminRole(Account account);
}
