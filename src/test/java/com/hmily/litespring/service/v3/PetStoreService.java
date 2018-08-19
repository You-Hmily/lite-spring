package com.hmily.litespring.service.v3;


import com.hmily.litespring.dao.v3.AccountDao;
import com.hmily.litespring.dao.v3.ItemDao;

/**
 * Created by zyzhmily on 2018/7/14.
 */
public class PetStoreService {
    private AccountDao accountDao;

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
