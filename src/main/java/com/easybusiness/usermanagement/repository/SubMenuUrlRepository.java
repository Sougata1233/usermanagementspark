package com.easybusiness.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easybusiness.usermanagement.entity.SubMenu;
import com.easybusiness.usermanagement.entity.SubMenuUrl;

public interface SubMenuUrlRepository extends JpaRepository<SubMenuUrl, Long>{

    Optional<SubMenuUrl> findById(Long i);

    List<SubMenuUrl> findBySubMenu(SubMenu subMenu);

}
