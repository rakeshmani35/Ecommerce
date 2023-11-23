package com.user.api.repository;

import com.user.api.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    /**
     * multiple session for one userId
     *
     * @param id
     * @return
     */
    @Query("select s from Session s where s.user.id = ?1")
    public Optional<List<Session>> findSessionByuserId(Long id);

    /**
     * find user session by userId and token
     *
     * @param userId
     * @param token
     * @return
     */
    public Optional<Session> findSessionByuserIdAndToken(Long userId, String token);


    /**
     * Count number of sessin per userId
     *
     * @param userId
     * @return
     */
    public long countSessionByUserId(Long userId);

    /**
     * Delete all session token for user
     *
     * @param token
     */
    public void deleteSessionByToken(String token);

    Optional<Session> findByTokenAndUser_Id(String token, Long userId);
}
