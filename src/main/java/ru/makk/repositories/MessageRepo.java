package ru.makk.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.makk.domain.Message;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}
