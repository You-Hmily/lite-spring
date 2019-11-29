package com.hmily.litespring.service.v4;


import com.hmily.litespring.beans.factory.annotation.Autowired;
import com.hmily.litespring.dao.v4.AccountDao;
import com.hmily.litespring.dao.v4.ItemDao;
import com.hmily.litespring.stereotype.Component;

/**
 * Created by zyzhmily on 2018/7/14.
 */
@Component(value = "petStore")
public class PetStoreService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private ItemDao itemDao;

    private int version;

    public PetStoreService(AccountDao accountDao, ItemDao itemDao) {
        this.accountDao = accountDao;
        this.itemDao = itemDao;
        this.version=0;
    }

    public PetStoreService(AccountDao accountDao, ItemDao itemDao, int version) {
        this.accountDao = accountDao;
        this.itemDao = itemDao;
        this.version = version;
    }

    public PetStoreService() {

    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public int getVersion() {
        return version;
    }
}
