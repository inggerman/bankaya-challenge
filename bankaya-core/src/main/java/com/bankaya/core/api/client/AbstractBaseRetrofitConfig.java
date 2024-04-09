package com.bankaya.core.api.client;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseRetrofitConfig {

    @Autowired
    protected RetrofitRepositoryBuilder retrofitRepositoryBuilder;
}
