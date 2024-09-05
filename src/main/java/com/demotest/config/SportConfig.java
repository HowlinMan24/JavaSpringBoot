package com.demotest.config;

import com.demotest.common.interfacesComponents.Coach;
import com.demotest.common.components.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  This is a `Configuration class` that can be used by the Spring IoC(Inversion of Control) container to generate and manage beans.
 *  This is similar to an XML file(Used in older and legacy projects because) for configuration which allows you to configure your
 *  beans, but it can be done with java.
 *  This can be done by adding the annotation `@Configuration` above the class name.
 *  Within this class you can define methods annotated with `@Beans` which will create an instance of an object which will be managed
 *  by Spring bean.
 *  The method names are used as default name for the beans but if used in this way `@Beans("Name you want to use")` you can se the name
 *  and these beans can be injected into other component.
 *  The beans created by default are `Singleton` and the class itself is also a `Singleton`.
 *  There are 2 types of configuration `full` and `lite` configuration.
 *  The `full` configuration means tact Spring will enhance the class at runtime to ensure that the beans are properly managed, even
 *  when they have dependencies on other beans within the same configuration class.
 *  The `lite` configuration means that the `@Configuration` is removed, by doing this Spring does not enhance the class and method calls
 *  won't return the same bean instance.
 *  By doing:
 *  `@ComponentScan(basePackages = 'com.example')`
 *  `@Component`
 *  This would scan the specified package for components, including any classes annotated with `@Configuration`.
 *  `@Scope(ConfigurableBeanFactory.(SCOPE_PROTOTYPE/SCOPE_SINGLETON))` with this annotation it can set either singleton or prototype.
 */

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
