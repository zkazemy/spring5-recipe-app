package zkazemy.springframework.spring5recipeapp.commands;


/**
 * Created by jt on 6/21/17.
 */

public class NotesCommand {
    private Long id;
    private String recipeNotes;

    public NotesCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
