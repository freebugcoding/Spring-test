package com.democto.kubernetes.repo;

import com.democto.kubernetes.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
