package com.test1234;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MySchedule
{

    @Autowired
    private TransactionTemplate txTemp;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private EntityManager em;

    @Autowired
    private AddressRepo addressRepo;

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    private void runMe()
    {
        txTemp.executeWithoutResult(t -> this.runInTx());
    }

    private void runInTx()
    {
        log.info("Run!");
        List<Person> persons = personRepo.findAll();
        if (persons.size() == 0)
        {
            Person p = new Person();
            p.setName("Vithun");
            p.setMale(true);
            p = personRepo.save(p);
            log.info("Person saved {}", p.getId());
        }

    }

}
