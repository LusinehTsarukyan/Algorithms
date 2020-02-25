package DivideAndConquerSortingAndSearchingAndRandomizedAlgorithms.week2;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class InversionsTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Inversions.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void inversionsTest() {

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(2);
        arr.add(4);
        arr.add(6);

        assertEquals(3, Inversions.invWrapper(arr));
    }
}
