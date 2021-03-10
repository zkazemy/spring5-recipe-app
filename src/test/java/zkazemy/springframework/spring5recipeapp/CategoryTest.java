package zkazemy.springframework.spring5recipeapp;

//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//import zkazemy.springframework.spring5recipeapp.domain.Category;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import zkazemy.springframework.spring5recipeapp.domain.Category;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(JUnit4.class)
public class CategoryTest {
    Category category;

    @Before
    public void setUp()
    {
        category = new Category();
    }

    @Test
    public void getId()throws Exception
    {
        Long idValue = 1L;
        category.setId(1L);
        assertEquals(idValue, category.getId());
    }
}
