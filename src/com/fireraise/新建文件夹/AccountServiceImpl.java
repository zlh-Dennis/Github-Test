package com.eatingbook.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eatingbook.dao.AccountDao;
import com.eatingbook.pojo.AccountRecord;
import com.eatingbook.service.AccountService;
import com.eatingbook.util.DateHandleUtil;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;
    
    @Override
    public Boolean save(AccountRecord account) {
        // TODO Auto-generated method stub
        return accountDao.save(account);
    }

    @Override
    public AccountRecord getOneById(String accountId) {
        // TODO Auto-generated method stub
        return accountDao.getOneById(accountId);
    }

    @Override
    public List<AccountRecord> getListByManagerId(String managerId) {
        // TODO Auto-generated method stub
        return accountDao.getListByManagerId(managerId);
    }

    @Override
    public List<AccountRecord> getListByManagerLevel(Byte level) {
        // TODO Auto-generated method stub
        return accountDao.getListByManagerLevel(level);
    }

    @Override
    public List<AccountRecord> getListByAccountId(String accountId) {
        // TODO Auto-generated method stub
        return accountDao.getListByAccountId(accountId);
    }

    @Override
    public List<AccountRecord> getListByAccountType(Boolean accountType) {
        // TODO Auto-generated method stub
        return accountDao.getListByAccountType(accountType);
    }

    @Override
    public List<AccountRecord> getListByDate(String begin, String end) {
        // TODO Auto-generated method stub
        return accountDao.getListByDate(begin, end);
    }

    @Override
    public List<AccountRecord> getListByOperationType(Boolean operationType) {
        // TODO Auto-generated method stub
        return accountDao.getListByOperationType(operationType);
    }

    @Override
    public List<AccountRecord> getAll() {
        // TODO Auto-generated method stub
        return accountDao.getAll();
    }

    /**
     * 时间过滤
     * 将作为参数传递过来的List集合剔除起始时间与终止时间之外的元素
     * @param list 要进行过滤的集合
     * @param begin 起始时间
     * @param end 终止时间
     */
    @Override
    public void dateFilter(List<AccountRecord> list, String begin, String end) {
        
        // 如果起始时间和终止时间全部为空,说明不需要过滤,直接终止
        if("".equals(begin) && "".equals(end))
            return;
        
        // 被遗弃的元素集合,将原集合中不符合要求的元素暂存于此集合中
        List<AccountRecord> derelict = new ArrayList<AccountRecord>();
        list.forEach((account) -> {
            if(!DateHandleUtil.inDate(account.getDate(), begin, end))
                derelict.add(account);
        });
        
        // 遍历被遗弃的元素集合,将此集合中的元素从原集合中剔除
        derelict.forEach(account -> list.remove(account));
    }

    /**
     * 管理员权限过滤
     * 将作为参数传递过来的List集合剔除与管理员权限不符的元素
     * @param list 要进行过滤的集合
     * @param managerLevel 管理员权限等级
     */
    @Override
    public void managerLevelFilter(List<AccountRecord> list, Byte managerLevel) {
        
        // 如果管理员权限等级为空,说明不需要过滤,直接终止
        if(null == managerLevel)
            return;
        
        // 被遗弃的元素集合,将原集合中不符合要求的元素暂存于此集合中
        List<AccountRecord> derelict = new ArrayList<AccountRecord>();
        list.forEach((account) -> {
            if(account.getLevel() != managerLevel)
                derelict.add(account);
        });
        
        // 遍历被遗弃的元素集合,将此集合中的元素从原集合中剔除
        derelict.forEach(account -> list.remove(account));
    }

    /**
     * 管理员id过滤
     * 将作为参数传递过来的List集合剔除与管理员id不符的元素
     * @param list 要进行过滤的集合
     * @param managerId 管理员id
     */
    @Override
    public void managerIdFilter(List<AccountRecord> list, String managerId) {
        
        // 如果管理员id为空,说明不需要过滤,直接终止
        if("".equals(managerId))
            return;
        
        // 被遗弃的元素集合,将原集合中不符合要求的元素暂存于此集合中
        List<AccountRecord> derelict = new ArrayList<AccountRecord>();
        list.forEach((account) -> {
            if(account.getManagerId() != managerId)
                derelict.add(account);
        });
        
        // 遍历被遗弃的元素集合,将此集合中的元素从原集合中剔除
        derelict.forEach(account -> list.remove(account));
        
    }

    /**
     * 操作类型过滤
     * 将作为参数传递过来的List集合剔除与操作类型不符的元素
     * @param list 要进行过滤的集合
     * @param operationType 操作类型
     */
    @Override
    public void operationTypeFilter(List<AccountRecord> list, Boolean operationType) {
        
        // 如果操作类型为空,说明不需要过滤,直接终止
        if(null == operationType)
            return;
        
        // 被遗弃的元素集合,将原集合中不符合要求的元素暂存于此集合中
        List<AccountRecord> derelict = new ArrayList<AccountRecord>();
        list.forEach((account) -> {
            if(account.getOperation() != operationType)
                derelict.add(account);
        });
        
        // 遍历被遗弃的元素集合,将此集合中的元素从原集合中剔除
        derelict.forEach(account -> list.remove(account));
    }
    
}