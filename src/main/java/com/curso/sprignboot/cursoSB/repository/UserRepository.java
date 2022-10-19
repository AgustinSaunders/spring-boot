package com.curso.sprignboot.cursoSB.repository;

import com.curso.sprignboot.cursoSB.dto.UserDto;
import com.curso.sprignboot.cursoSB.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name LIKE ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    @Query("SELECT new com.curso.sprignboot.cursoSB.dto.UserDto(u.id, u.name, u.birthDate) " +
    "FROM User u " +
    "WHERE u.birthDate=:parameterDate " +
    "AND u.email=:parameterEmail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parameterDate") LocalDate date,
                                                @Param("parameterEmail") String email);

    List<User> findAll();
}
