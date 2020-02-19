package guru.framework.recipeapp.domain;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class CategoryTest {

    Category category ;
    @Before
    public void setUp() throws Exception {
        category = new Category();
        category.setId(4l);
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 4l ;
        assertEquals(idValue , category.getId());
    }

    @Test
    public void getDescription() throws Exception{
    }
}