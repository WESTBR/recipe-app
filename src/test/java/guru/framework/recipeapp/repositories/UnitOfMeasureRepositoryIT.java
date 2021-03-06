package guru.framework.recipeapp.repositories;

import guru.framework.recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository uomRepository ;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByDescription() throws Exception{
        String expectedDescription = "Teaspoon";
        Optional<UnitOfMeasure> unitOfMeasureOptional = uomRepository.findByDescription("Teaspoon");
        assertEquals(expectedDescription , unitOfMeasureOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() throws Exception{
        String expectedDescription = "Cup";
        Optional<UnitOfMeasure> unitOfMeasureOptional = uomRepository.findByDescription("Cup");
        assertEquals(expectedDescription , unitOfMeasureOptional.get().getDescription());
    }
}