package zkazemy.springframework.spring5recipeapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();
}
