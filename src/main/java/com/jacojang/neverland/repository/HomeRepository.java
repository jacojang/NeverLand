package com.jacojang.neverland.repository;

import com.jacojang.neverland.domain.Home;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jacojang on 16. 6. 8.
 */
@Repository
public interface HomeRepository  extends CrudRepository<Home, Long>{
    List<Home> findAllByOrderByTypeDesc();
    List<Home> findAllByOrderByCheckDateDesc();
    List<Home> findAllByOrderBySizeAsc();
    List<Home> findAllByOrderByPriceAsc();
    List<Home> findAllByOrderByNameAsc();
}
