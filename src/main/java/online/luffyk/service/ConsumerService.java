package online.luffyk.service;

import online.luffyk.domain.Consumer;

public interface ConsumerService {
   Consumer SelectConsumerByUserNameAndPasswordService(Consumer consumer);

   Integer insertOneConsumerService(Consumer consumer);
}
