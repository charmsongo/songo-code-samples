package com.songo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class JavaCoreApplicationTests  {

    //@Mock
    //private List mockList;
    @Test
    void contextLoads() {

        String word = "mocked return";
        List mock = Mockito.mock(List.class);

        Mockito.when(mock.get(Mockito.anyInt())).thenReturn(word);

        System.out.println(mock.get(999));
        Mockito.verify(mock).get(Mockito.anyInt());
    }

}
