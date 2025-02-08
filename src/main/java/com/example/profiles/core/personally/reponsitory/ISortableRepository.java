package com.example.profiles.core.personally.reponsitory;

import com.example.profiles.repository.SortableRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISortableRepository extends SortableRepository {

    @Query(value = """
            select  sab.value from sortable sab where sab.id = :cityzenCard and sab.flag = 0
            """, nativeQuery = true)
    String getValueByCityzenCard(@Param("cityzenCard") String cityzenCard);
}
