package com.example.corebase.core.admin.accountCreation.repository;

import com.example.corebase.entity.auth.UserAddressEntity;
import com.example.corebase.repository.auth.UserAddressRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdUserAddressRepository extends UserAddressRepository {

    @Query(value = """
        SELECT * FROM user_address
        WHERE user_id = :userId AND del_yn = :delYn
        ORDER BY created_date ASC
    """, nativeQuery = true)
    List<UserAddressEntity> findAddressByUser(@Param("userId") String userId, @Param("delYn") String delYn);

    List<UserAddressEntity> findByDelYnAndUserIdAndUserAddressSeqNotIn(String delYn, String userId, List<String> seq);
}
