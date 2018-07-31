package com.hmily.litespring.service.v2;

import com.hmily.litespring.dao.v2.AccountDao;
import com.hmily.litespring.dao.v2.ItemDao;

/**
 * Created by zyzhmily on 2018/7/14.
 */
public class PetStoreService {
    private AccountDao accountDao;

    private ItemDao itemDao;

    private String env;

    private int version;

    private boolean select;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
