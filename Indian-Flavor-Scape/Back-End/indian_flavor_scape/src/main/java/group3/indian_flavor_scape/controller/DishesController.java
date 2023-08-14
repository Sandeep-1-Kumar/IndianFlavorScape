package group3.indian_flavor_scape.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group3.indian_flavor_scape.model.Entities.Additives;
import group3.indian_flavor_scape.model.Entities.Main;
import group3.indian_flavor_scape.model.Entities.Sides;
import group3.indian_flavor_scape.model.Requests.AddsAndSidesRequestJson;
import group3.indian_flavor_scape.repositories.AdditivesRepository;
import group3.indian_flavor_scape.repositories.MainDishesRepository;
import group3.indian_flavor_scape.repositories.SidesRepository;

@CrossOrigin
@RestController
@RequestMapping(path="/IndianFlavorScape")

public class DishesController {
    @Autowired
    private  MainDishesRepository mainDishesRepository;
    
    @Autowired
    private AdditivesRepository additivesRepository;

    @Autowired
    private SidesRepository sidesRepository;

    //This method takes care of the retriving main dishes from DB
    @GetMapping(path = "/menu/getMainDishes")
    public Map<String, List<Map<String, Object>>> getAllMainDishes() {
        List<Main> mainDishesList = new ArrayList<Main>();
        //Queue implementation
        mainDishesList =  mainDishesRepository.findAll();
        Queue<Map<String, Object>> mainDishesQueue = new LinkedList<>();
        for (Main maindishes : mainDishesList) {
            //Map implementation
            Map<String, Object> maindishesMap = new HashMap<>();
            maindishesMap.put("id", maindishes.getId());
            maindishesMap.put("name", maindishes.getName());
            maindishesMap.put("urlImage", maindishes.getImage_url());
            mainDishesQueue.offer(maindishesMap);
        }
        Map<String, List<Map<String, Object>>> mainDishesResponseJson
        = new HashMap<>();
        mainDishesResponseJson.put("mainDishes", new ArrayList<>(mainDishesQueue));
        return mainDishesResponseJson;
    }
    //This method takes care of the retriving additives specific for main dishes from DB
    @PostMapping(path = "/menu/getAdditives")
    public Map<String, List<Map<String, Object>>> getAdditives
    (@RequestBody  AddsAndSidesRequestJson addsAndSidesRequestJson) {
        List<Additives> additivesList = new ArrayList<Additives>();
        //Queue implementation
        Main main = mainDishesRepository.findByid
        (addsAndSidesRequestJson.getId());
        additivesList =  additivesRepository.findByMain(main);
        Queue<Map<String, Object>> additivesQueue = new LinkedList<>();
        for (Additives additives : additivesList) {
            //Map implementation
            Map<String, Object> additivesMap = new HashMap<>();
            additivesMap.put("id", additives.getId());
            additivesMap.put("name", additives.getName());
            additivesMap.put("mainId", additives.getMain().getId());
            additivesMap.put("urlImage",additives.getImage_url());
            additivesQueue.offer(additivesMap);
        }
        Map<String, List<Map<String, Object>>> additivesResponseJson = 
        new HashMap<>();
        additivesResponseJson.put("additives",
        new ArrayList<>(additivesQueue));
        return additivesResponseJson;
    }
    //This method takes care of the retriving sides specific for main dishes from DB
    @PostMapping(path = "/menu/getSides")
    public Map<String, List<Map<String, Object>>> getAllSides
    (@RequestBody  AddsAndSidesRequestJson addsAndSidesRequestJson) {
        List<Sides> sidesList = new ArrayList<Sides>();
        //Queue implementation
        Main main = mainDishesRepository.findByid
        (addsAndSidesRequestJson.getId());
        sidesList =  sidesRepository.findByMain(main);
        Queue<Map<String, Object>> sidesQueue = new LinkedList<>();
        for (Sides sides : sidesList) {
            //Map implementation
            Map<String, Object> sidesMap = new HashMap<>();
            sidesMap.put("id", sides.getId());
            sidesMap.put("name", sides.getName());
            sidesMap.put("mainId",sides.getMain().getId());
            sidesMap.put("urlImage", sides.getImage_url());
            sidesQueue.offer(sidesMap);
        }
        Map<String, List<Map<String, Object>>> sidesResponseJson = 
        new HashMap<>();
        sidesResponseJson.put("sides", new ArrayList<>(sidesQueue));
        return sidesResponseJson;
    }
//These below set methods are used in to set repositories in order to mock during test cases 
    public void setMainDishesRepository
    (MainDishesRepository mainDishesRepository2) {
        this.mainDishesRepository = mainDishesRepository2;
    }

    public void setAdditivesRepository
    (AdditivesRepository additivesRepository2) {
        this.additivesRepository = additivesRepository2;
    }

    public void setSidesRepository
    (SidesRepository sidesRepository2) {
        this.sidesRepository = sidesRepository2;
    }
}
