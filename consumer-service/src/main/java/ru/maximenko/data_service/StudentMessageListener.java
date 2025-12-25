package ru.maximenko.data_service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentMessageListener {

    private final StudentMessageRepository repository;

    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void handleStudentMessage(StudentMessage message) {
        StudentMessageEntity entity = new StudentMessageEntity();
        entity.setFullName(message.getFullName());
        entity.setPassport(message.getPassport());
        entity.setCreatedAt(message.getCreatedAt());

        repository.save(entity);
    }
}

