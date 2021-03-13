package zkazemy.springframework.spring5recipeapp.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import zkazemy.springframework.spring5recipeapp.commands.NotesCommand;
import zkazemy.springframework.spring5recipeapp.domain.Notes;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {


    @Nullable
    @Override
    public synchronized Notes convert(NotesCommand source) {
        if(source == null) {
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
