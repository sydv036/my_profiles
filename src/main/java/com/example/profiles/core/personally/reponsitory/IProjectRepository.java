package com.example.profiles.core.personally.reponsitory;

import com.example.profiles.core.personally.dtos.response.ProjectResponse;
import com.example.profiles.repository.ProjectRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectRepository extends ProjectRepository {

    @Query(value = """
                    select prj.id        as id,
                           prj.project_name as projectName,
                           prj.job_title as jobTitle,
                           prj.from_date as fromDate,
                           prj.to_date   as toDate,
                           prj.description
                    from projects prj
                    where prj.accountid = :citizenCard
            """, nativeQuery = true)
    List<ProjectResponse> getProjectByCitizenCard(@Param("citizenCard") String citizenCard);
}
