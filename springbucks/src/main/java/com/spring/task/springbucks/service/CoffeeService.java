package com.spring.task.springbucks.service;

import com.spring.task.springbucks.mapper.CoffeeMapper;
import com.spring.task.springbucks.model.Coffee;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.ws.Action;
import java.util.List;

@Service
public class CoffeeService {

    @Autowired
    CoffeeMapper coffeeMapper;

    @Autowired
    RedisTemplate<String,String> redisTemplate;
    public List<Coffee> findAllCoffeeWithParam(int pageNum,int pageSize){
        List<Coffee> coffees = coffeeMapper.findAllWithParam(pageNum,pageSize);
        ValueOperations coffeeValueOperations = redisTemplate.opsForValue();
        /*
        * 数据缓存到redis中
        * */
        coffees.forEach(
                coffee -> coffeeValueOperations
                        .set(coffee.getName(),coffee.getPrice().toString()));
        return coffees;
    };

    @Transactional
    public int save(Coffee coffee){
        return coffeeMapper.save(coffee);
    };
    @Transactional
    public void updateById(Long id, Money money){
         coffeeMapper.updateById(id, money);
    };

    @Transactional
    public void deleteById(Long id){
        coffeeMapper.deleteById(id);
    };

    public Coffee findById (Long id){
        return coffeeMapper.findById(id);
    };

}
