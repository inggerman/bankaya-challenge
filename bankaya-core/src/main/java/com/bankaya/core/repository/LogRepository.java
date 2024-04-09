package com.bankaya.core.repository;


import com.bankaya.core.model.WebLog;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<WebLog,String> {

}
