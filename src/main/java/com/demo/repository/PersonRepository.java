package com.demo.repository;

import com.demo.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.transaction.Transactional;

/**
 * Created by mcenjoy
 * on 04/02/2020
 */
@Repository
@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findPersonByName(String name);
    List<Person> findPersonByEmail(String email);
    List<Person> findPersonByNameAndEmail(String name, String email);

    @Query("select e from Person e where e.name= :name and e.country= :country")
    List<Person> getCountry(@Param("name") String name, @Param("country") String country);
}
