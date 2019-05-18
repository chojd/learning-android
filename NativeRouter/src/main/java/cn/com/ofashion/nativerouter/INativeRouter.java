package cn.com.ofashion.nativerouter;

import java.util.List;

public interface INativeRouter {

    int registerSubRouter(INativeSubRouter subRouter);
    int removeSubRouter(INativeSubRouter subRouter);
    List<INativeSubRouter> registeredSubRouters();

    int registerRedirector(IRouteRedirection redirection);
    int removeRedirector(IRouteRedirection redirection);
    List<IRouteRedirection> registeredRedirectors();

}
