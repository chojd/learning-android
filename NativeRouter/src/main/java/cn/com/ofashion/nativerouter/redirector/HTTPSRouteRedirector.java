package cn.com.ofashion.nativerouter.redirector;

import java.net.URI;

final class HTTPSRouteRedirector extends AbsRouteRedirector {
    @Override
    String standardScheme() {
        return Scheme.HTTPS;
    }
}
