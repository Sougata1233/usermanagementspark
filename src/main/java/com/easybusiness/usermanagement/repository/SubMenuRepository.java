package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.Menu;
import com.easybusiness.usermanagement.entity.SubMenu;

public interface SubMenuRepository extends JpaRepository<SubMenu, Long>{

    Optional<SubMenu> findById(Long i);

    List<SubMenu> findByMenu(Menu menu);

}
