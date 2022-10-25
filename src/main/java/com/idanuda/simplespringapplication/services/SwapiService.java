package com.idanuda.simplespringapplication.services;

import com.idanuda.simplespringapplication.repositories.SwapiRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SwapiService {

    private SwapiRepository swapiRepository;
    public SwapiService(SwapiRepository swapiRepository){

        this.swapiRepository = swapiRepository;
    }

    public Map getPeople (Integer id){
        Map<String, Object> originalPeople = this.swapiRepository.getPeople(id);
        if (originalPeople == null){
            return null;
        }
        Map<String, Object> reducedPeople = peopleReducer(originalPeople);

        return reducedPeople;
    }

    public static Map peopleReducer (Map<String, Object> originalPeople) {
        Map<String, String> reducedPeople = new HashMap<>();
        String name = originalPeople.get("name").toString();
        reducedPeople.put("name", name);
        String gender = originalPeople.get("gender").toString();
        reducedPeople.put("gender", gender);
        reducedPeople.put("nameWithGender", name + " (" + gender + ")");
        reducedPeople.put("height", originalPeople.get("height").toString());

        return reducedPeople;
    }

    public Map getAllPeople (Integer page, String originUrl){
        Map<String, Object> originalAllPeople = this.swapiRepository.getAllPeople(page);
        Map<String, Object> reducedAllPeople = allPeopleReducer(originalAllPeople, originUrl);

        return reducedAllPeople;
    }

    public Map allPeopleReducer (Map<String, Object> originalAllPeople, String originUrl) {
        Map<String, Object> reducedAllPeople = new HashMap<>  ();
        reducedAllPeople.put("count", originalAllPeople.get("count"));
        String adjustNextUrl = getAdjustNextPreviousUrl((String)originalAllPeople.get("next"), originUrl);
        reducedAllPeople.put("next", adjustNextUrl);

        String adjustPreviousUrl = getAdjustNextPreviousUrl((String)originalAllPeople.get("previous"), originUrl);
        reducedAllPeople.put("previous", adjustPreviousUrl);

        ArrayList<Map> reducedResults = getReducedResults ((ArrayList<Map>)originalAllPeople.get("results"));
        reducedAllPeople.put("results", reducedResults);

        return reducedAllPeople;
    }

    private ArrayList<Map> getReducedResults (ArrayList<Map> originalResults) {
        return (ArrayList<Map>) originalResults.stream()
                .map(SwapiService::peopleReducer)
                .collect(Collectors.toList());
    }

    private String getAdjustNextPreviousUrl (String originalNextPreviousURL, String originUrl){
        String adjustUrl = null;
        if (originalNextPreviousURL != null){
            adjustUrl = originUrl + "?" + UriComponentsBuilder.fromUriString(originalNextPreviousURL).build().getQuery();
        }
        return adjustUrl;
    }

}
