package cn.com.ofashion.httpservice;

import dagger.Component;

@Component(modules = HTTPModule.class)
interface HTTPComponent {
    HTTPRequest httpRequest();
}
