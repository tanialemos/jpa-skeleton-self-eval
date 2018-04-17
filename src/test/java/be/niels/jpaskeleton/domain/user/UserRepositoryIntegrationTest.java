package be.niels.jpaskeleton.domain.user;

import be.niels.jpaskeleton.Application;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser() {
        User savedUser = userRepository.save(new User("Mickey"));

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isNotZero();
    }

    @Test
    public void getUsers() {
        List<User> initialUsers = userRepository.getUsers();

        userRepository.save(new User("PewPew"));

        Assertions.assertThat(initialUsers.size() + 1 )
                .isEqualTo(userRepository.getUsers().size());
    }

}