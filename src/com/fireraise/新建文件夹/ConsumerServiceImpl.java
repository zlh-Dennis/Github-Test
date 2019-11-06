package com.eatingbook.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eatingbook.dao.ConsumerDao;
import com.eatingbook.pojo.Consumer;
import com.eatingbook.service.ConsumerService;
import com.eatingbook.util.AccountUtil;
import com.eatingbook.util.DateHandleUtil;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Resource
    private ConsumerDao consumerDao;

    @Override
    public Boolean save(Consumer consumer) {
        // TODO Auto-generated method stub
        return consumerDao.save(consumer);
    }

    @Override
    public Consumer getOneById(String consumerId) {
        // TODO Auto-generated method stub
        return consumerDao.getOneById(consumerId);
    }

    @Override
    public Consumer getOneByIdentification(String identification) {
        // TODO Auto-generated method stub
        return AccountUtil.phoneOrEmail(identification) ? consumerDao.getOneByPhone(identification)
                : consumerDao.getOneByEmail(identification);
    }

    @Override
    public Consumer getOneByPhone(String phone) {
        // TODO Auto-generated method stub
        return consumerDao.getOneByPhone(phone);
    }

    @Override
    public Consumer getOneByEmail(String email) {
        // TODO Auto-generated method stub
        return consumerDao.getOneByEmail(email);
    }

    @Override
    public Consumer getOneByInviteCode(String inviteCode) {
        // TODO Auto-generated method stub
        return consumerDao.getOneByInviteCode(inviteCode);
    }

    @Override
    public Consumer getOneByImageId(String imageId) {
        // TODO Auto-generated method stub
        return consumerDao.getOneByImageId(imageId);
    }

    @Override
    public List<Consumer> getListByCreateDate(String begin, String end) {
        // TODO Auto-generated method stub
        return consumerDao.getListByCreateDate(begin, end);
    }

    @Override
    public List<Consumer> getListByInvitorId(String invitorId) {
        // TODO Auto-generated method stub
        return consumerDao.getListByInvitorId(invitorId);
    }

    @Override
    public List<Consumer> getListByState(Boolean state) {
        // TODO Auto-generated method stub
        return consumerDao.getListByState(state);
    }

    @Override
    public List<Consumer> getListByVip(Boolean vipState) {
        // TODO Auto-generated method stub
        return consumerDao.getListByVip(vipState);
    }

    @Override
    public Boolean updatePassword(String consumerId, String password) {
        // TODO Auto-generated method stub
        return consumerDao.updatePassword(consumerId, password);
    }

    @Override
    public Boolean updateImage(String consumerId, String image) {
        // TODO Auto-generated method stub
        return consumerDao.updateImage(consumerId, image);
    }

    @Override
    public Boolean updateName(String consumerId, String name) {
        // TODO Auto-generated method stub
        return consumerDao.updateName(consumerId, name);
    }

    @Override
    public Boolean updateMoney(String consumerId, Double money) {
        // TODO Auto-generated method stub
        return consumerDao.updateMoney(consumerId, money);
    }

    @Override
    public Boolean updateCoin(String consumerId, Integer coin) {
        // TODO Auto-generated method stub
        return consumerDao.updateCoin(consumerId, coin);
    }

    @Override
    public Boolean updatePhone(String consumerId, String phone) {
        // TODO Auto-generated method stub
        return consumerDao.updatePhone(consumerId, phone);
    }

    @Override
    public Boolean updateEmail(String consumerId, String email) {
        // TODO Auto-generated method stub
        return consumerDao.updateEmail(consumerId, email);
    }

    @Override
    public Boolean openVip(String consumerId) {
        // 开通一个月的会员
        String begin = DateHandleUtil.toString(new Date());
        return null;
    }

    @Override
    public void dateFilter(List<Consumer> list, String begin, String end) {
        // 如果起始时间和终止时间全部为空,说明不需要过滤,直接终止
        if ("".equals(begin) && "".equals(end))
            return;

        // 被遗弃的元素集合,将原集合中不符合要求的元素暂存于此集合中
        List<Consumer> derelict = new ArrayList<Consumer>();
        list.forEach((consumer) -> {
            if (!DateHandleUtil.inDate(consumer.getDate(), begin, end))
                derelict.add(consumer);
        });

        // 遍历被遗弃的元素集合,将此集合中的元素从原集合中剔除
        derelict.forEach(consumer -> list.remove(consumer));
    }

    @Override
    public void stateFilter(List<Consumer> list, Boolean state) {
        // 被遗弃的元素集合,将原集合中不符合要求的元素暂存于此集合中
        List<Consumer> derelict = new ArrayList<Consumer>();
        list.forEach((consumer) -> {
            if (!consumer.getState() == state)
                derelict.add(consumer);
        });

        // 遍历被遗弃的元素集合,将此集合中的元素从原集合中剔除
        derelict.forEach(consumer -> list.remove(consumer));
    }

    @Override
    public void vipFilter(List<Consumer> list, Boolean vip) {
        // 被遗弃的元素集合,将原集合中不符合要求的元素暂存于此集合中
        List<Consumer> derelict = new ArrayList<Consumer>();
        list.forEach((consumer) -> {
            if (!consumer.getVip() == vip)
                derelict.add(consumer);
        });

        // 遍历被遗弃的元素集合,将此集合中的元素从原集合中剔除
        derelict.forEach(consumer -> list.remove(consumer));
    }

}