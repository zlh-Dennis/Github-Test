package com.eatingbook.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.eatingbook.dao.AccountDao;
import com.eatingbook.pojo.AccountRecord;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Resource
    private HibernateTemplate ht;
    
    @Override
    public Boolean save(AccountRecord account) {
        return (Integer)ht.save(account) > 0? true:false;
    }

    @Override
    public AccountRecord getOneById(String accountId) {
        // TODO Auto-generated method stub
        return ht.get(AccountRecord.class, accountId);
    }

    @Override
    public List<AccountRecord> getListByManagerId(String managerId) {
        // TODO Auto-generated method stub
        AccountRecord account = new AccountRecord();
        account.setManagerId(managerId);
        return ht.findByExample(account);
    }

    @Override
    public List<AccountRecord> getListByManagerLevel(Byte level) {
        // TODO Auto-generated method stub
        AccountRecord account = new AccountRecord();
        account.setLevel(level);
        return ht.findByExample(account);
    }

    @Override
    public List<AccountRecord> getListByAccountType(Boolean accountType) {
        // TODO Auto-generated method stub
        String sql = "Select * from AccountRecord where id like ?";
        return (List<AccountRecord>) ht.find(sql, "04%");
    }

    @Override
    public List<AccountRecord> getListByDate(String begin, String end) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AccountRecord> getListByOperationType(Boolean operationType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AccountRecord> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

}