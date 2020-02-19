package guru.framework.recipeapp.controllers;

import guru.framework.recipeapp.domain.Difficulty;
import guru.framework.recipeapp.domain.Notes;
import guru.framework.recipeapp.domain.Recipe;
import guru.framework.recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RecipeControllerTest {

    RecipeController recipeController;

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isNotFound());

        mockMvc.perform(get("/recipe-app/recipes"))
                .andExpect(status().isOk())
                .andExpect(view().name("/recipe/index"));
    }

    @Test
    public void getRecipes() {

        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        Recipe recipe2 = new Recipe();
        recipe2.setDifficulty(Difficulty.MODERATE);
        recipe2.setNotes( new Notes());
        recipes.add(recipe2);

        when(recipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
        //when
        String expectedString = "/recipe/index";
        String viewReturned = recipeController.getRecipes(model);

        //then
        assertEquals(expectedString, viewReturned);
        verify(recipeService , times(1)).getRecipes();
        verify(model , times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        int expectedSize = 2;
        assertEquals(expectedSize , setInController.size());
    }
}