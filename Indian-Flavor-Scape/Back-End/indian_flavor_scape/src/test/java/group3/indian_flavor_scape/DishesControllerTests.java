package group3.indian_flavor_scape;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import group3.indian_flavor_scape.controller.DishesController;
import group3.indian_flavor_scape.model.Entities.Additives;
import group3.indian_flavor_scape.model.Entities.Main;
import group3.indian_flavor_scape.model.Entities.Sides;
import group3.indian_flavor_scape.model.Requests.AddsAndSidesRequestJson;
import group3.indian_flavor_scape.repositories.AdditivesRepository;
import group3.indian_flavor_scape.repositories.MainDishesRepository;
import group3.indian_flavor_scape.repositories.SidesRepository;

public class DishesControllerTests {

    private DishesController dishesController;

    @Mock
    private MainDishesRepository mainDishesRepository;

    @Mock
    private AdditivesRepository additivesRepository;

    @Mock
    private SidesRepository sidesRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dishesController = new DishesController();
        dishesController.setMainDishesRepository(mainDishesRepository);
        dishesController.setAdditivesRepository(additivesRepository);
        dishesController.setSidesRepository(sidesRepository);
    }

    @Test
    void testGetAllMainDishes() {
        List<Main> mainDishesList = new ArrayList<>();
        mainDishesList.add(new Main(1, "Rice"));
        mainDishesList.add(new Main(2, "Bread"));
        when(mainDishesRepository.findAll()).thenReturn(mainDishesList);
        Map<String, List<Map<String, Object>>> response = dishesController.getAllMainDishes();
        assertNotNull(response);
        assertTrue(response.containsKey("mainDishes"));
        List<Map<String, Object>> mainDishes = response.get("mainDishes");
        //Asserting response Size
        assertEquals(mainDishesList.size(), mainDishes.size());
        Main mainDish = mainDishesList.get(0);
        Map<String, Object> mainDishMap = mainDishes.get(0);
        assertEquals(mainDish.getId(), mainDishMap.get("id"));
        assertEquals(mainDish.getName(), mainDishMap.get("name"));
    }

    @Test
    void testGetAdditives() {
        int mainDishId = 1;
        Main mainDish = new Main(mainDishId, "Main Dish");
        List<Additives> additivesList = new ArrayList<>();
        additivesList.add(new Additives("Chicken", mainDish));
        additivesList.add(new Additives("Goat", mainDish));
        long longMainDishId = mainDishId;
        AddsAndSidesRequestJson requestJson = new AddsAndSidesRequestJson();
        requestJson.setId(longMainDishId);
        when(mainDishesRepository.findByid(longMainDishId)).thenReturn(mainDish);
        when(additivesRepository.findByMain(mainDish)).thenReturn(additivesList);
        Map<String, List<Map<String, Object>>> response = dishesController.getAdditives(requestJson);
        assertNotNull(response);
        assertTrue(response.containsKey("additives"));
        List<Map<String, Object>> additives = response.get("additives");
        assertEquals(additivesList.size(), additives.size());
        for (int i = 0; i < additivesList.size(); i++) {
            Additives additive = additivesList.get(i);
            Map<String, Object> additiveMap = additives.get(i);
            assertEquals(additive.getId(), additiveMap.get("id"));
            assertEquals(additive.getName(), additiveMap.get("name"));
            assertEquals(additive.getMain().getId(), additiveMap.get("mainId"));
        }
    }

    @Test
    void testGetAllSides() {
        int mainDishId = 1;
        Main mainDish = new Main(mainDishId, "Main Dish");
        List<Sides> sidesList = new ArrayList<>();
        sidesList.add(new Sides("Curry", mainDish));
        sidesList.add(new Sides("Curd", mainDish));
        long longMainDishId = mainDishId;
        AddsAndSidesRequestJson requestJson = new AddsAndSidesRequestJson();
        requestJson.setId(longMainDishId);
        when(mainDishesRepository.findByid(longMainDishId)).thenReturn(mainDish);
        when(sidesRepository.findByMain(mainDish)).thenReturn(sidesList);
        Map<String, List<Map<String, Object>>> response = dishesController.getAllSides(requestJson);
        assertNotNull(response);
        assertTrue(response.containsKey("sides"));
        List<Map<String, Object>> sides = response.get("sides");
        assertEquals(sidesList.size(), sides.size());
        for (int i = 0; i < sidesList.size(); i++) {
            Sides side = sidesList.get(i);
            Map<String, Object> sideMap = sides.get(i);
            assertEquals(side.getId(), sideMap.get("id"));
            assertEquals(side.getName(), sideMap.get("name"));
            assertEquals(side.getMain().getId(), sideMap.get("mainId"));
        }
    }
}
