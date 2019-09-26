package com.tchokoapps.springboot.springcorespringmvc;

import com.tchokoapps.springboot.springcorespringmvc.config.JpaIntegrationConfig;
import com.tchokoapps.springboot.springcorespringmvc.domain.Customer;
import com.tchokoapps.springboot.springcorespringmvc.services.CutstomerServiceJpaDao;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@Import(JpaIntegrationConfig.class)
public class CutstomerServiceJpaDaoImplTest {

    private CutstomerServiceJpaDao cutstomerServiceJpaDao;

    @Autowired
    public void setCutstomerServiceJpaDao(CutstomerServiceJpaDao cutstomerServiceJpaDao) {
        this.cutstomerServiceJpaDao = cutstomerServiceJpaDao;
    }

    @Test
    public void listAll_shouldReturn_3_customers() {
        List<Customer> customers = (List<Customer>) cutstomerServiceJpaDao.listAll();
        Assertions.assertThat(customers.size()).isEqualTo(3);
    }
}
