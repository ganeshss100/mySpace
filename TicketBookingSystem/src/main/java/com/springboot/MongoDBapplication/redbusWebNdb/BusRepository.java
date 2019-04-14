package com.springboot.MongoDBapplication.redbusWebNdb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<Bus, String>{

}
