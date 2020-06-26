package org.fasttrackit.awesomechat.persistance;

import org.fasttrackit.awesomechat.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <User, Long> {


}
