package zkazemy.springframework.spring5recipeapp.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import zkazemy.springframework.spring5recipeapp.commands.CategoryCommand;
import zkazemy.springframework.spring5recipeapp.domain.Category;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Nullable
    @Override
    public synchronized CategoryCommand convert(Category source) {
        if (source == null) {
            return null;
        }

        final CategoryCommand categoryCommand = new CategoryCommand();

        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());

        return categoryCommand;
    }
}
