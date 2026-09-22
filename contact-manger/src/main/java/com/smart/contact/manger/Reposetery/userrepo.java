package com.smart.contact.manger.Reposetery;

import com.smart.contact.manger.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface userrepo extends JpaRepository<user,Integer> {
    user findByEmail(String email);
}
