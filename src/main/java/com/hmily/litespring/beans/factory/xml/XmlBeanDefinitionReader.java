package com.hmily.litespring.beans.factory.xml;

import com.hmily.litespring.beans.BeanDefinition;
import com.hmily.litespring.beans.PropertyValue;
import com.hmily.litespring.beans.RuntimeBeanReference;
import com.hmily.litespring.beans.TypeStringValue;
import com.hmily.litespring.beans.factory.BeanDefinitionStoreException;
import com.hmily.litespring.beans.factory.support.BeanDefinitionRegistry;
import com.hmily.litespring.beans.factory.support.GenericBeanDefinition;
import com.hmily.litespring.core.io.Resource;
import com.hmily.litespring.util.ClassUtils;
import com.hmily.litespring.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by zyzhmily on 2018/7/14.
 */
public class XmlBeanDefinitionReader {

    public static final String ID_ATTRIBUTE="id";

    public static final String CLASS_ATTRIBUTE="class";

    public static final String SCOPE_ATTRIBUTE="scope";

    public static final String PROPERTY_ELEMENT="property";

    public static final String REF_ATTRIBUTE="ref";

    public static final String VALUE_ATTRIBUTE="value";

    public static final String NAME_ATTRIBUTE="name";

    protected final Log logger= LogFactory.getLog(getClass());

    BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry){
        this.registry=registry;
    }

    public void loadBeanDefinitions(Resource resource){
        InputStream is=null;
        try {
            ClassLoader cl= ClassUtils.getDefaultClassLoader();
            is=resource.getInputStream();
            SAXReader reader=new SAXReader();
            Document doc=reader.read(is);

            Element root=doc.getRootElement();
            Iterator<Element> iter =root.elementIterator();
            while (iter.hasNext()){
                Element ele=(Element) iter.next();
                String  id=ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName=ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd=new GenericBeanDefinition(id,beanClassName);
                if (ele.attribute(SCOPE_ATTRIBUTE)!=null){
                     bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
                }
                parsePropertyElement(ele,bd);
                this.registry.registerBeanDefinition(id,bd);
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from " + resource.getDescription(),e);
        }finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void parsePropertyElement(Element element,BeanDefinition bd){
        Iterator iter=element.elementIterator(PROPERTY_ELEMENT);
        while (iter.hasNext()){
            Element propElem= (Element) iter.next();
            String propertyName=propElem.attributeValue(NAME_ATTRIBUTE);
            if (!StringUtils.hasLength(propertyName)){
                logger.fatal("Tag 'property' must have a 'name' attribute");
                return;
            }
            Object val=parsePropertyValue(propElem,bd,propertyName);
            PropertyValue pv=new PropertyValue(propertyName,val);
            bd.getPropertyValues().add(pv);
        }
    }

    public Object parsePropertyValue(Element propElem, BeanDefinition bd, String propertyName) {
        String elementName=(propertyName!=null)?"<property> element for property '"+propertyName+"'":"<constructor-arg> element";
        boolean hasRefAttribute=(propElem.attributeValue(REF_ATTRIBUTE)!=null);
        boolean hasValueAttribute=(propElem.attributeValue(VALUE_ATTRIBUTE)!=null);
        if (hasRefAttribute){
            String refName=propElem.attributeValue(REF_ATTRIBUTE);
            if (!StringUtils.hasText(refName)){
                logger.error(elementName+"contains empty 'ref' attribute");
            }
            RuntimeBeanReference ref=new RuntimeBeanReference(refName);
            return ref;
        }else if (hasValueAttribute){
            TypeStringValue valueHolder=new TypeStringValue(propElem.attributeValue(VALUE_ATTRIBUTE));
            return  valueHolder;
        }else {
            throw new RuntimeException(elementName+" must specify a ref or value");
        }
    }

}
