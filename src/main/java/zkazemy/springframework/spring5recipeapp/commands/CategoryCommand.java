package zkazemy.springframework.spring5recipeapp.commands;

/**
 * Created by jt on 6/21/17.
 */

public class CategoryCommand {
    private Long id;
    private String description;

    public CategoryCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
