package com.jacojang.neverland.service;

import com.jacojang.neverland.domain.Home;
import com.jacojang.neverland.domain.LandUri;
import com.jacojang.neverland.repository.HomeRepository;
import com.jacojang.neverland.repository.LandUriRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jacojang on 16. 6. 8.
 */
@Service
public class HomeService {
    private HomeRepository homeRepository;
    private LandUriRepository landUriRepository;
    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    public HomeService(HomeRepository homeRepository, LandUriRepository landUriRepository){
        this.homeRepository = homeRepository;
        this.landUriRepository = landUriRepository;
    }

    public Iterable<Home> list(boolean rebuild) {
        if(rebuild){
            this.rebuild();
        }
        return homeRepository.findAll();
    }

    private void rebuild() {
        homeRepository.deleteAll();

        Iterable<LandUri> landUris = this.landUriRepository.findAll();
        LandHttpClientService landClient = new LandHttpClientService();

        for(LandUri landUri: landUris){
            landClient.get(landUri.getUri());
        }
    }
}
