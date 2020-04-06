package service;

import domain.entity.User;
import domain.models.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import repository.UserRepository;

import javax.inject.Inject;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveUser(UserServiceModel user) {
        userRepository.saveUser(modelMapper.map(user, User.class));
    }

    @Override
    public UserServiceModel findUser(String username, String password) {
        try {
            return modelMapper.map(userRepository.findUser(username, password), UserServiceModel.class);
        }catch (Exception e){
            return null;
        }
    }
}
