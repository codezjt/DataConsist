package com.example.dataconsist.service;

import com.alibaba.fastjson.JSONObject;
import com.example.dataconsist.entity.CanalBinlogBean;
import com.example.dataconsist.entity.UserEntity;
import com.example.dataconsist.utils.RedisUtil;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//消费者监听
@Component
@RocketMQMessageListener(topic = "topic2021",consumerGroup = "ConsumerGroup",selectorExpression="*")
public class CanalConsumer implements RocketMQListener<MessageExt> {

    private final long expireTime = 600L;

    // Redis消息
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public void onMessage(MessageExt msg) {
        System.out.println("Consumer收到"+new String(msg.getBody()));

        String strlog = new String(msg.getBody());
        CanalBinlogBean binlogBean = JSONObject.parseObject(strlog, CanalBinlogBean.class);

        String type = binlogBean.getType();

        if(!binlogBean.isDdl()){
            String directory = binlogBean.getTable();
            List<UserEntity> list = binlogBean.getData();

            if("INSERT".equals(type) || "UPDATE".equals(type)){
                for (UserEntity userEntity : list){
                    String key = directory + ":" + userEntity.getId();
                    System.out.println("INSERT OR UPDATE INFO:" + key);
                    boolean res = redisUtil.set(key, JSONObject.toJSONString(userEntity), expireTime);
                    if (res){
                        System.out.println("添加成功");
                    }
                }

            }else if ("DELETE".equals(type)){
                for(UserEntity userEntity : list){
                    String key = directory + ":" + userEntity.getId();
                    System.out.println("INSERT OR UPDATE INFO:" + key);
                    redisUtil.delete(key);
                }
            }
        }
    }
}