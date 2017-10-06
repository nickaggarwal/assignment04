package com.greglturnquist.payroll;

/**
 * Created by Nilesh on 04/08/17.
 */
import com.greglturnquist.payroll.model.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Product.class);
        config.setReturnBodyForPutAndPost(Boolean.TRUE);
    }

}
