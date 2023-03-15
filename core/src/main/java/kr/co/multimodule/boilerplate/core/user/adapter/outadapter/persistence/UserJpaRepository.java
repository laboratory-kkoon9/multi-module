package kr.co.multimodule.boilerplate.core.user.adapter.outadapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Integer> {
    boolean existsByPhoneNumber(final String phoneNumber);
}
