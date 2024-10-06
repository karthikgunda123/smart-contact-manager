package com.scm.scm2_0.services.impl;

import com.scm.scm2_0.entities.User;
import com.scm.scm2_0.helpers.AppConstants;
import com.scm.scm2_0.helpers.ResourceNotFoundException;
import com.scm.scm2_0.repositories.UserRepository;
import com.scm.scm2_0.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        // User if : have to generate
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleList(List.of(AppConstants.ROLE_USER));

        logger.info(user.getProvider().toString());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user1 = userRepository.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found!"));

        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setAbout(user.getAbout());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setProfilePic(user.getProfilePic());
        user1.setEnabled(user.isEnabled());
        user1.setEmailVerified(user.isEmailVerified());
        user1.setPhoneVerified(user.isPhoneVerified());
        user1.setProvider(user.getProvider());
        user1.setProviderUserId(user.getProviderUserId());

        User savedUser = userRepository.save(user1);
        return Optional.ofNullable(savedUser);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found!"));
        userRepository.delete(user);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        return user != null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}
