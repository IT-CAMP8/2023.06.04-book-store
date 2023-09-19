package pl.camp.it.book.store.configuration;

import org.hibernate.SessionFactory;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.camp.it.book.store.database.*;

@Configuration
@ComponentScan(basePackages = {
        "pl.camp.it.book.store.services",
        "pl.camp.it.book.store.session"
})
public class TestConfiguration {

    /*@Bean
    public IBookDAO bookDAO() {
        return Mockito.mock(IBookDAO.class);
    }

    @Bean
    public IOrderDAO orderDAO() {
        return Mockito.mock(IOrderDAO.class);
    }

    @Bean
    public IUserRepository userRepository() {
        return Mockito.mock(IUserRepository.class);
    }

    @Bean
    public IOrderPositionDAO orderPositionDAO() {
        return Mockito.mock(IOrderPositionDAO.class);
    }*/
}
