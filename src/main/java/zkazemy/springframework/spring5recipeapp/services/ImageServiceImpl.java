package zkazemy.springframework.spring5recipeapp.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import zkazemy.springframework.spring5recipeapp.domain.Recipe;
import zkazemy.springframework.spring5recipeapp.repositories.RecipeRepository;

import java.io.IOException;

/**
 * Created by jt on 7/3/17.
 */

@Service
public class ImageServiceImpl implements ImageService {
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl( RecipeRepository recipeService) {

        this.recipeRepository = recipeService;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {

        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);

            recipeRepository.save(recipe);
        } catch (IOException e) {
            //todo handle better
//            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}
