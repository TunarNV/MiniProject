package user.impl.jsonuserimpl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import user.entity.User;
import user.service.jsonuserservice.IUserPersistence;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUserImpl implements IUserPersistence {
    private final String filePath = "users.json";

    @Override
    public List<User> loadUsers() {
        try (Reader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type userListType = new TypeToken<List<User>>() {}.getType();
            List<User> loadedUsers = gson.fromJson(reader, userListType);
            return loadedUsers != null ? loadedUsers : new ArrayList<>();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void saveUsers(List<User> users) {
        try (Writer writer = new FileWriter(filePath)) {
            Gson gson = new Gson();
            gson.toJson(users, writer);
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
}
