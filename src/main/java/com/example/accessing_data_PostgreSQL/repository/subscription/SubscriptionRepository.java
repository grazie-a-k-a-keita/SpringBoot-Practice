package com.example.accessing_data_PostgreSQL.repository.subscription;

import org.springframework.data.repository.CrudRepository;

import com.example.accessing_data_PostgreSQL.model.subscription.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

}
