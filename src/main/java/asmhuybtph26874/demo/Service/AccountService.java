package asmhuybtph26874.demo.Service;

import asmhuybtph26874.demo.Model.Account;
import asmhuybtph26874.demo.Repository.IAccoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccoutRepository accountRepository;

    @Override
    public List<Account> getList() {
        return accountRepository.findAll();
    }

    @Override
    public Account insert(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public boolean delete(int id) {
        accountRepository.deleteById(id);
        return true;
    }
@Override
public Account findByUsername(String userName) {
    return accountRepository.findByUsername(userName);
}

    @Override
    public Account findById(int id) {
        return accountRepository.findById(id).orElse(null);
    }


    @Override
    public Account login(String username, String password) {
        Account account = accountRepository.findByUsername(username);
        if (account != null && account.getPass().equals(password)) {
            return account;
        }
        return null;
    }

    @Override
    public boolean hasAdminRole(Account account) {
        return account.getRole() == 0; // Kiểm tra role là admin
    }


}
