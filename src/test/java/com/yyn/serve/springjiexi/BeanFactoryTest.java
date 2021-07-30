package com.yyn.serve.springjiexi;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

    @Test
    public void testSirnpleLoad(){
        final ClassPathResource resource = new ClassPathResource("MyTestBean.xml");
        final XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);

        final MyTestBean myTestBean =(MyTestBean) xmlBeanFactory.getBean("myTestBean");
        assert myTestBean.getS().equals("test");
    }
}
