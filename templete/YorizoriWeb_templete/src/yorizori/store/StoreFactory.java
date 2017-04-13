package yorizori.store;

public interface StoreFactory {
    
    CookbookStore getCookbookDao();
    RecipeStore getRecipeDao();
    UserStore getUserDao();
}
