package guru.framework.recipeapp.services;

import guru.framework.recipeapp.domain.Difficulty;
import guru.framework.recipeapp.domain.Recipe;
import guru.framework.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() throws Exception{
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);
        recipe.setDifficulty(Difficulty.MODERATE);
        Recipe recipe1 = new Recipe();
        recipes.add(recipe);
        recipes.add(recipe1);
        when(recipeService.getRecipes()).thenReturn(recipes);
        int actualSize = 2;
        assertEquals(recipeService.getRecipes().size() , actualSize);
        verify(recipeRepository , times(1)).findAll();
    }
}