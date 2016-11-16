package main.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import main.model.Property;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface PropertyRepository extends PagingAndSortingRepository<Property, Long>
{
    @Query("select p from Property p where ( p.locationX >= ?#{[0]} and p.locationX <= ?#{[1]})"
        + " and (p.locationY >= ?#{[2]} and p.locationY <= ?#{[3]} )")
    public Page<Property> findByLocation(int ax, int ay, int bx, int by, Pageable pageable);
}
