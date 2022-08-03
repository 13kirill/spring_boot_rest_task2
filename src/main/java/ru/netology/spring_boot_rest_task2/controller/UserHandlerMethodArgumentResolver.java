package ru.netology.spring_boot_rest_task2.controller;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.spring_boot_rest_task2.model.User;

public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getGenericParameterType().equals(User.class);
    }

    @Override
    public User resolveArgument(MethodParameter parameter,
                                ModelAndViewContainer mavContainer,
                                NativeWebRequest webRequest,
                                WebDataBinderFactory binderFactory) throws Exception {
String user = webRequest.getParameter("user");
String password = webRequest.getParameter("password");
return new User(user, password);
        }
}