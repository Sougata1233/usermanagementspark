package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.easybusiness.usermanagement.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long>{

    Optional<Menu> findById(Long i);

    List<Menu> findByMenuName(String menuName);

    // custom query example and return a stream
    @Query("select m from Menu m where m.menuName = :menuName")
    Stream<Menu> findByMenuNameReturnStream(@Param("menuName") String menuName);

    

}
