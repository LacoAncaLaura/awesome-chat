package org.fasttrackit.awesomechat.persistance;

import org.fasttrackit.awesomechat.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChatRepository extends JpaRepository<Chat, Long> {

}
