package com.hmily.litespring.service.v5;


import com.hmily.litespring.beans.factory.annotation.Autowired;
import com.hmily.litespring.dao.v5.AccountDao;
import com.hmily.litespring.dao.v5.ItemDao;
import com.hmily.litespring.stereotype.Component;
import com.hmily.litespring.util.MessageTracker;

/**
 * Created by zyzhmily on 2018/7/14.
 */
@Component(value = "petStore")
public class PetStoreService {

    @Autowired
    AccountDao accountDao;
    @Autowired
    ItemDao itemDao;

    public PetStoreService() {

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
