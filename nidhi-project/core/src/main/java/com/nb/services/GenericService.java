package com.nb.services;

import java.util.Dictionary;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        immediate = true,
        enabled = true,
        label = "Nidhi Generic Service",
        description = "Generic OSGi service",
        metatype = true)
@Properties({
        @Property(
                label = "Base Path",
                name = GenericService.LIST_BASE_PATH,
                description = "This will provide base path for List")})
@Service(value = GenericService.class)
public class GenericService {

    /** The LOGGER Constant. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericService.class);

    /** The Constant BREVILLE_LIST_BASE_PATH. */
    public static final String LIST_BASE_PATH = "base.path";

    /** The properties. */
    @SuppressWarnings("rawtypes")
    private Dictionary properties;
    
    /** The resolver factory. */
    @Reference
    private ResourceResolverFactory resolverFactory;

    private String path;
    /**
     * Activate.
     *
     * @param context the context
     */
    @SuppressWarnings("unchecked")
    @Activate
    protected final void activate(final ComponentContext context) {
    	properties = context.getProperties();
    	path = (String) properties.get(LIST_BASE_PATH);
    }
    
    public String getPath(){
    	return path;
    }
    

    

}
