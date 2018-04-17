package be.niels.jpaskeleton.domain.address;

import be.niels.jpaskeleton.Application;
import javafx.geometry.Pos;
import oracle.jdbc.proxy.annotation.Post;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PostalCodeRepositoryTest {

    @Autowired
    private PostalCodeRepository postalCodeRepository;

    @Test
    @Transactional
    public void savePostalCode() {
        PostalCode pc = new PostalCode(1050, "Ixelles");

        postalCodeRepository.savePostalCode(pc);

        Assertions.assertThat(postalCodeRepository.findPostalCode(1050)).isEqualToComparingFieldByField(pc);
    }

//    @Test
//    public void findPostalCode() {
//    }
}