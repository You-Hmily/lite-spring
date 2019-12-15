package com.hmily.litespring.service.v6;


import com.hmily.litespring.beans.factory.annotation.Autowired;
import com.hmily.litespring.dao.v6.AccountDao;
import com.hmily.litespring.dao.v6.ItemDao;
import com.hmily.litespring.stereotype.Component;
import com.hmily.litespring.util.MessageTracker;

/**
 * Created by zyzhmily on 2018/7/14.
 */
@Component(value = "petStore")
public class IPetStoreService {

    @Autowired
    AccountDao accountDao;
    @Autowired
    ItemDao itemDao;

    public IPetStoreService() {

    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void placeOrder(){
        System.out.println("place order");
        MessageTracker.addMsg("place order");
    }
}
