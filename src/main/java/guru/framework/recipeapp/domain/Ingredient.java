package guru.framework.recipeapp.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount ;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure ;

    @ManyToOne
    private Recipe recipe;

    public Ingredient(){

    }
    public Ingredient(String description , BigDecimal amount , UnitOfMeasure uom , Recipe recipe){
        this.unitOfMeasure = uom ;
        this.description = description;
        this.amount = amount ;
        this.recipe = recipe ;
    }
    public Ingredient(String description , BigDecimal amount , UnitOfMeasure uom){
        this.unitOfMeasure = uom ;
        this.description = description;
        this.amount = amount ;
    }

}
