package guru.springframework.repositories;

import guru.springframework.configuration.RepositoryConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lemmanet.domain.Member;
import com.lemmanet.repositories.MemberRepository;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ProductRepositoryTest {

    private MemberRepository productRepository;

    @Autowired
    public void setProductRepository(MemberRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    public void testSaveProduct(){
        //setup product
        Member product = new Member();
        product.setDescription("Spring Framework Guru Shirt");
        product.setAge(Integer.valueOf(18));
        product.setMemberId("1234");

        //save product, verify has ID value after save
        assertNull(product.getId()); //null before save
        productRepository.save(product);
        assertNotNull(product.getId()); //not null after save
        //fetch from DB
        Member fetchedProduct = productRepository.findById(product.getId()).orElse(null);

        //should not be null
        assertNotNull(fetchedProduct);

        //should equal
        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());

        //update description and save
        fetchedProduct.setDescription("New Description");
        productRepository.save(fetchedProduct);

        //get from DB, should be updated
        Member fetchedUpdatedProduct = productRepository.findById(fetchedProduct.getId()).orElse(null);
        assertEquals(fetchedProduct.getDescription(), fetchedUpdatedProduct.getDescription());

        //verify count of products in DB
        long productCount = productRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<Member> products = productRepository.findAll();

        int count = 0;

        for(Member p : products){
            count++;
        }

        assertEquals(count, 1);
    }
}
