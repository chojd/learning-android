package cn.com.ofashion.nativerouter.redirector;

import java.net.URI;

final class MStoreRedirector extends AbsRouteRedirector {
    @Override
    String standardScheme() {
        return Scheme.MStore;
    }
}
