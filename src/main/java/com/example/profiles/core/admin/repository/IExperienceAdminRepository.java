package com.example.profiles.core.admin.repository;

import com.example.profiles.entity.Experience;
import com.example.profiles.repository.ExperienceRepository;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLSelect;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
//@SQLSelect(sql = "SELECT  * FROM Experience where flag = 0")
public interface IExperienceAdminRepository extends JpaRepository<Experience, String> {
    @Query(value = """
                        select new com.example.profiles.entity.Experience(
                            exp.companyName,exp.jobTitle,exp.fromDate,exp.toDate,exp.account
                        ) from Experience exp where  exp.id = :id
            """)
    Experience getExperienceByID(@Param("id") String id);
}
