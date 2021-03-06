package com.jacojang.neverland.repository;

import com.jacojang.neverland.domain.LandUri;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jacojang on 16. 6. 7.
 */
@Repository
public interface LandUriRepository extends CrudRepository<LandUri, Long>{
}
