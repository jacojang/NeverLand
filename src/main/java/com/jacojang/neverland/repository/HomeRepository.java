package com.jacojang.neverland.repository;

import com.jacojang.neverland.domain.Home;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jacojang on 16. 6. 8.
 */
@Repository
public interface HomeRepository  extends CrudRepository<Home, Long>{
}
